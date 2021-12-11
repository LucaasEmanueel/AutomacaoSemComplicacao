package Transferencia;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContaTest {

    private Cliente lucas;
    private Cliente joao;
    private Conta contaDeLucas;
    private Conta contaDeJoao;

    @BeforeEach
    public void setUp(){
        lucas = new Cliente("lucas", "321.321.321-00", "3.321-10");
        joao = new Cliente("joao", "645.654.654-54", "2.039.12");
        contaDeLucas = new Conta(lucas,"2222-1","101022-2", 200.00);
        contaDeJoao = new Conta(joao, "234-5", "20933-3",400.00);
    }
    @Test
    public void testeRealizadepositoComSucesso(){
        contaDeLucas.depositoEmConta(50.0);
        assertEquals(250.00,contaDeLucas.getSaldo());
    }

    //@Test
    public void testeRealizarDepositoComFalha(){
        contaDeLucas.depositoEmConta(-20.0);
        assertNotEquals(10000.0,contaDeLucas.getSaldo());
    }

    @Test
    public void testeRealizarTransacaoSucesso(){
        contaDeLucas.transferencia(contaDeJoao,100.0);
        assertEquals(500.0,contaDeJoao.getSaldo());
    }

    @Test
    public void testeRealizarTransacaoComFalha(){
        boolean resultadoDaTransacao = contaDeLucas.transferencia(contaDeJoao,900.0);
        assertEquals(false,resultadoDaTransacao);
    }

    @Test
    public void testeVerificaDadosDoCliente(){
        contaDeLucas.transferencia(contaDeJoao,0.0);
        assertEquals("joao",contaDeJoao.getCliente().getNome());
        assertEquals("645.654.654-54",contaDeJoao.getCliente().getCpf());
        assertEquals("2.039.12", contaDeJoao.getCliente().getRg());
    }

    @Test
    public void testeVerificaDadosDaConta(){
        assertEquals("2222-1", contaDeLucas.getAgencia());
        assertEquals("101022-2", contaDeLucas.getNumeroDaConta());
    }


}
