package br.com.joaquim.agropecuaria.domain;

public class ItemVenda {
    private String nomeProduto;
    private int quantidade;
    private double precoAtual;

    public ItemVenda(String NomeProduto, int Quantidade, double PrecoAtual){
        this.nomeProduto = NomeProduto;
        this.quantidade = Quantidade;
        this.precoAtual = PrecoAtual;
    }
}
