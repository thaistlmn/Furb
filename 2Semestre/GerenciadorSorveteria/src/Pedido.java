import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private int nrId;
	private String nomeCliente;
	private List<Sorvete> sorvetes;

	public Pedido(int nrId, String nomeCliente) {
		setId(nrId);
		setNomeCliente(nomeCliente);
		sorvetes = new ArrayList<Sorvete>();
	}

	public int getId() {
		return nrId;
	}

	public void setId(int nrId) throws IllegalArgumentException {
		if (nrId <= 0) {
			throw new IllegalArgumentException("Número de identificação precisa ser maior que 0 (zero)");
		}
		this.nrId = nrId;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) throws IllegalArgumentException {
		if (nomeCliente == null || nomeCliente.isBlank()) {
			throw new IllegalArgumentException("Nome do cliente precisa ser informado");
		}
		this.nomeCliente = nomeCliente;
	}

	public List<Sorvete> getSorvetes() {
		return sorvetes;
	}

}