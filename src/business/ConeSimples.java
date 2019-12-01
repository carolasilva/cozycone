package business;

import business.Cone;

public class ConeSimples implements Cone {

	double diaria = 480;
	double taxaFesta = 1.4;
	
	@Override
	public String incluir() {
		diaria = 480;
		taxaFesta = (float) 1.4;
		return "Escolheu cone simples ";	
	}
//	
//	@Override
//	public double getDiaria() {
//		return diaria;
//	}
//	
//	@Override
//	public void setDiaria(double diaria) {
//		this.diaria = diaria;
//	}
//	
//	@Override
//	public double getTaxaFesta() {
//		return taxaFesta;
//	}
//	
//	@Override
//	public void setTaxaFesta(double taxaFesta) {
//		this.taxaFesta = taxaFesta;
//	}
}
