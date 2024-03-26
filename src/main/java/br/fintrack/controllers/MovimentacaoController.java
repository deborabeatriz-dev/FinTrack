package br.fintrack.controllers;

import br.fintrack.models.Movimentacao;
import br.fintrack.repositories.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @PostMapping("/movimentacao")
    public Movimentacao saveMovimentacao(@RequestBody Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    @GetMapping("/movimentacao/{id}")
    public Movimentacao getEmployee(@PathVariable("id") Short movimentacaoId) {
        return movimentacaoRepository.getMovimentacaoById(movimentacaoId);
    }

    @DeleteMapping("/movimentacao/{id}")
    public String deleteMovimentacao(@PathVariable("id") Short movimentacaoId) {
        return  movimentacaoRepository.delete(movimentacaoId);
    }

    @PutMapping("/movimentacao/{id}")
    public Short updateMovimentacao(@PathVariable("id") Short movimentacaoId, @RequestBody Movimentacao movimentacao) {
        return movimentacaoRepository.update(movimentacaoId,movimentacao);
    }
}