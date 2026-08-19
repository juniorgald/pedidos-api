package com.junior.pedidosapi.singleton;

public class ContadorPedidos {

    private static ContadorPedidos instancia;
    private int total = 0;

    private ContadorPedidos() {
    }

    public static ContadorPedidos getInstance() {
        if (instancia == null) {
            instancia = new ContadorPedidos();
        }
        return instancia;
    }

    public void incrementar() {
        total++;
    }

    public int getTotal() {
        return total;
    }
}