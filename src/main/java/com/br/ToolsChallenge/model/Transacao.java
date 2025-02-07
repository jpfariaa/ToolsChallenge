package com.br.ToolsChallenge.model;

import lombok.Data;

@Data
public class Transacao {

    private String id;
    private String cartao;
    private Descricao descricao;
    private FormaPagamento formaPagamento;
    private String status;

    public Transacao(String id, String cartao, Descricao descricao, FormaPagamento formaPagamento, String status) {
        this.id = id;
        this.cartao = cartao;
        this.descricao = descricao;
        this.formaPagamento = formaPagamento;
        this.status = "AUTORIZADO";
    }

    public Transacao() {
        
    }

    public void cancelar() {
        this.status = "CANCELADO";
    }
}
