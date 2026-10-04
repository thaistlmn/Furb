
public class Voo {
	// atributos
	private int num;
	private String destino;
	private int qtdPassageiros;
	private String hrPrevista;
	private Aeronave aeronave;

	// construtor
	public Voo(int num, String destino, int qtdPassageiros, String hrPrevista, Aeronave aeronave) {
		setNum(num);
		setDestino(destino);
		setQtdPassageiros(qtdPassageiros);
		setHrPrevista(hrPrevista);
		setAeronave(aeronave);
	}

	// get e set
	public int getNum() {
		return num;
	}

	public void setNum(int num) throws IllegalArgumentException {
		if (num == 0 || num < 0) {
			throw new IllegalArgumentException("Número de cadastro deve ser maior que 0 (zero)");
		}
		this.num = num;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		if (destino == null || destino.isBlank()) {
			throw new IllegalArgumentException("Nome do destino deve ser informado");
		}
		this.destino = destino;
	}

	public int getQtdPassageiros() {
		return qtdPassageiros;
	}

	public void setQtdPassageiros(int qtdPassageiros) throws IllegalArgumentException {
		if (qtdPassageiros > aeronave.getCapMaxPassageiros()) {
			throw new IllegalArgumentException(
					"Quantidade de passageiros não foi aceita. \nInsira um valor entre 0 (zero) e 600 (seiscentos)");
		}
		this.qtdPassageiros = qtdPassageiros;
	}

	public String getHrPrevista() {
		return hrPrevista;
	}

	public void setHrPrevista(String hrPrevista) throws IllegalArgumentException {
		if (hrPrevista == null || hrPrevista.isBlank()) {
			throw new IllegalArgumentException("A hora deve ser informada");
		}
		if (hrPrevista.length() != 5) {
			throw new IllegalArgumentException("A hora prevista deve conter o formato HH:MM ");
		}
		this.hrPrevista = hrPrevista;
	}

	public Aeronave getAeronave() {
		return aeronave;
	}

	public void setAeronave(Aeronave aeronave) throws IllegalArgumentException {
		if (aeronave == null) {
			throw new IllegalArgumentException("Nenhuma aeronave cadastrada");
		}
		this.aeronave = aeronave;
	}

	// métodos
	public String imprimir() {
		return "Número " + getNum() + "\nDestino: " + getDestino() + "\nQuantidade Passageiros: " + getQtdPassageiros()
				+ "\nHora Prevista: " + getHrPrevista() + "\nAeronave: " + getAeronave();
	}
}
