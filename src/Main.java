package br.com.lanchonete;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lanchonete lanchonete = new Lanchonete();

        System.out.println("Digite o nome do cliente:");
        String nomeCliente = scanner.nextLine();
        System.out.println("Digite a idade do cliente:");
        int idadeCliente = Integer.parseInt(scanner.nextLine());

        Cliente cliente = new Cliente(nomeCliente, idadeCliente);

        System.out.println("Digite o nome do produto:");
        String nomeProduto = scanner.nextLine();
        System.out.println("Digite o preço do produto:");
        double precoProduto = Double.parseDouble(scanner.nextLine());
        System.out.println("Digite a categoria do produto:");
        String categoriaProduto = scanner.nextLine();

        Produto produto = new Produto(nomeProduto, precoProduto, categoriaProduto);

        Pedido pedido1 = new Pedido(cliente);
        pedido1.adicionarProduto(produto);

        Pedido pedido2 = new Pedido(cliente, 10.0); // Esse parâmetro é o desconto do pedido
        pedido2.adicionarProduto(produto, 3); // Segundo parâmetro é a quantidade do produto

        lanchonete.registrarPedido(pedido1);
        lanchonete.registrarPedido(pedido2);

        lanchonete.exibirResumoPedidos();

    }
}
