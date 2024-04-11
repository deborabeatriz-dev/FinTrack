package br.fintrack.controllers;

import br.fintrack.exception.*;
import br.fintrack.models.User;
import br.fintrack.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  /*
   * Lista todos os usuários
   */
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Lista de usuários retornada com sucesso")
  })
  @ApiOperation(value = "Lista todos os usuários", notes = "Recupera uma lista de todos os usuários cadastrados")
  @GetMapping("/users")
  public List<User> listUsers() {
    return userRepository.findAll();
  }

  /*
   * Lista um usuário específico pelo Id
   */
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Usuário encontrado"),
      @ApiResponse(code = 404, message = "Usuário não encontrado")
  })
  @ApiOperation(value = "Lista um usuário específico pelo ID", notes = "Recupera as informações de um usuário com base no seu ID")
  @GetMapping("/users/{idUsuario}")
  public User listUserById(@PathVariable(value = "idUsuario") short idUsuario) throws ResourceNotFoundException {
    return userRepository.findById(idUsuario)
        .orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado."));
  }

  /*
   * Cria um novo usuário
   */
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "Usuário criado com sucesso"),
      @ApiResponse(code = 500, message = "Erro interno do servidor")
  })
  @ApiOperation(value = "Cria um novo usuário", notes = "Cria um novo usuário com base nos detalhes fornecidos")
  @PostMapping("/users")
  @ResponseStatus(value = HttpStatus.CREATED)
  public User createUser(@Valid @RequestBody User user) throws InternalServerErrorException {
    try {
      return userRepository.save(user);
    } catch (Exception e) {
      throw new InternalServerErrorException("Falha ao criar usuário.");
    }
  }

  /*
   * Atualiza um usuário
   */
  @ApiOperation(value = "Atualiza um usuário existente", notes = "Atualiza as informações de um usuário com base no seu ID")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Usuário atualizado com sucesso"),
      @ApiResponse(code = 400, message = "Requisição inválida"),
      @ApiResponse(code = 404, message = "Usuário não encontrado"),
      @ApiResponse(code = 500, message = "Erro interno do servidor")
  })
  @PutMapping("/users/{idUsuario}")
  public ResponseEntity<User> updateUser(@PathVariable(value = "idUsuario") short idUsuario,
      @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
    User user = userRepository.findById(idUsuario)
        .orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado."));

    if (userDetails.getEmail() != null) {
      user.setEmail(userDetails.getEmail());
    }
    if (userDetails.getDataNascimento() != null) {
      user.setDataNascimento(userDetails.getDataNascimento());
    }
    if (userDetails.getNome() != null) {
      user.setNome(userDetails.getNome());
    }

    final User updatedUser = userRepository.save(user);
    return ResponseEntity.ok(updatedUser);
  }

  /*
   * Deleta um usuário
   */
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Usuário deletado com sucesso"),
      @ApiResponse(code = 404, message = "Usuário não encontrado para exclusão")
  })
  @ApiOperation(value = "Deleta um usuário", notes = "Deleta um usuário com base no seu ID")
  @DeleteMapping("/users/{idUsuario}")
  public Map<String, Boolean> deleteUser(@PathVariable(value = "idUsuario") short idUsuario) throws ResourceNotFoundException {
    try {
      userRepository.deleteById(idUsuario);
    } catch (Exception e) {
      throw new ResourceNotFoundException("Usuário não encontrado para exclusão");
    }
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    response.put("error", Boolean.FALSE);
    return response;
  }
}