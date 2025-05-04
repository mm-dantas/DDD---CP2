package br.com.lanchonete;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lanchonete lanchonete = new Lanchonete();

        String nomeCliente = lerStringNaoVazia(scanner, "Digite o nome do cliente:");
        int idadeCliente = lerIntValido(scanner, "Digite a idade do cliente:");

        Cliente cliente = new Cliente(nomeCliente, idadeCliente);

        String nomeProduto = lerStringNaoVazia(scanner, "Digite o nome do produto:");
        double precoProduto = lerDoubleValido(scanner, "Digite o preço do produto:");
        String categoriaProduto = lerStringNaoVazia(scanner, "Digite a categoria do produto:");

        Produto produto = new Produto(nomeProduto, precoProduto, categoriaProduto);

        Pedido pedido1 = new Pedido(cliente);
        pedido1.adicionarProduto(produto);

        Pedido pedido2 = new Pedido(cliente, 10.0);
        pedido2.adicionarProduto(produto, 3);

        lanchonete.registrarPedido(pedido1);
        lanchonete.registrarPedido(pedido2);

        lanchonete.exibirResumoPedidos();
    }

    private static String lerStringNaoVazia(Scanner scanner, String mensagem) {
        String entrada;
        do {
            System.out.println(mensagem);
            entrada = scanner.nextLine().trim();
            if (entrada.isEmpty()) {
                System.out.println("====Entrada inválida. Por favor, digite um valor não vazio.====");
            }
        } while (entrada.isEmpty());
        return entrada;
    }

    private static int lerIntValido(Scanner scanner, String mensagem) {
        int valor = -1;
        while (valor < 0) {
            System.out.println(mensagem);
            try {
                valor = Integer.parseInt(scanner.nextLine());
                if (valor < 0)
                    System.out.println("====Idade deve ser um valor positivo.====");
            } catch (NumberFormatException e) {
                System.out.println("====Valor inválido. Digite um número inteiro.====");
            }
        }
        return valor;
    }

    private static double lerDoubleValido(Scanner scanner, String mensagem) {
        double valor = -1;
        while (valor < 0) {
            System.out.println(mensagem);
            try {
                valor = Double.parseDouble(scanner.nextLine());
                if (valor < 0)
                    System.out.println("====Preço deve ser positivo.====");
            } catch (NumberFormatException e) {
                System.out.println("====Valor inválido. Digite um número com ponto.====");
            }
        }
        return valor;
    }
}
