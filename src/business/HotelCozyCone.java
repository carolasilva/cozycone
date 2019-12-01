package business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelCozyCone {
	
	private static final HotelCozyCone HOTEL = new HotelCozyCone();

	private HotelCozyCone() {
	}
	static int maxSimples = 10, maxVaranda = 10;
	private int vagas = maxSimples + maxVaranda;
	private List<Observador> observadores = new ArrayList<Observador>();
	private static List<Cone> cones = new ArrayList<Cone>();

	public static HotelCozyCone getInstance() {
		inicializaHotel();
		return HOTEL;
	}

	public static void inicializaHotel() {
		//factory
		FabricaCone fabrica = new FabricaCone();
		for (int i=0; i<maxSimples; i++)
			cones.add(fabrica.getCone(TipoCone.SIMPLES));
		for (int i=0; i<maxVaranda; i++)
			cones.add(fabrica.getCone(TipoCone.VARANDA));
	}
	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
		
		if(this.vagas < maxSimples + maxVaranda)
			notificaObservadores();
	}

	public void attach(Observador observador) {
		observadores.add(observador);
	}

	public void notificaObservadores() {
		for (Observador observador : observadores) {
			observador.update();
		}
	}

	public void checkin(Cliente cliente, int numeroDiarias, TipoCone tipoCone) {
		Cone cone = coneDisponivel(tipoCone);
		if (cone == null) {
			// ADICIONA CLIENTE NA LISTA DE ESPERA
		}
		else {
			cone.setOcupado(true);
			cone.setCliente(cliente);
			cone.setDias(numeroDiarias);
		}
	}

	public double checkout(String nome) {
		Cliente cliente = buscaClienteNoHotel(nome);
		if (cliente == null) {
			System.out.println("Esse cliente não está hospedado no hotel");
			return 0;
		}
		Cone cone = buscaConeNoHotel(nome);
		int diasSemFesta = cone.getDias() - cone.getNumeroFestas();
		int diasComFesta = cone.getNumeroFestas();

		cone.setDias(0);
		cone.setCliente(null);
		cone.setOcupado(false);
		cone.setNumeroFestas(0);

		return (diasSemFesta * cone.getDiaria()) + (diasComFesta + (cone.getTaxaFesta() * cone.getDiaria()));
	}

	private Cone coneDisponivel (TipoCone tipoCone) {
		for (Cone cone : cones) {
			if (cone.getTipoCone() == tipoCone && cone.isOcupado() == false) {
				return cone;
			}
		}
		return null;
	}
	public Cliente buscaClienteNoHotel(String nome) {
		List<Cone> cones = HotelCozyCone.getCones();
		for (Cone cone : cones) {
			if (cone.isOcupado()) {
				if (cone.getCliente().getNome().equalsIgnoreCase(nome))
					return cone.getCliente();
			}
		}

		return null;
	}

	public Cone buscaConeNoHotel(String nome) {
		List<Cone> cones = HotelCozyCone.getCones();
		for (Cone cone : cones) {
			if (cone.isOcupado()) {
				if (cone.getCliente().getNome().equalsIgnoreCase(nome))
					return cone;
			}
		}

		return null;
	}

	public static List<Cone> getCones() {
		return cones;
	}

	public static void setCones(List<Cone> cones) {
		HotelCozyCone.cones = cones;
	}
}
