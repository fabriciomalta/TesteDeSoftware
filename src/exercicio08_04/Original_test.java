package exercicio08_04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class Original_test {
    @Test
    //matar mutante 1
    public void testDefinirFaixaEtaria_1() {
        Pessoa pessoa = mock(Pessoa.class);
        when(pessoa.getIdade()).thenReturn(-5);

        Mutante1 mutante1 = new Mutante1();
        assertThrows(IllegalArgumentException.class, () -> mutante1.definirFaixaEtaria(pessoa));
    }
    
    @Test
    public void testDefinirFaixaEtaria_2() {
        Pessoa pessoa = mock(Pessoa.class);
        when(pessoa.getIdade()).thenReturn(20);

        Mutante2 mutante2 = new Mutante2();
        String resultado = mutante2.definirFaixaEtaria(pessoa);
        assertEquals("John eh adulto", resultado);
    }
    
    @Test
    public void testDefinirFaixaEtaria() {
        Pessoa pessoa = mock(Pessoa.class);
        when(pessoa.getIdade()).thenReturn(30);

        Mutante3 mutante3 = new Mutante3();
        String resultado = mutante3.definirFaixaEtaria(pessoa);
        assertEquals("John eh adulto", resultado);
    }
    //O Mutante1 é diferente do original porque usa o operador lógico "&&" em vez de "||". O caso de teste verifica se o lançamento de uma exceção ocorre quando a idade é negativa, o que não ocorre no original.
    //O Mutante2 é equivalente ao original, pois as alterações no código não afetam o resultado final.
    //O Mutante3 é diferente do original porque altera a condição do terceiro "if" para "idade == 59". O caso de teste verifica se o resultado é "adulto" quando a idade é 30, o que não ocorre no original.
}
