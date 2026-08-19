package com.junior.pedidosapi.strategy;

import org.springframework.stereotype.Component;

@Component
public class DescontoVip implements EstrategiaDesconto {

    @Override
    public Double calcular(Double valorOriginal) {
        return valorOriginal * 0.80;
    }
}