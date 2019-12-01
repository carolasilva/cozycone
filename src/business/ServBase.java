package business;

public abstract class ServBase implements Servicos {

	@Override
	public String getDesc() {		
		return "Serviços adicionais:\n";
	}	

	public double getPreco();
}
