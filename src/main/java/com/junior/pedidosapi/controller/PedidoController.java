package com.junior.pedidosapi.controller;

import com.junior.pedidosapi.facade.PedidoFacade;
import com.junior.pedidosapi.model.Pedido;
import com.junior.pedidosapi.singleton.ContadorPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoFacade pedidoFacade;

    @PostMapping
    public Pedido criar(@RequestParam String nomeCliente,
                        @RequestParam String tipoCliente,
                        @RequestParam Double valorOriginal) {
        return pedidoFacade.processarPedido(nomeCliente, tipoCliente, valorOriginal);
    }

    @GetMapping("/contador")
    public int contador() {
        return ContadorPedidos.getInstance().getTotal();
    }
}