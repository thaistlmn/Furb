
public abstract class Produto {
	
	private String nome;
	private double preco;
	private int mesesGarantia;
	
	public Produto(String nome, double preco, int mesesGarantia) {
		setNome(nome);
		setPreco(preco);
		setMesesGarantia(mesesGarantia);
	}
	
	//se os parametros não forem passados, funciona na compilação mas nao funciona na verificao
	//pois ele vai passar branco e depois vai ficar em branco e dar erro

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws IllegalArgumentException{
		if(nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("Nome deve ser preenchido");
		}
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		if(preco < 0) {
			throw new ValorMenosQueZeroException("Preço");
		}
		this.preco = preco;
	}

	public int getMesesGarantia() {
		return mesesGarantia;
	}

	public void setMesesGarantia(int mesesGarantia) {
		if(mesesGarantia < 0) {
			throw new ValorMenosQueZeroException("Quantidade de meses para garantia");
		}
		this.mesesGarantia = mesesGarantia;
	}
	
	public abstract double desconto();
	//é uma definicao que todas as classes filhas precisam implementar o método desconto!
	//acordar o tipo void : void, double : double

}
