package modelo;

import java.util.Scanner;

public enum Segmento {
    TIJOLO (1, "Tijolo"),
    PAPEL (2, "Papel"),
    FOF (3, "Fof"),
    HIBRIDO (4, "Hibrido"),
    DESENVOLVIMENTO (5, "Desenvolvimento");

    private final Integer id;
    private final String descricao;

    private Segmento(Integer id, String descricao){
        this.id = id;
        this.descricao = descricao;
    }
    
    public static Segmento alterarSegmento(){ // Mostrar opções, retornar o que o usuário quer
        Scanner read = new Scanner(System.in);
        
        menuSegmento();
        System.out.print("Opção: ");

        Segmento segmento = valueOf(read.nextInt());
        return segmento;
    }

    public static void menuSegmento(){
        System.out.println();
        for (Segmento segmento : Segmento.values()) 
            System.out.println("["+segmento.getId()+"] - "+segmento.getDescricao());
    }

    public static Segmento valueOf(Integer id){
        for (Segmento segmento : Segmento.values()) {
            if (segmento.getId().equals(id))
                return segmento;
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}