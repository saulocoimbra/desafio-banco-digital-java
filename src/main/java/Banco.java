import java.util.List;
import java.util.Optional;

public class Banco {

    private String nome;
    private List<Conta> contas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void printInfoContas() {
        this.getContas().iterator().forEachRemaining(conta -> conta.imprimirExtrato());
    }


    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public void getExtrato(int numConta, int numAgencia) {
        this.getContas().stream().filter( conta -> conta.getNumero() == numConta && conta.getAgencia() == numAgencia )
                .findFirst().ifPresentOrElse(conta -> conta.imprimirExtrato(), () -> System.out.println("Conta invalida!"));
    }

    public void depositar(int numConta, int numAgencia, double valor) {
        this.getContas().stream().filter( conta -> conta.getNumero() == numConta && conta.getAgencia() == numAgencia )
                .findFirst().ifPresentOrElse(conta -> conta.depositar(valor), () -> System.out.println("Conta invalida!"));
    }

    public void sacar(int numConta, int numAgencia, double valor) {
        this.getContas().stream().filter( conta -> conta.getNumero() == numConta && conta.getAgencia() == numAgencia )
                .findFirst().ifPresentOrElse(conta -> conta.sacar(valor), () -> System.out.println("Conta invalida!"));
    }

    public void transferir(int numConta, int numAgencia, double valor, int numContaDestino, int numAgenciaDestino) {
        Conta contaDest = this.getContas().stream()
                .filter( contaDestino -> contaDestino.getNumero() == numContaDestino && contaDestino.getAgencia() == numAgenciaDestino )
                .findFirst().get();

        this.getContas().stream().filter( conta -> conta.getNumero() == numConta && conta.getAgencia() == numAgencia )
                .findFirst().ifPresentOrElse(conta -> conta.transferir(valor, contaDest), () -> System.out.println("Conta invalida!"));
    }

    public void printClientes() { this.getContas().iterator().forEachRemaining(conta -> System.out.println(conta.cliente.getNome())); }

}