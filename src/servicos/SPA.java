package servicos;

public class SPA extends ServBase {
	private final Servicos servico;
	
	public SPA (Servicos servico) {
		this.servico = servico;
	}

	@Override
	public double getPreco() {
		return servico.getPreco() + 120;
	}

	@Override
	public String getDescricao() {
		return servico.getDescricao() + ", Spa (120,00)";
	}
}
