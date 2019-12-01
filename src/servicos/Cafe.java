package servicos;

public class Cafe extends ServBase{
	private final Servicos servico;
	
	public Cafe (Servicos servico) {
		this.servico = servico;
	}

	@Override
	public double getPreco() {
		return servico.getPreco() + 20;
	}

	@Override
	public String getDescricao() {
		return servico.getDescricao() + ", Café da Manhã (20,00)";
	}
}
