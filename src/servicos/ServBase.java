package servicos;

import servicos.Servicos;

public class ServBase implements Servicos {
	@Override
	public String getDescricao() {		
		return "Servi�os adicionais:\n";
	}

	@Override
	public double getPreco() {
		return 0;
	}
}

