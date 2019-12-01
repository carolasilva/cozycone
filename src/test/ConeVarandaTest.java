package test;

import business.ConeSimples;
import business.ConeVaranda;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ConeVarandaTest {
    @Test
    public void incluirTest () {
        ConeVaranda coneTeste = new ConeVaranda();
        coneTeste.incluir();
        assertEquals(620.0f, coneTeste.getDiaria());
        assertEquals(1.3f, coneTeste.getTaxaFesta());
    }
}
