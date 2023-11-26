package aplicacao;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import modelo.*;

public class Principal {
    private static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        Integer opc = 0;
        Map<String, FundoImobiliario> listaMap = new HashMap<>();
        
        while(opc != null){
            Menu.menuCrud();
            opc = tratarValor();

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

    public static Integer tratarValor(){
        int tentativas = 3;

        while(tentativas >= 1){
            try {
                System.out.print("Opcao: ");
                return read.nextInt();
            } catch(InputMismatchException e){
                System.out.println("\nDigite um número!");
            } finally {
                read.nextLine();
            }
            System.out.println(--tentativas+" tentivas restantes!");
        }

        System.out.print("\n3 tentativas inválidas! Saindo do Sistema!");
        return 5;
    }

}
