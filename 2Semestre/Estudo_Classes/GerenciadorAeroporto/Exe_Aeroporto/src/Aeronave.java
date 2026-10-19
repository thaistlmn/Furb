
public class Aeronave {
	private int codigo;
	private String modelo;
	private int capMaxPassageiros;

	public Aeronave(int codigo, String modelo, int capMaxPassageiros) {
		setCodigo(codigo);
		setModelo(modelo);
		setCapMaxPassageiros(capMaxPassageiros);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) throws IllegalArgumentException {
		if (codigo <= 0) {
			throw new IllegalArgumentException("Código inválido. Digite um valor acima de 0(zero)");
		}

		this.codigo = codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) throws IllegalArgumentException {
		if (modelo == null || modelo.isBlank()) {
			throw new IllegalArgumentException("Nome do modelo deve ser informado");
		}
		this.modelo = modelo;
	}

	public int getCapMaxPassageiros() {
		return capMaxPassageiros;
	}

	public void setCapMaxPassageiros(int capMaxPassageiros) throws IllegalArgumentException {
		if (capMaxPassageiros > 600) {
			throw new IllegalArgumentException(
					"Não é possível cadastrar um voo com quantidade acima de 600 passageiros");
		}
		if (capMaxPassageiros == 0) {
			throw new IllegalArgumentException("Número inválido \n Insira um número acima de 0 (zero)");
		}
		if (capMaxPassageiros < 0) {
			throw new IllegalArgumentException("Não é possível cadastrar um voo com quantidade inferor a 0 (zero)");
		}
		this.capMaxPassageiros = capMaxPassageiros;
	}

	// metodo imprimir
	public String imprimir() {
		return "Código: " + getCodigo() + "\nModelo: " + getModelo() + "\nCapacidade Máx. Passageiros: "
				+ getCapMaxPassageiros();
	}
}
