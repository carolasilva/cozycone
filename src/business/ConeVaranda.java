package business;

import business.Cone;
import servicos.ServBase;
import servicos.Servicos;

import java.util.ArrayList;
import java.util.List;

public class ConeVaranda implements Cone {
	
	double diaria = 620;
	double taxaFesta = 1.3;
	private boolean ocupado;
	private TipoCone tipoCone;
	private Cliente cliente;
	private int dias;
	private int numeroFestas;
	private List<Servicos> servicos = new ArrayList<>();

	public ConeVaranda() {
		setOcupado(false);
	}
	@Override
	public String incluir() {
		diaria = 620;
		taxaFesta = (float) 1.3;
		return "Escolheu cone com varanda ";		
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
		return false;
	}

	@Override
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	@Override
	public TipoCone getTipoCone() {
		return this.tipoCone;
	}

	@Override
	public Cliente getCliente() {
		return this.cliente;
	}

	@Override
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

	@Override
	public int getNumeroFestas() {
		return this.numeroFestas;
	}

	@Override
	public void setNumeroFestas(int numeroFestas) {
		this.numeroFestas = numeroFestas;
	}

	public boolean equals(Object obj) {
		return this.getCliente().equals(((Cone) obj).getCliente());
	}

	public List<Servicos> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servicos> servicos) {
		this.servicos = servicos;
	}
}
