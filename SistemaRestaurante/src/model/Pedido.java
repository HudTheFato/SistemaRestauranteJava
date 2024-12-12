package model;

import java.util.Date;

public class Pedido {
    private Cliente cliente;
    private Garcom garcom;
    private Prato prato;
    private Date data;

    public Pedido(Cliente cliente, Garcom garcom, Prato prato, Date data) {
        this.cliente = cliente;
        this.garcom = garcom;
        this.prato = prato;
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Garcom getGarcom() {
        return garcom;
    }

    public Prato getPrato() {
        return prato;
    }

    public Date getData() {
        return data;
    }
}