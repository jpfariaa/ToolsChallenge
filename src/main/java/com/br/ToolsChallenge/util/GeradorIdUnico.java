package com.br.ToolsChallenge.util;

import java.util.UUID;

public class GeradorIdUnico {

    public static String gerarId() {
        return UUID.randomUUID().toString();
    }
}
