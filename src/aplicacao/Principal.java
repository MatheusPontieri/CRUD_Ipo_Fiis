package aplicacao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import modelo.*;

public class Principal {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Integer opc = 0;
        Map<String, FundoImobiliario> listaMap = new HashMap<>();
        
        while(opc != null){
            Menu.menuCrud();
            System.out.print("Opção: ");
            opc = read.nextInt();

            switch(opc){
                case 1 -> FundoImobiliario.adicionarFii(listaMap);
                case 2 -> FundoImobiliario.listarFii(listaMap);
                case 3 -> FundoImobiliario.atualizarFii(listaMap);
                case 4 -> FundoImobiliario.deletarFii(listaMap);
                case 5 -> opc = null;
                default -> System.out.println("Opcao Invalida!");
            }
            System.out.println();
        }
    }
}
