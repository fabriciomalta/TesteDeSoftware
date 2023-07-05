package exercicio09_14_TD;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Assert;
import org.junit.Test;

public class AutenticacaoTest {

    @Test
    public void testLoginEmaileSenhaVazios() {
        Usuario usuario = new Usuario("", "password", "normal");
        Autenticacao autenticacao = new Autenticacao();
        String resultado = autenticacao.login(usuario);
        Assert.assertEquals("e-mail/senha não podem ser vazio.", resultado);
    }

    @Test
    public void testLoginEmaileSenhaVazia() {
        Usuario usuario = new Usuario("user@example.com", "", "normal");
        Autenticacao autenticacao = new Autenticacao();
        String resultado = autenticacao.login(usuario);
        Assert.assertEquals("e-mail/senha não podem ser vazio.", resultado);
    }

    @Test
    public void testLoginEmaileForaDoFormato() {
        Usuario usuario = new Usuario("invalid_email", "password", "normal");
        Autenticacao autenticacao = new Autenticacao();
        String resultado = autenticacao.login(usuario);
        Assert.assertEquals("e-mail fora do formato.", resultado);
    }

    @Test
    public void testLoginSenhaMenosDeQuatroCaracteres() {
        Usuario usuario = new Usuario("user@example.com", "abc", "normal");
        Autenticacao autenticacao = new Autenticacao();
        String resultado = autenticacao.login(usuario);
        Assert.assertEquals("a senha tem ao menos 4 caracteres.", resultado);
    }

    /*@Test
    public void testLoginEmaileSenhaValidos() {
        Usuario usuario = new Usuario("user@example.com", "password", "normal");
        Autenticacao autenticacao = new Autenticacao();
        String resultado = autenticacao.login(usuario);
    }*/
    
    @Test
    public void testLoginUsuarioNaoExiste() {
        // Simula a situação em que o e-mail não está cadastrado no banco de dados
        Usuario usuario = new Usuario("nonexistent@example.com", "password", "normal");
        Autenticacao autenticacao = new Autenticacao();
        String resultado = autenticacao.login(usuario);
        Assert.assertEquals("usuario não existe", resultado);
    }

    @Test
    public void testLoginSenhaIncorreta() {
        // Simula a situação em que o e-mail está cadastrado, mas a senha fornecida está incorreta
        Usuario usuario = new Usuario("user@example.com", "wrong_password", "normal");
        Autenticacao autenticacao = new Autenticacao();
        String resultado = autenticacao.login(usuario);
        Assert.assertEquals("senha incorreta", resultado);
    }

    @Test
    public void testLoginLogadoComoAdmin() {
        // Simula a situação em que o usuário é do tipo "admin"
        Usuario usuario = new Usuario("admin@example.com", "admin_password", "admin");
        Autenticacao autenticacao = new Autenticacao();
        String resultado = autenticacao.login(usuario);
        Assert.assertEquals("logado como admin", resultado);
    }

    @Test
    public void testLoginLogadoComoNormal() {
        // Simula a situação em que o usuário é do tipo "normal"
        Usuario usuario = new Usuario("user@example.com", "password", "normal");
        Autenticacao autenticacao = new Autenticacao();
        String resultado = autenticacao.login(usuario);
        Assert.assertEquals("logado", resultado);
    }
    
}
