package exercicio09_12pce_avl;

import static org.junit.Assert.*;

import org.junit.Test;

import org.mockito.Mock;
import org.mockito.Mockito;

public class Montanha_Test {

    @Mock
    private ClienteDao clienteDao = Mockito.mock(ClienteDao.class);

    @Test
    public void testAutorizarNomeValidoIdadeValida() throws Exception {
        MontanhaRussaControlador controlador = new MontanhaRussaControlador(clienteDao);
        Mockito.when(clienteDao.ehCliente(Mockito.anyString())).thenReturn(true);

        assertEquals("autorizado", controlador.autorizar("Nome Completo", 25));
    }

    @Test
    public void testAutorizarNomeInvalido() throws Exception {
        MontanhaRussaControlador controlador = new MontanhaRussaControlador(clienteDao);
        assertThrows(Exception.class, () -> controlador.autorizar("Nome", 25));
    }

    @Test
    public void testAutorizarIdadeInvalida() throws Exception {
        MontanhaRussaControlador controlador = new MontanhaRussaControlador(clienteDao);

        assertThrows(Exception.class, () -> controlador.autorizar("Nome Completo", 0));
    }

    
}