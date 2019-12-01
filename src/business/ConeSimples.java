package business;

import business.Cone;

public class ConeSimples implements Cone {

	float diaria, taxaFesta;
	
	@Override
	public void incluir() {
		diaria = 480;
		taxaFesta = (float) 1.4;		
	}
	
	public float getDiaria() {
		return diaria;
	}
	
	public void setDiaria(float diaria) {
		this.diaria = diaria;
	}
	
	public float getTaxaFesta() {
		return taxaFesta;
	}
	
	public void setTaxaFesta(float taxaFesta) {
		this.taxaFesta = taxaFesta;
	}
}
