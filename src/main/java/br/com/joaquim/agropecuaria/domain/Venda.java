package br.com.joaquim.agropecuaria.domain;

import java.time.LocalDate;
import java.util.List;

public class Venda {
    private List<ItemVenda> itens;
    private LocalDate data;
    private String formaPagamento;

    public Venda(List<ItemVenda> Itens, LocalDate Data, String FormaPagamento){
        this.itens = Itens;
        this.data = Data;
        this.formaPagamento = FormaPagamento;
    }

    //funções de carrinho faço em repository? Pesquisar isso mais tarde
    //Como finalizar a compra, como fazer um registro de cada venda etc...
}
