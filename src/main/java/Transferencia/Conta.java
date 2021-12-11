package Transferencia;

public class Conta {

    private String numeroDaConta;
    private String agencia;
    private Double saldo;
    Cliente cliente;

    public Conta(Cliente proprietario, String agencia, String numero, Double saldo){
        this.cliente = proprietario;
        this.agencia = agencia;
        this.numeroDaConta = numero;
        this.saldo = saldo;
    }

    public String getNumeroDaConta() {
        return numeroDaConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Double depositoEmConta(Double valorDeDeposito){
          return  this.saldo += valorDeDeposito;

    }

    public boolean saqueDaConta(Double valorDoSaque){
        if(valorDoSaque > getSaldo()){
            return false;
        }
        this.saldo -= valorDoSaque;
        return true;
    }

    public boolean transferencia(Conta destino, Double valor){
        if(saqueDaConta(valor)){
            destino.depositoEmConta(valor);
            return true;
        }
        return false;
    }

}
