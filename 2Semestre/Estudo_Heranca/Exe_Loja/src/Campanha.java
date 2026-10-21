import java.util.ArrayList;
import java.util.List;

public class Campanha {

	private List<Produto> produtos;

	public Campanha() {
		produtos = new ArrayList<Produto>();
	}

	public void addProduto(Produto produto) {
		if (produto == null) {
			throw new IllegalArgumentException("Produtos devem ser preenchido");
		}
		produtos.add(produto);
	}
	
	public String imprimir() {
		String texto = "";
		for(Produto p: produtos) {
			texto += p.getNome() + "\nR$";
			if(p instanceof Smartphone) {
				Smartphone produtoSmartphone = (Smartphone) p; //forçar um cast do smartphone só com validação antes
				texto += produtoSmartphone.precoComDesconto();
			} else if(p instanceof Notebook) {
				Notebook prodNotebook = (Notebook) p;
				texto += prodNotebook.getPreco() - prodNotebook.desconto();
			}
			
			texto += " - Garantia: " + p.getMesesGarantia() + "\n";
		}
		
		return texto;
	}
	
	public double precoTotal() {
		
		double total = 0;
		for(Produto p : produtos) {
			if(p instanceof Notebook) {
				Notebook n = (Notebook) p;
				total += n.getPreco() - n.desconto();
			} else {
				Smartphone s = (Smartphone) p;
				total += s.precoComDesconto();
			}
		}
		
		return total;
		
	}
	
	public static void main(String[] args) {
		
		
		List<Produto> produtos = new ArrayList<Produto>();
	}
	
}
