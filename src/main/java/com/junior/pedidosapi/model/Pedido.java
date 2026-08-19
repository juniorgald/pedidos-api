package com.junior.pedidosapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCliente;
    private String tipoCliente;
    private Double valorOriginal;
    private Double valorComDesconto;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }

    public String getTipoCliente() { return tipoCliente; }
    public void setTipoCliente(String tipoCliente) { this.tipoCliente = tipoCliente; }

    public Double getValorOriginal() { return valorOriginal; }
    public void setValorOriginal(Double valorOriginal) { this.valorOriginal = valorOriginal; }

    public Double getValorComDesconto() { return valorComDesconto; }
    public void setValorComDesconto(Double valorComDesconto) { this.valorComDesconto = valorComDesconto; }
}