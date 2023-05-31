package exercicio01;

import org.junit.Test;
import static org.junit.Assert.*;

public class Aleatorio_test {

    @Test
    public void testInicioNegativo() {
        Aleatorio aleatorio = new Aleatorio();
        int resultado = aleatorio.gerarNumeroAleatorio(-7, 5);
        assertEquals(-1, resultado);
    }

    @Test
    public void testFimNegativo() {
        Aleatorio aleatorio = new Aleatorio();
        int resultado = aleatorio.gerarNumeroAleatorio(5, -10);
        assertEquals(-1, resultado);
    }

    @Test
    public void testInicioIgualAoFim() {
        Aleatorio aleatorio = new Aleatorio();
        int resultado = aleatorio.gerarNumeroAleatorio(10, 10);
        assertEquals(-1, resultado);
    }

    @Test
    public void testIntervaloValido() {
        Aleatorio aleatorio = new Aleatorio();
        int resultado = aleatorio.gerarNumeroAleatorio(500, 5000);
        assertTrue(resultado >= 500 && resultado <= 5000);
    }
}