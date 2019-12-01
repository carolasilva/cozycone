package servicos;

import servicos.Servicos;

public abstract class ServBase implements Servicos {
	@Override
	public String getDescricao() {		
		return "Servi�os adicionais:\n";
	}
}

