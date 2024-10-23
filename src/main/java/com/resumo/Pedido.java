package com.resumo;

import java.util.Observable;

public class Pedido extends Observable {

    private String numero;
    private String status;

    public Pedido(String numero) {
        this.numero = numero;
        this.status = "Em preparação";
    }

    public String getNumero() {
        return numero;
    }

    public String getStatus() {
        return status;
    }

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "numero='" + numero + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
