package test;

import business.Cliente;
import business.HotelCozyCone;
import business.TipoCone;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        hotel.checkin(cliente, 5, TipoCone.SIMPLES);
        assertEquals(cliente, hotel.buscaClienteNoHotel("Carol"));
        hotel.checkout("Carol");
        assertEquals(null, hotel.buscaClienteNoHotel("Carol"));
    }

    @Test
    public void checkoutClienteInexistente() {
        assertEquals(0, hotel.checkout("oi"), 0);
    }
}
