package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Adiantamento {

    private String idTransacao;
    private BigDecimal taxaAdiantamento;

    private Adiantamento(String adiantamentoString){
        String[] adiantementoStringSeparada = adiantamentoString.split(",");
        this.idTransacao = adiantementoStringSeparada[0];
        this.taxaAdiantamento = new BigDecimal(adiantementoStringSeparada[1]);
    }
    public static List<Adiantamento> toList(List<String> adiantementoString){
        return adiantementoString.stream()
                .map(Adiantamento::new)
                .collect(Collectors.toList());

    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(String idTransacao) {
        this.idTransacao = idTransacao;
    }

    public BigDecimal getTaxaAdiantamento() {
        return taxaAdiantamento;
    }

    public void setTaxaAdiantamento(BigDecimal taxaAdiantamento) {
        this.taxaAdiantamento = taxaAdiantamento;
    }
}
