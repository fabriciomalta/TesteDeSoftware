package exercicio02;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Test;

public class Utilitario_test {


    @Test
    public void testAcharExtremosCaso1() throws Exception {
        int[] vetor = {2, 4, 6, 8, 6, 10};
        Utilitario utilitario = new Utilitario();
        Extremos extremos = utilitario.acharExtremos(vetor);

        assertEquals(2, extremos.getMenor());
        assertEquals(0, extremos.getIndiceMenor());
        assertEquals(10, extremos.getMaior());
        assertEquals(5, extremos.getIndiceMaior());
    }

    @Test
    public void testAcharExtremosCaso2() throws Exception {
        int[] vetor = {1, 99, 3, -5, 8};
        Utilitario utilitario = new Utilitario();
        Extremos extremos = utilitario.acharExtremos(vetor);

        assertEquals(-5, extremos.getMenor());
        assertEquals(3, extremos.getIndiceMenor());
        assertEquals(99, extremos.getMaior());
        assertEquals(1, extremos.getIndiceMaior());
    }

    @Test(expected = Exception.class)
    public void testAcharExtremosCaso3() throws Exception {
        int[] vetor = {};
        Utilitario utilitario = new Utilitario();
        Extremos extremos = utilitario.acharExtremos(vetor);
    }

    @Test(expected = Exception.class)
    public void testAcharExtremosCaso4() throws Exception {
        int[] vetor = null;
        Utilitario utilitario = new Utilitario();
        Extremos extremos = utilitario.acharExtremos(vetor);
    }

}
