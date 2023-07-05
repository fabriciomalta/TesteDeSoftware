package exercicio07_16;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;

public class Resolvedor_test {

    @Test
    public void testDefinirPromocao_CodsNull_DeveLancarExcecao() {
        ClienteRepo repo = mock(ClienteRepo.class);
        Resolvedor resolvedor = new Resolvedor(repo);

        assertThrows(IllegalArgumentException.class, () -> {
            resolvedor.definirPromocao(null);
        });
    }

    @Test
    public void testDefinirPromocao_CodsVazio_DeveLancarExcecao() {
        ClienteRepo repo = mock(ClienteRepo.class);
        Resolvedor resolvedor = new Resolvedor(repo);

        assertThrows(IllegalArgumentException.class, () -> {
            resolvedor.definirPromocao(new int[0]);
        });
    }

    @Test
    public void testDefinirPromocao_CodInvalido_DeveLancarExcecao() throws Exception {
        ClienteRepo repo = mock(ClienteRepo.class);
        when(repo.getCliente(100)).thenReturn(null);
        Resolvedor resolvedor = new Resolvedor(repo);

        assertThrows(Exception.class, () -> {
            resolvedor.definirPromocao(new int[] { 100 });
        });
    }

    @Test
    public void testDefinirPromocao_MaisDeTresClientes_DeveDefinirDescontoDe25Porcento() throws Exception {
        ClienteRepo repo = mock(ClienteRepo.class);
        Cliente cliente1 = new Cliente(1, "Cliente 1");
        Cliente cliente2 = new Cliente(2, "Cliente 2");
        Cliente cliente3 = new Cliente(3, "Cliente 3");
        when(repo.getCliente(1)).thenReturn(cliente1);
        when(repo.getCliente(2)).thenReturn(cliente2);
        when(repo.getCliente(3)).thenReturn(cliente3);
        Resolvedor resolvedor = new Resolvedor(repo);

        ArrayList<Cliente> resultado = resolvedor.definirPromocao(new int[] { 1, 2, 3 });

        assertEquals(3, resultado.size());
        assertEquals(25, resultado.get(0).getDesconto());
        assertEquals(25, resultado.get(1).getDesconto());
        assertEquals(25, resultado.get(2).getDesconto());
    }

    @Test
    public void testDefinirPromocao_MenosDeTresClientes_DeveDefinirDescontosDiferentes() throws Exception {
        ClienteRepo repo = mock(ClienteRepo.class);
        Cliente cliente1 = new Cliente(1, "Cliente 1");
        Cliente cliente2 = new Cliente(2, "Cliente 2");
        when(repo.getCliente(1)).thenReturn(cliente1);
        when(repo.getCliente(2)).thenReturn(cliente2);
        Resolvedor resolvedor = new Resolvedor(repo);

        ArrayList<Cliente> resultado = resolvedor.definirPromocao(new int[] { 1, 2 });

        assertEquals(2, resultado.size());
        assertEquals(15, resultado.get(0).getDesconto());
        assertEquals(10, resultado.get(1).getDesconto());
    }
}
