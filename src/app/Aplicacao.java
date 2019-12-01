package app;

import business.*;

public class Aplicacao {

	public static void main(String[] args) {

		//singleton
		HotelCozyCone hotel = HotelCozyCone.getInstance();
		
		//observers
		new Letreiro(hotel);		
		new Cliente(hotel, "AAA");		
		new Cliente(hotel, "BBB");		
		new Cliente(hotel, "CCC");		
		new Cliente(hotel, "DDD");		
		new Cliente(hotel, "EEE");		
		new Cliente(hotel, "FFF");
		
	}
	
}
