package com.br.ToolsChallenge.dto;

import com.br.ToolsChallenge.model.Transacao;
import lombok.Data;

@Data
public class PagamentoRequestDTO {
    private Transacao transacao;
}
