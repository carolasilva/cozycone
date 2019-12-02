package servicos;

public class Frigobar extends ServBase{
	private final Servicos servico;
		
	public Frigobar (Servicos servico) {
		this.servico = servico;
	}

    @Override
	public double getPreco() {
		return servico.getPreco() + 40;
	}

	@Override
	public String getDescricao() {
		return servico.getDescricao() + ", Frigobar (40,00)";
	}
}
