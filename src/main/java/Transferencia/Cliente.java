package Transferencia;

public class Cliente {

    private String nome;
    private String cpf;
    private String rg;

    public Cliente(String nome, String cpf, String rg){
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;

    }

    public String getNome(){
        return this.nome;
    }

    public String getCpf(){
        return this.cpf;
    }

    public String getRg(){
        return this.rg;
    }


}
