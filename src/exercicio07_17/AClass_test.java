package exercicio07_17;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class AClass_test {

    @Test
    public void testCifrarInvalidInput() {
        // Arrange
        ArrayList<String> msg = null;
        AClass aClass = new AClass(Mockito.mock(Coder1.class), Mockito.mock(Coder2.class), Mockito.mock(Coder3.class));

        // Act
        String result = aClass.cifrar(msg);

        // Assert
        assertEquals("INVALID", result);
    }

    @Test
    public void testCifrarInvalidInputContainsSTOP() {
        // Arrange
        ArrayList<String> msg = new ArrayList<>();
        msg.add("Hello");
        msg.add("STOP");
        AClass aClass = new AClass(Mockito.mock(Coder1.class), Mockito.mock(Coder2.class), Mockito.mock(Coder3.class));

        // Act
        String result = aClass.cifrar(msg);

        // Assert
        assertEquals("INVALID", result);
    }

    @Test
    public void testCifrarCoder1AndCoder2True() {
        // Arrange
        ArrayList<String> msg = new ArrayList<>();
        msg.add("Hello");
        msg.add("World");
        Coder1 coder1 = Mockito.mock(Coder1.class);
        Coder2 coder2 = Mockito.mock(Coder2.class);
        Mockito.when(coder1.m1(msg)).thenReturn(true);
        Mockito.when(coder2.m2(msg)).thenReturn(true);
        AClass aClass = new AClass(coder1, coder2, Mockito.mock(Coder3.class));

        // Act
        String result = aClass.cifrar(msg);

        // Assert
        assertEquals("C1-C2", result);
    }

    @Test
    public void testCifrarTwoOrMoreHIs() {
        // Arrange
        ArrayList<String> msg = new ArrayList<>();
        msg.add("HI");
        msg.add("Hello");
        msg.add("HI");
        Coder1 coder1 = Mockito.mock(Coder1.class);
        Coder2 coder2 = Mockito.mock(Coder2.class);
        AClass aClass = new AClass(coder1, coder2, Mockito.mock(Coder3.class));

        // Act
        String result = aClass.cifrar(msg);

        // Assert
        assertEquals("2 OR MORE HIs", result);
    }

    @Test
    public void testCifrarCoder3GreaterThan1() {
        // Arrange
        ArrayList<String> msg = new ArrayList<>();
        msg.add("Hello");
        Coder3 coder3 = Mockito.mock(Coder3.class);
        Mockito.when(coder3.m3()).thenReturn(3);
        AClass aClass = new AClass(Mockito.mock(Coder1.class), Mockito.mock(Coder2.class), coder3);

        // Act
        String result = aClass.cifrar(msg);

        // Assert
        assertEquals("-Hello-Hello-Hello", result);
    }

    @Test
    public void testCifrarDefaultCase() {
        // Arrange
        ArrayList<String> msg = new ArrayList<>();
        msg.add("Hello");
        Coder3 coder3 = Mockito.mock(Coder3.class);
        Mockito.when(coder3.m3()).thenReturn(1);
        AClass aClass = new AClass(Mockito.mock(Coder1.class), Mockito.mock(Coder2.class), coder3);

        // Act
        String result = aClass.cifrar(msg);

        // Assert
        assertEquals("Hello", result);
    }
}
