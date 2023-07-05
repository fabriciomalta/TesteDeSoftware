package exercicio08_06;

import static org.junit.Assert.*;

import org.junit.Test;

public class Original_test {

    @Test
    public void testConverterParaRomano_m1() {
        Mutante1 mutante1 = new Mutante1();
        String resultado = mutante1.coverterParaRomano(400);
        assertEquals("CD", resultado);
    }
    @Test
    public void testConverterParaRomano_m2() {
        Mutante2 mutante2 = new Mutante2();
        String resultado = mutante2.coverterParaRomano(400);
        assertEquals("", resultado);
    }
    @Test
    public void testConverterParaRomano_m3() {
        Mutante3 mutante3 = new Mutante3();
        String resultado = mutante3.coverterParaRomano(0);
        assertEquals("", resultado);
    }
    //O Mutante1 é diferente do original porque substitui "CD" por "Cd" na lista de romanos. O caso de teste verifica se o resultado é "CD" quando o número de entrada é 400, o que não ocorre no original.
    //O Mutante2 é diferente do original porque altera o valor 10000 para o primeiro elemento do array "num". O caso de teste verifica se o resultado é uma string vazia quando o número de entrada é 400, o que não ocorre no original.
    //O Mutante3 é diferente do original porque substitui a condição "numero != 0" por "numero > 0" no loop while. O caso de teste verifica se o resultado é uma string vazia quando o número de entrada é 0, o que não ocorre no original.
}
