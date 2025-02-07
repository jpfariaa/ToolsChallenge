package com.br.ToolsChallenge.service;

import com.br.ToolsChallenge.dto.EstornoResponseDTO;
import com.br.ToolsChallenge.dto.PagamentoRequestDTO;
import com.br.ToolsChallenge.dto.PagamentoResponseDTO;
import com.br.ToolsChallenge.exception.TransacaoJaEstornadaException;
import com.br.ToolsChallenge.exception.TransacaoNaoEncontradaException;
import com.br.ToolsChallenge.model.Transacao;
import com.br.ToolsChallenge.repository.PagamentoRepository;
import com.br.ToolsChallenge.util.GeradorIdUnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public PagamentoResponseDTO realizarPagamento(PagamentoRequestDTO request) {
        Transacao transacao = request.getTransacao();
        transacao.setId(GeradorIdUnico.gerarId());
        pagamentoRepository.salvar(transacao);

        PagamentoResponseDTO response = new PagamentoResponseDTO();
        response.setTransacao(transacao);

        return response;
    }

    public PagamentoResponseDTO consultarPagamento(String id) {
        Transacao transacao = pagamentoRepository.buscarPorId(id);
        if (transacao == null) {
            throw new TransacaoNaoEncontradaException("Transação não encontrada");
        }

        PagamentoResponseDTO response = new PagamentoResponseDTO();
        response.setTransacao(transacao);

        return response;
    }

    public List<PagamentoResponseDTO> listarPagamentos() {
        List<Transacao> transacoes = pagamentoRepository.listarTodos();
        List<PagamentoResponseDTO> responses = new ArrayList<>();
        for (Transacao transacao : transacoes) {
            PagamentoResponseDTO response = new PagamentoResponseDTO();
            response.setTransacao(transacao);
            responses.add(response);
        }
        return responses;
    }

    public EstornoResponseDTO estornarPagamento(String id) {
        Transacao transacao = pagamentoRepository.buscarPorId(id);
        if (transacao == null) {
            throw new TransacaoNaoEncontradaException("Transação não encontrada");
        }
        if (transacao.getStatus().equals("CANCELADO")) {
            throw new TransacaoJaEstornadaException("Transação já estornada");
        }

        transacao.cancelar();
        pagamentoRepository.salvar(transacao);

        EstornoResponseDTO response = new EstornoResponseDTO();
        response.setTransacao(transacao);

        return response;
    }
}
