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
	private List<Cliente> filaDeEspera = new ArrayList<>();

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
		int index = coneDisponivel(tipoCone);
		if (index == -1) {
			System.out.println("Hotel cheio para esse tipo de quarto!");
			filaDeEspera.add(cliente);
		}
		else {
			List<Cone> listaCones = getCones();
			listaCones.remove(index);
			FabricaCone fabrica = new FabricaCone();
			Cone cone = fabrica.getCone(tipoCone);
			cone.setOcupado(true);
			cone.setCliente(cliente);
			cone.setDias(numeroDiarias);
			listaCones.add(cone);
			setCones(listaCones);

		}
	}

	public double checkout(String nome) {
		Cliente cliente = buscaClienteNoHotel(nome);
		if (cliente == null) {
			System.out.println("Esse cliente não está hospedado no hotel");
			return 0;
		}

		if (getFilaDeEspera() != null) {
			notificaObservadores();
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

	private int coneDisponivel (TipoCone tipoCone) {
		int i = 0;
		for (Cone cone : getCones()) {
			if (cone.getTipoCone() == tipoCone && cone.isOcupado() == false) {
				return i;
			}
			i++;
		}
		return -1;
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

	public boolean addService(String nome, Servicos servico) {
		List<Cone> listaCones = getCones();
		int index = buscaConeNoHotel(nome);

		if (index == -1)
			return false;

		Cone cone = listaCones.get(index);

		List<Servicos> servicos = cone.getServicos();
		servicos.add(servico);

		listaCones.remove(index);
		cone.setServicos(servicos);
		listaCones.add(cone);
		setCones(listaCones);

		return true;
	}

	public boolean darFesta (String nome) {
		List<Cone> listaCones = getCones();
		int index = buscaConeNoHotel(nome);

		if (index == -1)
			return false;

		Cone cone = listaCones.get(index);
		listaCones.remove(index);

		int numeroFestas = cone.getNumeroFestas();
		cone.setNumeroFestas(numeroFestas + 1);
		listaCones.add(cone);
		setCones(listaCones);

		return true;
	}

	public List<Cliente> getFilaDeEspera() {
		return filaDeEspera;
	}

	public void setFilaDeEspera(List<Cliente> filaDeEspera) {
		this.filaDeEspera = filaDeEspera;
	}
}
