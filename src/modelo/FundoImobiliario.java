package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import aplicacao.Menu;

public class FundoImobiliario {
    private String nome;
    private String ticker;
    private Double precoInicial;
    private Boolean investidorQualificado;
    private Segmento segmento;
    private List<Evento> listaEventos;

    public FundoImobiliario(){

    }

    public FundoImobiliario(String nome, String ticker, Double precoInicial, Boolean investidorQualificado, Segmento segmento , List<Evento> listaEventos) {
        this.nome = nome;
        this.ticker = ticker;
        this.precoInicial = precoInicial;
        this.investidorQualificado = investidorQualificado;
        this.segmento = segmento;
        this.listaEventos = listaEventos;
    }

    public static void adicionarFii(Map<String, FundoImobiliario> fiisMap){
        FundoImobiliario fii = new FundoImobiliario();
        Scanner read = new Scanner(System.in);

        System.out.print("\nNome do Fii: ");
        fii.setNome(read.next());

        System.out.print("Ticker: ");
        fii.setTicker(read.next());

        System.out.print("Preço Inicial: ");
        fii.setPrecoInicial(read.nextDouble());

        System.out.print("Para Investidor Qualificado: [1] - Sim [2] - Não\nOpcao: ");
        fii.setInvestidorQualificado(read.nextInt() == 1 ? true : false);

        Segmento.menuSegmento();
        System.out.print("Opção: ");
        fii.setSegmento(Segmento.valueOf(read.nextInt()));

        fii.setListaEventos(Evento.criarEventos());

        fiisMap.put(fii.getTicker(), fii);
    }

    public static void listarFii(Map<String, FundoImobiliario> fiisMap){
        Scanner read = new Scanner(System.in);
        List<FundoImobiliario> lista = new ArrayList<>(fiisMap.values());

        Menu.menuListar();
        System.out.print("Ordenar por qual atributo: ");
        Integer opc = read.nextInt();

        switch(opc){
            case 1 -> lista.sort((fii1, fii2) -> fii1.getNome().toLowerCase().compareTo(fii2.getNome().toLowerCase()));
            case 2 -> lista.sort((fii1, fii2) -> fii1.getTicker().toLowerCase().compareTo(fii2.getTicker().toLowerCase()));
            case 3 -> lista.sort((fii1, fii2) -> fii1.getPrecoInicial().compareTo(fii2.getPrecoInicial()));
            case 4 -> lista.sort((fii1, fii2) -> fii1.getInvestidorQualificado().compareTo(fii2.getInvestidorQualificado()));
            case 5 -> lista.sort((fii1, fii2) -> fii1.getSegmento().getDescricao().compareTo(fii2.getSegmento().getDescricao()));
            default -> System.out.println("Opção Inválida ");
        }

        System.out.println();
        lista.forEach(fii -> FundoImobiliario.imprimirFii(fii));
    }

    public static void atualizarFii(Map<String, FundoImobiliario> fiisMap){
        Scanner read = new Scanner(System.in);

        System.out.print("\nDigite o Ticker do Fii a ser atualizado: ");
        String ticker = read.next();

        if(fiisMap.containsKey(ticker)){
            FundoImobiliario fii = fiisMap.get(ticker);

            Menu.menuAtualizar();
            System.out.print("Atualizar qual item: ");
            Integer opc = read.nextInt();
            
            System.out.print("Atualizacao: ");
            
            switch(opc){
                case 1 -> fii.setNome(read.next());
                case 2 -> fii.setTicker(read.next());
                case 3 -> fii.setPrecoInicial(read.nextDouble());
                case 4 -> fii.setInvestidorQualificado(read.nextBoolean());
                case 5 -> fii.setSegmento(Segmento.alterarSegmento());
                case 6 -> fii.setListaEventos(Evento.alterarEvento(fii));
                default -> System.out.println("Opcao Invalida!");
            }
        }
        else System.out.println("Ticker Nao Encontrado!");
    }

    public static void deletarFii(Map<String, FundoImobiliario> listaMap){
        Scanner read = new Scanner(System.in);

        System.out.print("\nDigite o Ticker do fii: ");
        String ticker = read.next();

        if(listaMap.containsKey(ticker)) {
            listaMap.remove(ticker);
            System.out.println(ticker+" removido!");
        }
        else System.out.println("Ticker nao encontrado!");
    }

    public static void imprimirFii(FundoImobiliario fii){
        System.out.println("\nNome: "+fii.getNome());
        System.out.println("Ticker: "+fii.getTicker());
        System.out.println("Preco Inicial: "+fii.getPrecoInicial());
        System.out.println("Investidor Qualificado: "+fii.getInvestidorQualificado());
        System.out.println("Segmento: "+fii.getSegmento());

        if(!Evento.eventosNuloVazio(fii.getListaEventos())) {
            System.out.println();
            fii.getListaEventos().forEach(e -> Evento.imprimirEvento(e));
        }
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTicker() {
        return ticker;
    }
    public void setTicker(String ticker) {
        this.ticker = ticker;
    }
    public Double getPrecoInicial() {
        return precoInicial;
    }
    public void setPrecoInicial(Double precoInicial) {
        this.precoInicial = precoInicial;
    }
    public Boolean getInvestidorQualificado() {
        return investidorQualificado;
    }
    public void setInvestidorQualificado(Boolean investidorQualificado) {
        this.investidorQualificado = investidorQualificado;
    }
    public Segmento getSegmento() {
        return segmento;
    }
    public void setSegmento(Segmento segmento ) {
        this.segmento = segmento;
    }
    public List<Evento> getListaEventos() {
        return listaEventos;
    }
    public void setListaEventos(List<Evento> listaEventos) {
        this.listaEventos = listaEventos;
    }
    @Override
    public String toString() {
        return "Fii [nome=" + nome + ", ticker=" + ticker + ", precoInicial=" + precoInicial
                + ", investidorQualificado=" + investidorQualificado + ", segmento =" + segmento + ", listaEventos="
                + listaEventos + "]";
    }
}