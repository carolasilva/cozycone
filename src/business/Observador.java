package business;

import business.HotelCozyCone;

public abstract class Observador {

	protected HotelCozyCone hotel;
	
	//OBSERVER
	//Para avisar os clientes e o letreiro que h� vagas
	public abstract void update();
}
