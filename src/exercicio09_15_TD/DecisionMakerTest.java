package exercicio09_15_TD;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class DecisionMakerTest {


    @Test
    public void testMostrarAnuncioInativoPor2Semanas() {
        Usuario usuario = new Usuario(500, true, false);
        DecisionMaker decisionMaker = new DecisionMaker();
        boolean resultado = decisionMaker.mostrarAnuncio(usuario, true);
        Assert.assertFalse(resultado);
    }

    @Test
    public void testMostrarAnuncioViuAnuncioUltimaHora() {
        Usuario usuario = new Usuario(500, false, true);
        DecisionMaker decisionMaker = new DecisionMaker();
        boolean resultado = decisionMaker.mostrarAnuncio(usuario, true);
        Assert.assertFalse(resultado);
    }

    @Test
    public void testMostrarAnuncioUsuarioInfluenciadorRelevante() {
        Usuario usuario = new Usuario(1500, false, false);
        DecisionMaker decisionMaker = new DecisionMaker();
        boolean resultado = decisionMaker.mostrarAnuncio(usuario, true);
        Assert.assertTrue(resultado);
    }

    @Test
    public void testMostrarAnuncioUsuarioInfluenciadorIrrelevante() {
        Usuario usuario = new Usuario(1500, false, false);
        DecisionMaker decisionMaker = new DecisionMaker();
        boolean resultado = decisionMaker.mostrarAnuncio(usuario, false);
        Assert.assertTrue(resultado);
    }

    @Test
    public void testMostrarAnuncioUsuarioNaoInfluenciador() {
        Usuario usuario = new Usuario(500, false, false);
        DecisionMaker decisionMaker = new DecisionMaker();
        boolean resultado = decisionMaker.mostrarAnuncio(usuario, false);
        Assert.assertTrue(resultado);
    }
}