package com.br.ToolsChallenge.repository;

import com.br.ToolsChallenge.model.Transacao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PagamentoRepository {

    private Map<String, Transacao> transacoes = new HashMap<>();

    public void salvar(Transacao transacao) {
        transacoes.put(transacao.getId(), transacao);
    }

    public Transacao buscarPorId(String id) {
        return transacoes.get(id);
    }

    public List<Transacao> listarTodos() {
        return new ArrayList<>(transacoes.values());
    }
}
