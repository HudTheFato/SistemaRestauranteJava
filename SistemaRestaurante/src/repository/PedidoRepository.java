package repository;

import model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {
    private List<Pedido> pedidos = new ArrayList<>();

    public void adicionar(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> listar() {
        return pedidos;
    }

    public void atualizar(Pedido pedidoAtualizado) {
    }

    public void excluir(Pedido pedido) {
        pedidos.remove(pedido);
    }
}