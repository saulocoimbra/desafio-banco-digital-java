import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int opt = 0;
        int contaOpt = 0;
        int numConta;
        int numAgencia;
        double valor;
        Banco banco = new Banco();
        Cliente cliente = new Cliente();
        Conta contaCorrente;
        Conta contaPoupanca;
        List<Conta> contas = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while (opt != 8) {
            switch (opt) {

                case 0:
                    System.out.println();
                    System.out.println();
                    System.out.println("----- OPCOES -----");
                    System.out.println("Selecione uma opcao: ");
                    System.out.println("1. Cadastrar nova conta");
                    System.out.println("2. Exibir extrato da conta");
                    System.out.println("3. Depositar");
                    System.out.println("4. Sacar");
                    System.out.println("5. Transferir");
                    System.out.println("6. Exibir contas");
                    System.out.println("7. Exibir clientes");
                    System.out.println("8. Sair");
                    opt = input.nextInt();
                    System.out.println();
                    System.out.println();
                    break;

                case 1:
                    while(contaOpt != 3) {
                        switch (contaOpt) {
                            case 0:
                                System.out.println("Informe o nome do titular");
                                cliente.setNome(input.next());
                                System.out.println("Informe o tipo de conta que deseja cadastrar");
                                System.out.println("1. Conta corrente");
                                System.out.println("2. Conta poupanca");
                                System.out.println("3. Cancelar");
                                contaOpt = input.nextInt();
                                break;
                            case 1:
                                contaCorrente = new ContaCorrente(cliente);
                                System.out.println("Conta cadastrada com sucesso");
                                System.out.println("Numero da conta: " + contaCorrente.getNumero());
                                System.out.println("Numero da agencia: " + contaCorrente.getAgencia());
                                contas.add(contaCorrente);
                                banco.setContas(contas);
                                contaOpt = 3;
                                break;
                            case 2:
                                contaPoupanca = new ContaPoupanca(cliente);
                                System.out.println("Conta cadastrada com sucesso");
                                System.out.println("Numero da conta: " + contaPoupanca.getNumero());
                                System.out.println("Numero da agencia: " + contaPoupanca.getAgencia());
                                contas.add(contaPoupanca);
                                banco.setContas(contas);
                                contaOpt = 3;
                                break;
                            default:
                                System.out.println("Opcao invalida");
                                contaOpt = 0;
                                break;
                        }
                    }
                    contaOpt = 0;
                    opt = 0;
                    break;
                case 2:
                    System.out.println("----- EXTRATO -----");
                    System.out.println("Informe o numero da conta");
                    numConta = input.nextInt();
                    System.out.println("Informe o numero da agencia");
                    numAgencia = input.nextInt();
                    banco.getExtrato(numConta, numAgencia);
                    opt = 0;
                    break;
                case 3:
                    System.out.println("----- DEPOSITO -----");
                    System.out.println("Informe o numero da conta");
                    numConta = input.nextInt();
                    System.out.println("Informe o numero da agencia");
                    numAgencia = input.nextInt();
                    System.out.println("Informe o valor do deposito");
                    valor = input.nextDouble();
                    banco.depositar(numConta, numAgencia, valor);
                    opt = 0;
                    break;
                case 4:
                    System.out.println("----- SAQUE -----");
                    System.out.println("Informe o numero da conta");
                    numConta = input.nextInt();
                    System.out.println("Informe o numero da agencia");
                    numAgencia = input.nextInt();
                    System.out.println("Informe o valor do saque");
                    valor = input.nextDouble();
                    banco.sacar(numConta, numAgencia, valor);
                    opt = 0;
                    break;
                case 5:
                    System.out.println("----- TRANSFERENCIA -----");
                    System.out.println("Informe o numero da sua conta");
                    numConta = input.nextInt();
                    System.out.println("Informe o numero da sua agencia");
                    numAgencia = input.nextInt();
                    System.out.println("Informe o valor da transferencia");
                    valor = input.nextDouble();
                    System.out.println("Informe o numero da conta destino");
                    int numContaDestino = input.nextInt();
                    System.out.println("Informe o numero da conta destino");
                    int numAgenciaDestino = input.nextInt();
                    banco.transferir(numConta, numAgencia, valor, numContaDestino, numAgenciaDestino);
                    opt = 0;
                    break;
                case 6:
                    System.out.println("----- CONTAS CADASTRADAS -----");
                    banco.printInfoContas();
                    opt = 0;
                    break;
                case 7:
                    System.out.println("----- CLIENTES CADASTRADOS -----");
                    banco.printClientes();
                    opt = 0;
                    break;
                default:
                    System.out.println("Opcao invalida");
                    opt = 0;
                    break;
            }
        }

    }
}