package com.junior.pedidosapi.repository;

import com.junior.pedidosapi.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}