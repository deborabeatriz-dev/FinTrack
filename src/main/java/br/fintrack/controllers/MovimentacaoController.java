package br.fintrack.controllers;

import br.fintrack.exception.InternalServerErrorException;
import br.fintrack.exception.ResourceNotFoundException;
import br.fintrack.models.Movimentacao;
import br.fintrack.repositories.MovimentacaoRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class MovimentacaoController {
        @Autowired
        private MovimentacaoRepository movimentacaoRepository;

        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Lista de movimentações retornada com sucesso")
        })
        @ApiOperation(value = "Lista todos as movimentações", notes = "Recupera uma lista de todas as movimentações cadastradas")
        @GetMapping("/movimentacoes")
        public List<Movimentacao> listMovimentacoes() {
            return movimentacaoRepository.findAll();
        }

        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Movimentacão encontrada"),
                @ApiResponse(code = 404, message = "Movimentacão não encontrada")
        })
        @ApiOperation(value = "Lista uma Movimentacão específica pelo ID", notes = "Recupera as informações de uma movimentacão com base no seu ID")
        @GetMapping("/movimentacoes/{movimentacaoId}")
        public Movimentacao listMovimentacaoById(@PathVariable(value = "movimentacaoId") short movimentacaoId) throws ResourceNotFoundException {
            return movimentacaoRepository.findById(movimentacaoId)
                    .orElseThrow(() -> new ResourceNotFoundException("Movimentacão não encontrada."));
        }

        @ApiResponses(value = {
                @ApiResponse(code = 201, message = "Movimentação criado com sucesso"),
                @ApiResponse(code = 500, message = "Erro interno do servidor")
        })
        @ApiOperation(value = "Cria uma nova movimentação", notes = "Cria uma nova movimentação com base nos detalhes fornecidos")
        @PostMapping("/movimentacoes")
        @ResponseStatus(value = HttpStatus.CREATED)
        public Movimentacao createMovimentacao(@Valid @RequestBody Movimentacao movimentacao) throws InternalServerErrorException {
            try {
                return movimentacaoRepository.save(movimentacao);
            } catch (Exception e) {
                throw new InternalServerErrorException("Falha ao criar movimentação.");
            }
        }

        @ApiOperation(value = "Atualiza uma movimentação existente", notes = "Atualiza as informações de uma movimentação com base no seu ID")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Movimentação atualizado com sucesso"),
                @ApiResponse(code = 400, message = "Requisição inválida"),
                @ApiResponse(code = 404, message = "Movimentação não a"),
                @ApiResponse(code = 500, message = "Erro interno do servidor")
        })
        @PutMapping("/movimentacoes/{movimentacaoId}")
        public ResponseEntity<Movimentacao> updateMovimentacao(@PathVariable(value = "movimentacaoId") short movimentacaoId,
                                               @Valid @RequestBody Movimentacao movimentacaoDetails) throws ResourceNotFoundException {
            Movimentacao movimentacao = movimentacaoRepository.findById(movimentacaoId)
                    .orElseThrow(() -> new ResourceNotFoundException("Movimentação não encontrado."));

            if (movimentacaoDetails.getClasse() != null) {
                movimentacao.setClasse(movimentacaoDetails.getClasse());
            }
            if (movimentacaoDetails.getDataMovimentacao() != null) {
                movimentacao.setDataMovimentacao(movimentacaoDetails.getDataMovimentacao());
            }
            if (movimentacaoDetails.getStatus() != null) {
                movimentacao.setStatus(movimentacaoDetails.getStatus());
            }
            if (movimentacaoDetails.getValor() != null) {
                movimentacao.setValor(movimentacaoDetails.getValor());
            }

            final Movimentacao updatedMovimentacao = movimentacaoRepository.save(movimentacao);
            return ResponseEntity.ok(updatedMovimentacao);
        }

        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Movimentação deletada com sucesso"),
                @ApiResponse(code = 404, message = "Movimentação não encontrada para exclusão")
        })
        @ApiOperation(value = "Deleta uma movimentação", notes = "Deleta uma movimentação com base no seu ID")
        @DeleteMapping("/movimentacoes/{movimentacaoId}")
        public Map<String, Boolean> deleteMovimentacao(@PathVariable(value = "movimentacaoId") short movimentacaoId) throws ResourceNotFoundException {
            try {
                movimentacaoRepository.deleteById(movimentacaoId);
            } catch (Exception e) {
                throw new ResourceNotFoundException("Movimentação não encontrada para exclusão");
            }
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            response.put("error", Boolean.FALSE);
            return response;
        }
}