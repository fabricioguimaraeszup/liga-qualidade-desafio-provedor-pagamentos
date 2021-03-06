package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class Transacao {


    private String idTransacao;
    private BigDecimal valor;
    private EnumMetodoPagamento metodoPagamento;
    private String numeroCartao;
    private String nomeCartao;
    private String dataPagamento;
    private String cvv;
    private Adiantamento adiantamento;


    private Transacao(String transacaoString){
        String[] transacaoStringSeparada = transacaoString.split(",");
        this.valor =  new BigDecimal(transacaoStringSeparada[0]);
        this.metodoPagamento =   EnumMetodoPagamento.valueOf(transacaoStringSeparada[1]);
        this.numeroCartao = transacaoStringSeparada[2];
        this.nomeCartao = transacaoStringSeparada[3];
        this.dataPagamento = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.cvv = transacaoStringSeparada[5];
        this.idTransacao = transacaoStringSeparada[6];
    }
    public static List<Transacao> toList(List<String> transacoesString){
        return transacoesString.stream()
                .map(Transacao::new)
                .collect(Collectors.toList());

    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public void setAdiantamento(Adiantamento adiantamento) {
        this.adiantamento = adiantamento;
    }

    public Adiantamento getAdiantamento() {
        return adiantamento;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EnumMetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }
}
