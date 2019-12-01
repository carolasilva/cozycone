package servicos;

public abstract class ServBase implements Servicos {
	@Override
	public String getDescricao() {		
		return "Serviços adicionais:\n";
	}
}