package business;

import servicos.SPA;
import servicos.ServBase;
import servicos.Servicos;

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
	private List<Servicos> servicos = new ArrayList<>();

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

		int index = buscaConeNoHotel(nome);
		//Cone cone = buscaConeNoHotel(nome);

		List<Cone> conesList = getCones();
		Cone cone = conesList.get(index);
		conesList.remove(index);

		int diasSemFesta = cone.getDias() - cone.getNumeroFestas();
		int diasComFesta = cone.getNumeroFestas();
		double valorServicos = 0;

		for (Servicos serv : cone.getServicos()) {
			valorServicos += serv.getPreco();
		}

		cone.setDias(0);
		cone.setCliente(null);
		cone.setOcupado(false);
		cone.setNumeroFestas(0);

		conesList.add(cone);
		setCones(conesList);

		return (diasSemFesta * cone.getDiaria()) + (diasComFesta * (cone.getTaxaFesta() * cone.getDiaria())) + valorServicos;
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

	public int buscaConeNoHotel(String nome) {
		int i = 0;
		List<Cone> cones = HotelCozyCone.getCones();
		for (Cone cone : cones) {
			if (cone.isOcupado()) {
				if (cone.getCliente().getNome().equalsIgnoreCase(nome))
					return i;
			}
			i++;
		}

		return -1;
	}

	public static List<Cone> getCones() {
		return cones;
	}

	public static void setCones(List<Cone> cones) {
		HotelCozyCone.cones = cones;
	}

	public void addService(String nome, Servicos servico) {
		List<Cone> listaCones = getCones();
		Cone cone = listaCones.get(buscaConeNoHotel(nome));
		List<Servicos> servicos = cone.getServicos();
		servicos.add(servico);
		cone.setServicos(servicos);
	}

	
}
