import java.util.ArrayList;
import java.util.List;

public class HotelCozyCone {
	
	private static final HotelCozyCone HOTEL = new HotelCozyCone();

	private HotelCozyCone() {
	}

	public static HotelCozyCone getInstance() {
		return HOTEL;
	}

	static int maxSimples, maxVaranda;
	
	private int vagas = maxSimples + maxVaranda;
	
	private List<Observador> observadores = new ArrayList<Observador>();

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
}
