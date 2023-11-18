package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Evento {
    private String descricao;
    private LocalDate data;

    public Evento(){

    }   

    public Evento(String descricao, LocalDate data) {
        this.descricao = descricao;
        this.data = data;
    }

    public static List<Evento> criarEventos(){
        List<Evento> eventos = new ArrayList<>();
        Scanner read = new Scanner(System.in);

        System.out.print("\nDeseja cadastrar quantos eventos: ");
        int num = read.nextInt();
        if(num == 0) return null;

        for (int i = 0; i < num; i++) {
            Evento evento = new Evento();
            System.out.print("\nDescrição: ");
            evento.setDescricao(read.next());

            System.out.print("Data (dd/mm/yyyy): ");
            evento.setData(LocalDate.parse(read.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            eventos.add(evento);
        }
        
        return eventos;
    }

    public static List<Evento> alterarEvento(FundoImobiliario fii){
        if(eventosNuloVazio(fii.getListaEventos())) 
            return criarEventos(); 

        Scanner read = new Scanner(System.in);
        List<Evento> eventosList = fii.getListaEventos();

        System.out.println("\n");
        for(int i = 0; i < eventosList.size(); i++){
            System.out.println("Evento n° "+(i+1));
            imprimirEvento(eventosList.get(i));
        }

        System.out.print("\nAlterar evento n°: ");
        Integer opc = read.nextInt() - 1;

        if(opc > (eventosList.size() - 1)) return eventosList;

        Evento evento = eventosList.get(opc);

        System.out.print("\n[1] - Descricao\n[2] - Data\nOpcao: ");
        Integer alterarOpc = read.nextInt();

        System.out.print("Alteracao: ");
        switch(alterarOpc){
            case 1 -> evento.setDescricao(read.next());
            case 2 -> evento.setData(LocalDate.parse(read.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            default -> System.out.println("Opcão Invalida!");
        }

        eventosList.set(opc, evento);

        return eventosList;
    }

    public static void imprimirEvento(Evento e){
        System.out.println("Descricao: "+e.getDescricao());
        System.out.println("Data: "+e.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println();
    }

    public static boolean eventosNuloVazio(List<Evento> eventos){
        if(eventos == null || eventos.isEmpty()){
            System.out.println("\nLista de Eventos nao encontrada!");
            return true;
        }
        return false;

    } 

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

     @Override
    public String toString() {
        return "Evento [descricao=" + descricao + ", data=" + data + "]";
    }
}
