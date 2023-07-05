package exercicio09_13pce_avl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class AtendenteTest {

    @Mock
    private ProdutoDAO produtoDAO = Mockito.mock(ProdutoDAO.class);

    @Test
    public void testEfetuarPedidoDeOrcamentoCodigoValidoQuantidadeValida() throws Exception {
        Atendente atendente = new Atendente(produtoDAO);
        Mockito.when(produtoDAO.getQuantidadeDisponivel(Mockito.anyString())).thenReturn(50);

        assertEquals("Orcamento normal", atendente.efetuarPedidoDeOrcamento("1234567890123", 20));
    }

    @Test
    public void testEfetuarPedidoDeOrcamentoCodigoInvalido() throws Exception {
        Atendente atendente = new Atendente(produtoDAO);

        assertThrows(IllegalArgumentException.class, () ->
                atendente.efetuarPedidoDeOrcamento("12345678901", 10));
    }

    @Test
    public void testEfetuarPedidoDeOrcamentoQuantidadeInvalida() throws Exception {
        Atendente atendente = new Atendente(produtoDAO);

        assertThrows(IllegalArgumentException.class, () ->
                atendente.efetuarPedidoDeOrcamento("1234567890123", -10));
    }

    @Test
    public void testEfetuarPedidoDeOrcamentoSemEstoque() throws Exception {
        Atendente atendente = new Atendente(produtoDAO);
        Mockito.when(produtoDAO.getQuantidadeDisponivel(Mockito.anyString())).thenReturn(10);

        assertThrows(SemEstoqueException.class, () ->
                atendente.efetuarPedidoDeOrcamento("1234567890123", 20));
    }

    // Outros casos de teste seguindo a mesma estrutura
}
