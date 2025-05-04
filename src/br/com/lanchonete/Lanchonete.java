package br.com.lanchonete;

public class Lanchonete {
    private Pedido[] pedidos;
    private int quantidadePedidos;

    public Lanchonete() {
        this.pedidos = new Pedido[50]; // -> maximo de 50 pedidos
        this.quantidadePedidos = 0;
    }

    public void registrarPedido(Pedido pedido) {
        if (quantidadePedidos < pedidos.length) {
            pedidos[quantidadePedidos] = pedido;
            quantidadePedidos++;
        }
    }

    public void exibirResumoPedidos() {
        System.out.println("=== Resumo dos Pedidos ===");
        for (int i = 0; i < quantidadePedidos; i++) {
            Pedido p = pedidos[i];
            System.out.println("Cliente: " + p.getCliente().getNome().toUpperCase());
            System.out.println("Total (sem desconto): R$ " + p.calcularTotal());
            if (p.getDesconto() != 0) {
                System.out.println("Total (com desconto): R$ " + p.calcularTotal(p.getDesconto()));
            }
            System.out.println("Esse pedido não possui desconto.");
            System.out.println("-----------------------------");
        }
    }
}
