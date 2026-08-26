import javax.swing.JOptionPane;

public class Gerenciador {
	
	
	public Gerenciador() {
		Produto p1 = new Produto();
		/*p1.setNome("Pãozinho");
		p1.setValorUnitario(2);*/
		
		String nome = JOptionPane.showInputDialog("Digite o nome do produto");
		
		/*
		 * String valorUnitario = JOptionPane.showInputDialog("Digite o preco do produto");
		 * float valorFloat = Float.parseFloat(ValorUnitario)
		 */
		float valorUnitario = Float.parseFloat(JOptionPane.showInputDialog("Digite o preco do produto"));
		
		p1.setNome(nome);
		p1.setValorUnitario(valorUnitario);
		
		
		Produto p2 = new Produto();
		p2.setNome("Leite");
		p2.setValorUnitario(4);
		
		Item item1 = new Item();
		item1.setProduto(p1);
		item1.setQtdProduto(1);
		
		Item item2 = new Item();
		item2.setProduto(p2);
		item2.setQtdProduto(1);
		
		Comanda c1 = new Comanda();
		c1.setNrComanda(1);
		c1.addItem(item1);
		c1.addItem(item2);
		
		Item item3 = new Item();
		item3.setProduto(p1);
		item3.setQtdProduto(10);
		
		Comanda c2 = new Comanda();
		c2.setNrComanda(2);
		c2.addItem(item3);
		
		//System.out.println(c1.imprimirComanda());
		JOptionPane.showMessageDialog(null, c1.imprimirComanda() );
		//System.out.println(c2.imprimirComanda());
		JOptionPane.showMessageDialog(null, c2.imprimirComanda() );
	}
	
	
	public void inserirComanda() {}
	
	public void calculoValorTotal() {}

	
	
	public static void main(String[] args) {
		
		new Gerenciador();
		
	}

}
