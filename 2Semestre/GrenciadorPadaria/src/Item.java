
public class Item {
	private Produto produto;
	private int qtdProduto;
	
	
	//getter
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		if(produto == null) {
			System.out.println("Produto deve ser informado");
		} else
		this.produto = produto;
	}

	public int getQtdProtudo() {
		return qtdProduto;
	}
	
	public void setQtdProduto(int qtdProduto) {
		if(qtdProduto < 0) {
			System.out.println("Valor inválido. Tente novamente");
			return;
		} else {
			//o valor do parametro vai ser atribuido = ao nosso this.atributo
			this.qtdProduto = qtdProduto;
		}
	}
	
	
}
