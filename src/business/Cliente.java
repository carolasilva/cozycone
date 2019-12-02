package business;

import java.util.ArrayList;
import java.util.List;

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
		List<Cliente> clientes = this.hotel.getFilaDeEspera();
		List<Cliente> vazia = new ArrayList<>();

		for (Cliente cliente : clientes) {
			System.out.print("Cliente " + this.getNome() + " notificado!");
		}

		this.hotel.setFilaDeEspera(vazia);
	}

	@Override
	public boolean equals(Object obj) {
		return this.getNome().equalsIgnoreCase(((Cliente) obj).getNome());
	}
	
}
