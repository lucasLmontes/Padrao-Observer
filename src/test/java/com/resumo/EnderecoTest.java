package com.resumo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnderecoTest {

    @Test
    void deveNotificarEnderecoQuandoStatusAtualizado() {
        Pedido pedido = new Pedido("12345");
        Endereco endereco = new Endereco("Rua A", "Cidade B");
        endereco.acompanharPedido(pedido);
        pedido.atualizarStatus("Enviado");

        assertEquals("Endereço: Rua A, Cidade B - Status atualizado para: Enviado", endereco.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarEnderecoSemAcompanhamento() {
        Pedido pedido = new Pedido("12345");
        Endereco endereco = new Endereco("Rua A", "Cidade B");
        pedido.atualizarStatus("Enviado");

        assertEquals(null, endereco.getUltimaNotificacao());
    }

    @Test
    void deveNotificarEnderecos() {
        Pedido pedido = new Pedido("12345");
        Endereco endereco1 = new Endereco("Rua A", "Cidade B");
        Endereco endereco2 = new Endereco("Rua C", "Cidade D");

        endereco1.acompanharPedido(pedido);
        endereco2.acompanharPedido(pedido);

        pedido.atualizarStatus("Entregue");

        assertEquals("Endereço: Rua A, Cidade B - Status atualizado para: Entregue", endereco1.getUltimaNotificacao());
        assertEquals("Endereço: Rua C, Cidade D - Status atualizado para: Entregue", endereco2.getUltimaNotificacao());
    }
}
