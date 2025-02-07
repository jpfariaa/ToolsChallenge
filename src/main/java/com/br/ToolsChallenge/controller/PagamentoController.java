package com.br.ToolsChallenge.controller;

import com.br.ToolsChallenge.dto.EstornoResponseDTO;
import com.br.ToolsChallenge.dto.PagamentoRequestDTO;
import com.br.ToolsChallenge.dto.PagamentoResponseDTO;
import com.br.ToolsChallenge.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    public ResponseEntity<PagamentoResponseDTO> realizarPagamento(@RequestBody PagamentoRequestDTO request) {
        PagamentoResponseDTO response = pagamentoService.realizarPagamento(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoResponseDTO> consultarPagamento(@PathVariable String id) {
        PagamentoResponseDTO response = pagamentoService.consultarPagamento(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PagamentoResponseDTO>> listarPagamentos() {
        List<PagamentoResponseDTO> response = pagamentoService.listarPagamentos();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/estornos/{id}")
    public ResponseEntity<EstornoResponseDTO> estornarPagamento(@PathVariable String id) {
        EstornoResponseDTO response = pagamentoService.estornarPagamento(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
