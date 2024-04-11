package br.fintrack.controllers;

import br.fintrack.exception.*;
import br.fintrack.models.User;
import br.fintrack.repositories.UserRepository;
import org.springframework.http.HttpStatus;

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
  @GetMapping("/users")
  public List<User> listUsers() {
    return userRepository.findAll();
  }

  /*
   * Lista um usuário específico pelo Id
   */
  @GetMapping("/users/{idUsuario}")
  public User listUserById(@PathVariable(value = "idUsuario") short idUsuario) throws ResourceNotFoundException {
    return userRepository.findById(idUsuario)
        .orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado."));
  }

  /*
   * Cria um novo usuário
   */
  @PostMapping("/users")
  @ResponseStatus(value = HttpStatus.CREATED)
  public User createUser(@Valid @RequestBody User user) throws InternalServerErrorException{
    try {
      return userRepository.save(user);
    } catch (Exception e) {
      throw new InternalServerErrorException("Falha ao criar usuário.");
    }
  }

  /*
   * Atualiza um usuário
   */
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
  @DeleteMapping("/users/{idUsuario}")
  public Map<String, Boolean> deleteUser(@PathVariable(value = "idUsuario") short idUsuario) {
    try {
      userRepository.deleteById(idUsuario);
    } catch (Exception e) {
      Map<String, Boolean> response = new HashMap<>();

      response.put("deleted", Boolean.FALSE);
      response.put("error", Boolean.TRUE);
      return response;
    }
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    response.put("error", Boolean.FALSE);
    return response;
  }
}