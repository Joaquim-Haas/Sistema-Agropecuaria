package br.com.joaquim.agropecuaria.repository;

import br.com.joaquim.agropecuaria.domain.Produto;

import java.util.ArrayList;
import java.util.List;

public class AgropecuariaRepository {

    private List<Produto> produtos = new ArrayList<>();

    public void salvarProduto(Produto produto){
        produtos.add(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public boolean idExiste(int id){
        for(Produto p : produtos){
            if(p.getId() == id){
                return true;
            }
        }
        return false;
    }

    public Produto buscaProdutoId(int Id){
        for (Produto p : produtos){
            if(p.getId() == Id){
                return p;
            }
        }
        return null;
    }

    public void deletarProduto(Produto produto){
        produtos.remove(produto);
    }
}
