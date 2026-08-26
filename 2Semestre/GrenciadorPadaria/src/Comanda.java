import java.util.ArrayList;
import java.util.List;

public class Comanda {
	private int nrComanda;
	//private Item[] itens;
	private List<Item> itens;
	private int qtdAtualProduto;
	
	//sempre que eu trabalho com vetor ele deve ser instanciado dentro da classe
	public Comanda() {
		nrComanda = 0;
		//itens = new Item[20];
		itens = new ArrayList<Item>();
		qtdAtualProduto = 0;
	}
	
	
	
	public int getNrComanda() {
		return nrComanda;
	}
	
	public void setNrComanda(int nrComanda) {
		if(nrComanda < 0) {
			System.out.println("O número da comanda deve ser maior que zero");
		} else
		this.nrComanda = nrComanda;
	}
	
	public List<Item> getItem() {
		return itens;
	}
	
	public void setItem(List<Item> itens) {
		if(itens == null) {
			System.out.println("Item deve ser informado");
		} else
		this.itens = itens;
	}
	
	
	//metodos
	public void addItem(Item item) {
		// que item eu vou incluir? então eu preciso passar o parametro
		if (itens == null) {
			System.out.println();
		} else {
			//itens[qtdAtualProduto] = item;
			//qtdAtualProduto++;
			
			//adicionando no arraylist
			itens.add(item);
		}
	}
	
	// antigo
	
	/*public void imprimirComanda( ) {
		
		System.out.println(nrComanda);
		for(int i = 0; i < qtdAtualProduto; i++) {
			System.out.println(itens[i].getProduto().getNome() + " R$ " + 
					itens[i].getProduto().getValorUnitario() + " - " + 
					itens[i].getQtdProtudo());
			
			if(itens[qtdAtualProduto].getQtdProtudo() == 1) {
				System.out.println(" Item");
			} else {
				System.out.println(" Itens");
			}
		}*/
	
	
	
	/*
	 * 	public String imprimirComanda() {
		String dados = " ";
		
		dados += nrComanda;
		
		for(int i = 0; i < qtdAtualProduto; i++) {
			
			dados += "\n " + itens[i].getProduto().getNome() + " R$ " + 
					 + itens[i].getProduto().getValorUnitario() + " - " + 
					 + itens[i].getQtdProtudo();
		
			if(itens[i].getQtdProtudo() == 1) {
				dados +=" Item";
			} else {
				dados += " Itens";
				
			}
			
			
		}
		
		return dados;
		
	}
	 */
	
	
	public String imprimirComanda() {
		String dados = " ";
		
		dados += nrComanda;
		
		for(int i = 0; i < itens.size(); i++) {
			
			dados += "\n " + itens.get(i).getProduto().getNome() + " R$ " + 
					 + itens.get(i).getProduto().getValorUnitario() + " - " + 
					 + itens.get(i).getQtdProtudo();
		
			if(itens.get(i).getQtdProtudo() == 1) {
				dados +=" Item";
			} else {
				dados += " Itens";
				
			}
			
			
		}
		
		return dados;
		
	}
	
}
