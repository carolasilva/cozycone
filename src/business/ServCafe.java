package business;

public class ServCafe implements Servicos{

	private final ServBase servico;
	
	public ServCafe (Servicos servico) {
		this.servico = (ServBase) servico;
	}

	@Override
	public double incluir() {
		return servico.getPreco() + 20;
	}

	@Override
	public String getDesc() {
		return servico.getDesc() + ", Caf� da Manh� (20,00)";
	}
}
