import java.util.ArrayList;
import java.util.List;

public class HotelCozyCone {

	static final int MAX_SIMPLES = 4;
	static final int MAX_VARANDA = 2;
	
	private int vagas = MAX_SIMPLES + MAX_VARANDA;
	
	private List<Observador> observadores = new ArrayList<Observador>();

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
		
		if(this.vagas < MAX_SIMPLES + MAX_VARANDA)
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
