
public class Produto {
	
	private String nomeProduto;
	private float valorUnitario;
	
	//quando o atributo é necessario para o construtor existir
	//passa a ser obrigatório para o objeto existir
	//usa os set pois eles já validam os parâmetros
	public Produto(String nome, float valor){
		setNome(nome);
		setValorUnitario(valor);
	}
	
	
	//getter
	
	public String getNome() {
		return nomeProduto;
	}
	
	public float getValorUnitario() {
		return valorUnitario;
	}
	
	//setter
	
	public void setNome(String nomeProduto) {
		//isEmpty() -> " " 
		//isBlank() -> "   " | "\n " | "\t"
		if(nomeProduto == null || nomeProduto.isBlank()) {
			System.out.println("Nome inválido. Tente novamente");
			return;
		} else if (nomeProduto.length() <=2){
			System.out.println("Nome deve ter mais que duas letras");
		}else
		this.nomeProduto = nomeProduto;
	}
	
	public void setValorUnitario(float valorUnitario) {
		if(valorUnitario < 0.00 || valorUnitario > 1000) {
			System.out.println("Valor inválido!");
		} else
		this.valorUnitario = valorUnitario;
	}

}
