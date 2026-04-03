package br.com.joaquim.agropecuaria.service;

import br.com.joaquim.agropecuaria.domain.Produto;
import br.com.joaquim.agropecuaria.repository.AgropecuariaRepository;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class AgropecuariaService {

    private AgropecuariaRepository AgroRepo;

    public AgropecuariaService(AgropecuariaRepository repository){
        this.AgroRepo = repository;
    }

    public void cadastrarProduto(String Nome, double Valor, int quantEstoque){
        if(Valor <= 0){
            throw new IllegalArgumentException("Preço inválido, pois é menor ou igual que 0. . .");
        }

        Random Rand = new Random();
        int idProd;

        do{
            idProd = Rand.nextInt(1_000_000) + 1;
        }while(AgroRepo.idExiste(idProd));

        Produto produto = new Produto(Nome, Valor, idProd, quantEstoque);
        AgroRepo.salvarProduto(produto);
    }

    public void listarProdutos(){
        List<Produto> lista = AgroRepo.getProdutos();

        if(lista.isEmpty()){
            System.out.println("Nenhum produto cadastrado, estoque vazio. . .");
            return;
        }

        Locale localeBR = Locale.of("pt", "BR");
        NumberFormat moeda = NumberFormat.getCurrencyInstance(localeBR);

        for(Produto p : lista){
            String valorFormatado = moeda.format(p.getValor());
            System.out.println("ID: " + p.getId());
            System.out.println("Nome: " + p.getNome());
            System.out.println("Preço: " + valorFormatado);
            System.out.println("Quantidade em estoque: " + p.getQuantiEstoque() + "\n");
        }
    }

    public void editarProdutoNome(int idProduto, String novoNome){
        if(novoNome == null || novoNome.trim().isEmpty()){
            throw new IllegalArgumentException("O nome do produto não deve estar vazio. . .");
        }

        Produto p = AgroRepo.buscaProdutoId(idProduto);

        if(p != null){
            p.setNome(novoNome);
            System.out.println("Nome atualizado com sucesso. . .");
        }
        else{
            System.out.println("Erro: Produto com ID " + idProduto + " não encontrado para alterar o nome. . .");
        }
    }

    public void editarProdutoPreco(int idProduto, double novoPreco){
        if(novoPreco == 0 || novoPreco < 0){
            throw new IllegalArgumentException("O novo valor do produto não deve ser 0 ou menor que 0. . .");
        }
        
        Produto p = AgroRepo.buscaProdutoId(idProduto);

        if(p != null){
            p.setValor(novoPreco);
        }
        else{
            System.out.println("Erro: Produto com ID " + idProduto + " não encontrado para alterar o valor. . .");
        }
    }

    public void excluirProduto(int idProduto){
        Produto p = AgroRepo.buscaProdutoId(idProduto);

        if(p != null){
            AgroRepo.deletarProduto(p);
            System.out.println("Produto removido com sucesso. . .");
        }
        else{
            System.out.println("Erro: Produto com ID " + idProduto + " não encontrado para exclusão. . .");
        }
    }

    public void aumentarEstoque(int idProduto, int novoQuantiEstoque){
        Produto p = AgroRepo.buscaProdutoId(idProduto);

        if(p != null){
            p.setQuantiEstoque(novoQuantiEstoque + p.getQuantiEstoque());
        }
        else{
            System.out.println("Erro: Produto com ID " + idProduto + " não encontrado para aumentar o estoque. . .");
        }
    }

}
