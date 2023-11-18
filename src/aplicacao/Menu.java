package aplicacao;

public class Menu {
    
    public static void menuCrud(){
        String[] opcoes = {"Adicionar Fii", "Listar Fiis", "Atualizar Fii", "Deletar Fii", "Sair do Sistema"};

        for(int i = 0; i < opcoes.length; i++)
            System.out.println("["+(i+1)+"] - "+opcoes[i]);
    }

    public static void menuListar(){
        String[] opcoes = {"Nome", "Ticker", "Preço Incial", "Investidor Qualificado", "Tipo"};
        System.out.println();

        for (int i = 0; i < opcoes.length; i++) 
            System.out.println("["+(i+1)+"] - "+opcoes[i]);
    }

    public static void menuAtualizar(){
        menuListar();
        System.out.println("[6] - Evento");
    }

}
