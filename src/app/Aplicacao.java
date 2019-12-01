package app;

import business.*;

public class Aplicacao {

	public static void main(String[] args) {

		//singleton
		HotelCozyCone hotel = HotelCozyCone.getInstance();
		
		//observers
		new Letreiro(hotel);
		new Cliente(hotel);
		new Cliente(hotel);		
		new Cliente(hotel);		
		new Cliente(hotel);		
		new Cliente(hotel);
		
		//factory
		FabricaCone fabrica = new FabricaCone();
		Cone cone101 = fabrica.getCone(TipoCone.SIMPLES);
		cone101.incluir();
		Cone cone102 = fabrica.getCone(TipoCone.SIMPLES);
		cone102.incluir();
		Cone cone201 = fabrica.getCone(TipoCone.VARANDA);
		cone201.incluir();
		Cone cone202 = fabrica.getCone(TipoCone.VARANDA);
		cone202.incluir();
		
	}
	
}
