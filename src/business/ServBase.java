package business;

public abstract class ServBase implements Servicos {

	@Override
	public String getDesc() {		
		return "Servi�os adicionais:\n";
	}	

	public double getPreco();
}
