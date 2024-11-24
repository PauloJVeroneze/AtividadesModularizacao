import java.util.ArrayList;
import java.util.Scanner;

class CarteiraDigital {
    private double saldo;
    private ArrayList<String> historico;

    public CarteiraDigital() {
        this.saldo = 0.0;
        this.historico = new ArrayList<>();
    }

    public void adicionarSaldo(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            historico.add("Adicionado: R$ " + valor);
            System.out.println("Saldo adicionado com sucesso!");
        } else {
            System.out.println("Valor inválido. Insira um valor positivo.");
        }
    }

    public void realizarPagamento(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            historico.add("Pagamento: R$ " + valor);
            System.out.println("Pagamento realizado com sucesso!");
        } else if (valor > this.saldo) {
            System.out.println("Saldo insuficiente para realizar o pagamento.");
        } else {
            System.out.println("Valor inválido. Insira um valor positivo.");
        }
    }

    public void verificarSaldo() {
        System.out.printf("Seu saldo atual é: R$ %.2f\n", this.saldo);
    }

    public void historicoTransacoes() {
        System.out.println("Histórico de Transações:");
        if (historico.isEmpty()) {
            System.out.println("Nenhuma transação realizada.");
        } else {
            for (String transacao : historico) {
                System.out.println(transacao);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CarteiraDigital carteira = new CarteiraDigital();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo à sua Carteira Digital!");

        while (true) {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            var opcao = scanner.nextInt();

            switch (opcao) {
                case 1: 
                    System.out.print("Digite o valor para adicionar ao saldo: ");
                    double valorAdicionar = scanner.nextDouble();
                    carteira.adicionarSaldo(valorAdicionar);
                    break;
                case 2: 
                    System.out.print("Digite o valor do pagamento: ");
                    double valorPagamento = scanner.nextDouble();
                    carteira.realizarPagamento(valorPagamento);
                    break;
                case 3: 
                    carteira.verificarSaldo();
                    break;
                case 4: 
                    carteira.historicoTransacoes();
                    break;
                case 5: 
                    System.out.println("Obrigado por usar a sua Carteira Digital!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Adicionar Saldo");
        System.out.println("2 - Realizar Pagamento");
        System.out.println("3 - Verificar Saldo");
        System.out.println("4 - Histórico de Transações");
        System.out.println("5 - Sair");
    }
}
