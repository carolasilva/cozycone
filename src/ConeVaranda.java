
public class ConeVaranda implements Cone {

	float diaria, taxaFesta;
	
	@Override
	public void incluir() {
		diaria = 620;
		taxaFesta = (float) 1.3;		
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
