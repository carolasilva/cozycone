package business;

import business.Cone;
import servicos.ServBase;

public class ConeSimples implements Cone {

	double diaria = 480;
	double taxaFesta = 1.4;
	boolean ocupado;
	TipoCone tipoCone = TipoCone.SIMPLES;
	Cliente cliente;
	private int dias;
	private int numeroFestas;

	ConeSimples() {
		setOcupado(false);
	}
	@Override
	public String incluir() {
		diaria = 480;
		taxaFesta = (float) 1.4;
		return "Escolheu cone simples ";	
	}

	@Override
	public double getDiaria() {
		return diaria;
	}

	@Override
	public void setDiaria(double diaria) {
		this.diaria = diaria;
	}

	@Override
	public double getTaxaFesta() {
		return taxaFesta;
	}

	@Override
	public void setTaxaFesta(double taxaFesta) {
		this.taxaFesta = taxaFesta;
	}

	@Override
	public boolean isOcupado() {
		return ocupado;
	}

	@Override
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	@Override
	public TipoCone getTipoCone() {
		return this.tipoCone;
	}

	public void setTipoCone(TipoCone tipoCone) {
		this.tipoCone = tipoCone;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int getDias() {
		return this.dias;
	}

	@Override
	public void setDias(int dias) {
		this.dias = dias;
	}

	public int getNumeroFestas() {
		return numeroFestas;
	}

	public void setNumeroFestas(int numeroFestas) {
		this.numeroFestas = numeroFestas;
	}

	public boolean equals(Object obj) {
		return this.getCliente().equals(((Cone) obj).getCliente());
	}
}
