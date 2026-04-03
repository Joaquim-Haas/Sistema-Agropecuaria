package br.com.joaquim.agropecuaria.domain;

public class Produto {
    private String nome;
    private double valor;
    private int id;
    private int quantiEstoque; //Adicionar fornecedor futuramente

    public Produto(String Nome, double Valor, int Id, int QuantiEstoque){
        this.nome = Nome;
        this.valor = Valor;
        this.id = Id;
        this.quantiEstoque = QuantiEstoque;
    }

    public String getNome(){
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public int getId(){
        return id;
    }

    public int getQuantiEstoque(){
        return quantiEstoque;
    }

    public void setNome(String Nome) {
        this.nome = Nome;
    }

    public void setValor(double Valor) {
        this.valor = Valor;
    }

    public void setQuantiEstoque(int QuantiEstoque){
        this.quantiEstoque = QuantiEstoque;
    }
}
