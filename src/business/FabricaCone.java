package business;

import business.Cone;
import business.ConeSimples;
import business.ConeVaranda;

public class FabricaCone {
	
	public Cone getCone(TipoCone tipocone) {
		if (tipocone == null) {
			return null;
		}
		if (tipocone.equals(TipoCone.SIMPLES)) {
			return new ConeSimples();
		} else if (tipocone.equals(TipoCone.VARANDA)) {
			return new ConeVaranda();
		}
		return null;
	}
}
