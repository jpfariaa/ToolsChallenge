package com.br.ToolsChallenge;

import com.br.ToolsChallenge.model.Descricao;
import com.br.ToolsChallenge.model.FormaPagamento;
import com.br.ToolsChallenge.model.Transacao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PagamentoControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void realizarPagamentoTest() {
        Transacao transacao = new Transacao();
        Descricao descricao = new Descricao();
        descricao.setValor(BigDecimal.valueOf(500.50));
        descricao.setDataHora(LocalDateTime.parse("01/05/2021 18:30:00"));
        descricao.setEstabelecimento("Petshop Mundo Cão");
        transacao.setDescricao(descricao);
        transacao.setId(UUID.randomUUID().toString());
        transacao.setCartao("4444**********1234");
        FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setTipo("AVISTA");
        formaPagamento.setParcelas(1);
        transacao.setFormaPagamento(formaPagamento);

        ResponseEntity<Transacao> response = restTemplate.postForEntity("/pagamentos", transacao, Transacao.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
    }
}
