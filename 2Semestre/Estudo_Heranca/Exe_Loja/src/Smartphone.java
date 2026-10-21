
public class Smartphone extends Produto {

	private int armazenamento;
	private boolean banda5G;

	public Smartphone(double preco, int mesGarantia, int armazenamento, boolean banda5G) {
		super("Smartphone", preco, mesGarantia);
		// pode usar o nome fixo para validar no construtor, mas poderia utlizar um
		// atributo também
		setArmazenamento(armazenamento);
		setBanda5G(banda5G);
	}

	public int getArmazenamento() {
		if (armazenamento < 0) {
			throw new ValorMenosQueZeroException("Armazenamento");
		}
		return armazenamento;
	}

	public void setArmazenamento(int armazenamento) {
		this.armazenamento = armazenamento;
	}

	// boolean é sempre is
	public boolean isBanda5G() {
		return banda5G;
	}

	// nao precisa validar no set se um booleano
	public void setBanda5G(boolean banda5g) {
		banda5G = banda5g;
	}

	public double desconto() {
		if (banda5G) {
			return getPreco() * 0.05;
		}
		return 0;
	}

	// preco com desconto
	public double precoComDesconto() {
		if (banda5G) {
			return getPreco() * 0.95; // diminui o desconto de 100% para chegar no valor
		}
		return getPreco();
	}

	@Override
	public int getMesesGarantia() {
		if (this.armazenamento >= 256) {
			return super.getMesesGarantia() + 3;
		}
		return super.getMesesGarantia();
	}
}
