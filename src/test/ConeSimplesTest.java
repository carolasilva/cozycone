package test;

import business.Cone;
import business.ConeSimples;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ConeSimplesTest {
    @Test
    public void incluirTest () {
        ConeSimples coneTeste = new ConeSimples();
        coneTeste.incluir();
        assertEquals(480.0f, coneTeste.getDiaria());
        assertEquals(1.4f, coneTeste.getTaxaFesta());
    }
}
