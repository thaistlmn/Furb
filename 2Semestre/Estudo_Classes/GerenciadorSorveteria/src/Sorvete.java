public class Sorvete {

	private String nome;
	private String sabor;
	private float preco;

	public Sorvete(String nome, String sabor, float preco) {
		setNome(sabor);
		setSabor(sabor);
		setPreco(preco);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws IllegalArgumentException {
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("Nome do sorvete precisa ser informado");
		}
		this.nome = nome;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) throws IllegalArgumentException {
		if (sabor == null || sabor.isBlank()) {
			throw new IllegalArgumentException("Sabor do sorvete precisa ser informado");
		}
		this.sabor = sabor;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) throws IllegalArgumentException {
		if (preco < 0) {
			throw new IllegalArgumentException("Valor do sorvete precisa ser informado");
		}
		this.preco = preco;
	}

}