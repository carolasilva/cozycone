package business;

import business.Cone;

public class ConeVaranda implements Cone {
	
	double diaria = 620;
	double taxaFesta = 1.3;
	
	@Override
	public String incluir() {
		diaria = 620;
		taxaFesta = (float) 1.3;
		return "Escolheu cone com varanda ";		
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
//
//	@Override
//	public String incluir() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
