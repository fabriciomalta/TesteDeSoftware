package exercicio05b;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SomatoriaTest {

    @Test
    public void testSomaDeFatoriais_case1() {
        // Configuração do mock 
        MathOps mathOpsMock = mock(MathOps.class);
        when(mathOpsMock.fatorial(3)).thenReturn(6);
        when(mathOpsMock.fatorial(4)).thenReturn(24);

        Somatoria somatoria = new Somatoria(mathOpsMock);
        int[] numeros = {3, 4};
        int resultado = somatoria.somaDeFatoriais(numeros);

        assertEquals(30, resultado);
        verify(mathOpsMock, times(2)).fatorial(anyInt());
    }

    @Test
    public void testSomaDeFatoriais_case2() {
        // Configuração do mock 
        MathOps mathOpsMock = mock(MathOps.class);
        when(mathOpsMock.fatorial(0)).thenReturn(1);
        when(mathOpsMock.fatorial(1)).thenReturn(1);
        when(mathOpsMock.fatorial(2)).thenReturn(2);
        when(mathOpsMock.fatorial(3)).thenReturn(6);
        when(mathOpsMock.fatorial(4)).thenReturn(24);

        Somatoria somatoria = new Somatoria(mathOpsMock);

        int[] numeros = {0, 1, 2, 3, 4};
        int resultado = somatoria.somaDeFatoriais(numeros);

        assertEquals(34, resultado);

        verify(mathOpsMock, times(5)).fatorial(anyInt());
    }
}
