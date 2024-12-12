package repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private List<Cliente> clientes = new ArrayList<>();

    public void adicionar(Cliente cliente) {
        if (buscarPorCpf(cliente.getCpf()) == null) {
            clientes.add(cliente);
        } else {
            System.out.println("Cliente com CPF " + cliente.getCpf() + " já cadastrado.");
        }
    }

    public List<Cliente> listar() {
        return clientes;
    }

    public void atualizar(String cpf, Cliente clienteAtualizado) {
        Cliente cliente = buscarPorCpf(cpf);
        if (cliente != null) {
            clientes.remove(cliente);
            clientes.add(clienteAtualizado);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void excluir(String cpf) {
        Cliente cliente = buscarPorCpf(cpf);
        if (cliente != null) {
            clientes.remove(cliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

     public Cliente buscarPorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }
}