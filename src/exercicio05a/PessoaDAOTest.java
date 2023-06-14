package exercicio05a;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class PessoaDAOTest {


    // CT1: Testa a situação em que a pessoa existe
    @Test
    public void testExistePessoa_PessoaExiste() {
        // Preparação dos dados de teste
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("João");
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Maria");
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);

        // Criação do mock do RHService
        RHService rhServiceMock = new RHService() {
            @Override
            public ArrayList<Pessoa> getAllPessoas() {
                return pessoas;
            }
        };

        // Executa teste
        PessoaDAO pessoaDAO = new PessoaDAO(rhServiceMock);
        boolean resultado = pessoaDAO.existePessoa("João");

        // Verificação do resultado esperado
        Assert.assertTrue(resultado);
    }

    // CT2: Testa a situação em que a pessoa não existe
    @Test
    public void testExistePessoa_PessoaNaoExiste() {
        // Preparação dos dados de teste
        ArrayList<Pessoa> pessoas = new ArrayList<>();

        // Criação do mock do RHService
        RHService rhServiceMock = new RHService() {
            @Override
            public ArrayList<Pessoa> getAllPessoas() {
                return pessoas;
            }
        };

        // Execução do teste
        PessoaDAO pessoaDAO = new PessoaDAO(rhServiceMock);
        boolean resultado = pessoaDAO.existePessoa("Carlos");

        // Verificação do resultado esperado
        Assert.assertFalse(resultado);
    }
}
