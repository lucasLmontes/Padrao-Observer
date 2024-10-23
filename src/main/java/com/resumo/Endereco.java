package com.resumo;

import java.util.Observable;
import java.util.Observer;

public class Endereco implements Observer {

    private String rua;
    private String cidade;
    private String ultimaNotificacao;

    public Endereco(String rua, String cidade) {
        this.rua = rua;
        this.cidade = cidade;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    public void acompanharPedido(Pedido pedido) {
        pedido.addObserver(this);
    }

    @Override
    public void update(Observable pedido, Object arg1) {
        this.ultimaNotificacao = "Endereço: " + this.rua + ", " + this.cidade +
                " - Status atualizado para: " + ((Pedido) pedido).getStatus();
    }
}
