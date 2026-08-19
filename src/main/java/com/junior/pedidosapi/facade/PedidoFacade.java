package com.junior.pedidosapi.facade;

import com.junior.pedidosapi.model.Pedido;
import com.junior.pedidosapi.repository.PedidoRepository;
import com.junior.pedidosapi.singleton.ContadorPedidos;
import com.junior.pedidosapi.strategy.DescontoNormal;
import com.junior.pedidosapi.strategy.DescontoVip;
import com.junior.pedidosapi.strategy.EstrategiaDesconto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoFacade {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private DescontoNormal descontoNormal;

    @Autowired
    private DescontoVip descontoVip;

    public Pedido processarPedido(String nomeCliente, String tipoCliente, Double valorOriginal) {

        EstrategiaDesconto estrategia = tipoCliente.equalsIgnoreCase("VIP")
                ? descontoVip
                : descontoNormal;

        Double valorComDesconto = estrategia.calcular(valorOriginal);

        Pedido pedido = new Pedido();
        pedido.setNomeCliente(nomeCliente);
        pedido.setTipoCliente(tipoCliente);
        pedido.setValorOriginal(valorOriginal);
        pedido.setValorComDesconto(valorComDesconto);

        Pedido salvo = pedidoRepository.save(pedido);

        ContadorPedidos.getInstance().incrementar();

        return salvo;
    }
}
