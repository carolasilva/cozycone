package business;

public class Cliente extends Observador {

	String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public Cliente(HotelCozyCone hotel, String nome) {
		this.hotel = hotel;
		this.hotel.attach(this);
		this.setNome(nome);
	}

	@Override
	public void update() {
		
		System.out.print("business.Cliente " + this.getNome() + "notificado!");
	}

	@Override
	public boolean equals(Object obj) {
		return this.getNome().equalsIgnoreCase(((Cliente) obj).getNome());
	}
	
}
