package repository;

import model.Prato;

import java.util.ArrayList;
import java.util.List;

public class PratoRepository {
    private List<Prato> pratos = new ArrayList<>();

    public void adicionar(Prato prato) {
        pratos.add(prato);
    }

    public List<Prato> listar() {
        return pratos;
    }

    public void atualizar(String nome, Prato pratoAtualizado) {
        Prato prato = buscarPorNome(nome);
        if (prato != null) {
            pratos.remove(prato);
            pratos.add(pratoAtualizado);
        } else {
            System.out.println("Prato não encontrado.");
        }
    }

    public void excluir(String nome) {
        Prato prato = buscarPorNome(nome);
        if (prato != null) {
            pratos.remove(prato);
        } else {
            System.out.println("Prato não encontrado.");
        }
    }

    public Prato buscarPorNome(String nome) {
        for (Prato prato : pratos) {
            if (prato.getNome().equals(nome)) {
                return prato;
            }
        }
        return null;
    }
}