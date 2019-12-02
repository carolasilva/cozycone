package test;

import business.Cliente;
import business.HotelCozyCone;
import business.TipoCone;
import org.junit.Test;
import servicos.Frigobar;
import servicos.SPA;
import servicos.ServBase;
import servicos.Servicos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class HotelCozyConeTest {
    HotelCozyCone hotel = HotelCozyCone.getInstance();
    Cliente cliente = new Cliente(hotel, "Carol");

    @Test
    public void checkInTest() {
        hotel.checkin(cliente, 5, TipoCone.SIMPLES);
        assertEquals(cliente, hotel.buscaClienteNoHotel("Carol"));
    }

    @Test
    public void checkInWithFullCapacity() {
        String nome;

        for (int i=0; i<10; i++) {
            nome = "teste" + i;
            Cliente c = new Cliente(hotel, nome);
            hotel.checkin(c, 5, TipoCone.SIMPLES);
        }
        assertEquals(null, hotel.buscaClienteNoHotel("Carol"));

    }

    @Test
    public void checkoutTest () {
        Cliente c = new Cliente(hotel, "João");
        hotel.checkin(c, 5, TipoCone.SIMPLES);
        assertEquals(c, hotel.buscaClienteNoHotel("João"));
        assertEquals(2400f, hotel.checkout("João"), 0);
        assertNull(hotel.buscaClienteNoHotel("João"));
    }

    @Test
    public void checkoutWithServices() {
        Cliente c = new Cliente(hotel, "João");
        hotel.checkin(c, 5, TipoCone.SIMPLES);
        Servicos servico = new ServBase();
        SPA spa = new SPA(servico);
        Frigobar frigobar = new Frigobar(servico);

        hotel.addService("João", frigobar);
        hotel.addService("João", spa);
        assertEquals(2560f, hotel.checkout("João"), 0);
        assertNull(hotel.buscaClienteNoHotel("João"));
    }

    @Test
    public void checkoutClienteInexistente () {
        assertEquals(0f, hotel.checkout("teste"), 0);
    }

    @Test
    public void checoutComTudo() {
        Cliente c = new Cliente(hotel, "João");
        hotel.checkin(c, 5, TipoCone.SIMPLES);
        Servicos servico = new ServBase();
        SPA spa = new SPA(servico);
        Frigobar frigobar = new Frigobar(servico);
        hotel.addService("João", frigobar);
        hotel.addService("João", spa);
        hotel.darFesta("João");

        assertEquals(2752f, hotel.checkout("João"), 0);
        assertNull(hotel.buscaClienteNoHotel("João"));
    }
}
