package exercicio08_05;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class Original_test {

	 @Test
	    public void testSomaDeFatoriais_m1() {
	        MathOps mathOps = mock(MathOps.class);
	        when(mathOps.fatorial(4)).thenReturn(24);

	        Mutante1 mutante1 = new Mutante1(mathOps);
	        int[] vet = {2, 4, 6};
	        int resultado = mutante1.somaDeFatoriais(vet);
	        assertEquals(24, resultado);
	    }
	 @Test
	    public void testSomaDeFatoriais_m2() {
	        MathOps mathOps = mock(MathOps.class);
	        when(mathOps.fatorial(4)).thenReturn(24);

	        Mutante2 mutante2 = new Mutante2(mathOps);
	        int[] vet = {2, 4, 6};
	        int resultado = mutante2.somaDeFatoriais(vet);
	        assertEquals(24, resultado);
	    }
	  @Test
	    public void testSomaDeFatoriais_m3() {
	        MathOps mathOps = mock(MathOps.class);
	        when(mathOps.fatorial(4)).thenReturn(24);

	        Mutante3 mutante3 = new Mutante3(mathOps);
	        int[] vet = {2, 4, 6};
	        int resultado = mutante3.somaDeFatoriais(vet);
	        assertEquals(24, resultado);
	    }
	  //O Mutante1 é diferente do original porque inicia o loop no índice 1 em vez de 0. O caso de teste verifica se o resultado é 24 quando os valores do vetor são {2, 4, 6}, o que não ocorre no original.
	  //O Mutante2 é equivalente ao original, pois as alterações no código não afetam o resultado final.
	  //O Mutante3 é diferente do original porque usa a operação de divisão em vez do operador de módulo. O caso de teste verifica se o resultado é 24 quando os valores do vetor são {2, 4, 6}, o que não ocorre no original.
}
