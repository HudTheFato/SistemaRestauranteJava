package repository;

import model.Garcom;

import java.util.ArrayList;
import java.util.List;

public class GarcomRepository {
    private List<Garcom> garcons = new ArrayList<>();

    public void adicionar(Garcom garcom) {
        if (buscarPorCodigo(garcom.getCodigo()) == null) {
            garcons.add(garcom);
        } else {
            System.out.println("Garçom com código " + garcom.getCodigo() + " já cadastrado.");
        }
    }

    public List<Garcom> listar() {
        return garcons;
    }

    public void atualizar(String codigo, Garcom garcomAtualizado) {
        Garcom garcom = buscarPorCodigo(codigo);
        if (garcom != null) {
            garcons.remove(garcom);
            garcons.add(garcomAtualizado);
        } else {
            System.out.println("Garçom não encontrado.");
        }
    }

    public void excluir(String codigo) {
        Garcom garcom = buscarPorCodigo(codigo);
        if (garcom != null) {
            garcons.remove(garcom);
        } else {
            System.out.println("Garçom não encontrado.");
        }
    }

    public Garcom buscarPorCodigo(String codigo) {
        for (Garcom garcom : garcons) {
            if (garcom.getCodigo().equals(codigo)) {
                return garcom;
            }
        }
        return null;
    }
}