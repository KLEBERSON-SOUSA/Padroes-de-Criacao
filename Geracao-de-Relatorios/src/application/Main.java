package application;

import entities.Cliente;
import entities.interfaces.Relatorio;
import relatorios.RelatorioFactory;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("|==============| SISTEMA DE PEDIDOS |==============|");

        // Cadastro do cliente
        System.out.print("Digite o seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite o seu CPF (com pontuação): ");
        String cpf = sc.nextLine();
        System.out.print("Digite o seu endereço: ");
        String endereco = sc.nextLine();

        Cliente cliente = new Cliente(nome, cpf, endereco);

        // Menu de pedidos
        int opcao;
        do {
            System.out.println("\nCardápio:");
            System.out.println("1) Parmegiana - R$26.21");
            System.out.println("2) Filé Mignon ao molho madeira - R$119.90");
            System.out.println("3) Risoto a moda do chef - R$85.00");
            System.out.println("0) Finalizar pedidos");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            if(opcao >= 1 && opcao <= 3) {
                System.out.print("Para quantas pessoas? ");
                int quantidade = sc.nextInt();
                cliente.fazerPedido(opcao, quantidade);
            }
        } while(opcao != 0);

        // Geração de todos os relatórios
        System.out.println("GERANDO TODOS OS RELATÓRIOS...");

        List<Relatorio> relatorios = RelatorioFactory.criarTodosRelatorios();
        for (Relatorio relatorio : relatorios) {
            relatorio.gerarRelatorio(cliente);
            System.out.println();
        }

        sc.close();
    }
}