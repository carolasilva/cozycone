package business;

import servicos.ServBase;
import servicos.Servicos;

import java.util.List;

public interface Cone {
	public String incluir();
	//Factory de cones
	public double getDiaria();
	
	public void setDiaria(double diaria);
	
	public double getTaxaFesta();
	
	public void setTaxaFesta(double taxaFesta);

	public boolean isOcupado();

	public void setOcupado(boolean ocupado);

	public TipoCone getTipoCone();

	public Cliente getCliente();

	public void setCliente(Cliente cliente);

	public int getDias();

	public void setDias(int dias);

	public int getNumeroFestas() ;

	public void setNumeroFestas(int numeroFestas);

	@Override
	public boolean equals(Object obj);

	public List<Servicos> getServicos();

	public void setServicos(List<Servicos> servicos);
}
