package br.com.lanchonete;

public class Pedido {
    private Cliente cliente;
    private Produto[] produtos;
    private double desconto;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.produtos = new Produto[100]; // -> Máximo de 100 produtos por pedido
    }

    public Pedido(Cliente cliente, double desconto) {
        this(cliente);
        this.desconto = desconto;
    }

    public void adicionarProduto(Produto produto) {
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] == null) {
                produtos[i] = produto;
                break;
            }
        }
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            adicionarProduto(produto); // Adiciona o produto
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto produto : produtos) {
            if (produto != null) {
                total += produto.getPreco();
            }
        }
        return total;
    }

    public double calcularTotal(double percentual) {
        double total = calcularTotal();
        return total - (total * (percentual / 100));
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Produto[] getProdutos() {
        return produtos;
    }

    public double getDesconto() {
        return desconto;
    }
}
