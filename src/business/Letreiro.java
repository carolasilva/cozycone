package business;

import business.HotelCozyCone;

public class Letreiro extends Observador {
	
	boolean haVagas = true;
	
	public Letreiro (HotelCozyCone hotel) {
		this.hotel = hotel;
		this.hotel.attach(this);
		
	}

	@Override
	public void update() {

		if (haVagas == false)
			System.out.println("business.Letreiro aceso: HÁ VAGAS");
		else if (haVagas == true)
			System.out.println("business.Letreiro apagado...");
	}
	
}
