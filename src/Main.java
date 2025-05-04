import java.util.Scanner;
import br.com.lanchonete.Cliente;
import br.com.lanchonete.Lanchonete;
import br.com.lanchonete.Pedido;
import br.com.lanchonete.Produto;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lanchonete lanchonete = new Lanchonete();

        String nomeCliente = lerStringNaoVazia(scanner, "Digite o nome do cliente:");
        int idadeCliente = lerIntValido(scanner, "Digite a idade do cliente:");

        Cliente cliente = new Cliente(nomeCliente, idadeCliente);

        String continuar;
        do {
            String nomeProduto = lerStringNaoVazia(scanner, "Digite o nome do produto:");
            double precoProduto = lerDoubleValido(scanner, "Digite o preço do produto:");

            System.out.println("Digite a categoria do produto (pressione Enter para deixar em branco):");
            String categoriaProduto = scanner.nextLine().trim();
            Produto produto;
            if (categoriaProduto.isEmpty()) {
                produto = new Produto(nomeProduto, precoProduto);
            } else {
                produto = new Produto(nomeProduto, precoProduto, categoriaProduto);
            }

            double desconto = lerDoubleValido(scanner,
                    "Digite o percentual de desconto para o pedido (ex: 10 para 10%). Valor padrão é 0:");

            Pedido pedido = new Pedido(cliente, desconto);
            int quantidade = lerIntValido(scanner, "Digite a quantidade de items:");
            if (quantidade < 1) {
                pedido.adicionarProduto(produto);
            } else {
                pedido.adicionarProduto(produto, quantidade);
            }

            lanchonete.registrarPedido(pedido);
            System.out
                    .println("Deseja adicionar outro pedido? (Digite 's' para sim ou qualquer outra tecla para sair):");
            continuar = scanner.nextLine().trim().toLowerCase();
        } while (continuar.equals("s"));
        lanchonete.exibirResumoPedidos();
    }

    private static String lerStringNaoVazia(Scanner scanner, String mensagem) {
        String entrada;
        do {
            System.out.println(mensagem);
            entrada = scanner.nextLine().trim();
            if (entrada.isEmpty()) {
                System.out.println("====Entrada inválida. Por favor, digite um valor não vazio.====\n\n");
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
                    System.out.println("====Idade deve ser um valor positivo.====\n\n");
            } catch (NumberFormatException e) {
                System.out.println("====Valor inválido. Digite um número inteiro.====\n\n");
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
                    System.out.println("====Valor deve ser positivo.====\n\n");
            } catch (NumberFormatException e) {
                System.out.println("====Valor inválido. Digite um número com ponto.====\n\n");
            }
        }
        return valor;
    }
}
