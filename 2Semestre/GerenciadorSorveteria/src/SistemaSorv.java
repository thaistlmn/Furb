import javax.swing.JOptionPane;

public class SistemaSorv {

	private Controle controle; // quem gerencia

	public SistemaSorv() {
		controle = new Controle();

		String menu = "---------- MENU ----------" 
				+ "\n1- Cadastrar Sorvete No Pedido"
				+ "\n2- Remover Sorvete Pelo Nome" 
				+ "\n3- Informar Qtd Sorvete No Pedido"
				+ "\n4- Resultado Caracter Nome Sorvete" 
				+ "\n5- Qtd Sorvete Por Sabor No Pedido"
				+ "\n\n6- Cadastrar Novo Pedido" 
				+ "\n7- Total Pedidos" 
				+ "\n8- Localizar Pedido"
				+ "\n9- Qtd Pedidos Por Cliente" 
				+ "\n10- Pedido Maior Qtd Sorvetes"
				+ "\n0- Sair";

		int op = -1;

		do {
			String opcao = JOptionPane.showInputDialog(menu);

			if (opcao == null) {
				break;
			}

			try {
				op = Integer.parseInt(opcao);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Opção inválida! Digite um número.", "AVISO", JOptionPane.ERROR_MESSAGE);
				continue;
			}

			switch (op) {
			case 1:
				cadastrarSorveteNoPedido();
				break;
			case 2:
				removerSorvetePeloNome();
				break;
			case 3:
				informarQtdSorveteNoPedido();
				break;
			case 4:
				resultadoCaracterNomeSorvete();
				break;
			case 5:
				qtdSorvetePorSaborNoPedido();
				break;
			case 6:
				cadastrarNovoPedido();
				break;
			case 7:
				totalPedidos();
				break;
			case 8:
				localizarPedidoId();
				break;
			case 9:
				qtdPedidosPorClientes();
				break;
			case 10:
				pedidoMaiorQtdSorvetes();
				break;
			case 0:
				JOptionPane.showMessageDialog(null, "Saindo...");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!");
			}

		} while (op != 0);
	}

	private void cadastrarSorveteNoPedido() {
		try {
			int idPedido = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do pedido:"));
			String nomeSorvete = JOptionPane.showInputDialog("Informe o nome do sorvete:");
			String saborSorvete = JOptionPane.showInputDialog("Informe o sabor do sorvete:");
			float precoSorvete = Float.parseFloat(JOptionPane.showInputDialog("Informe o preço do sorvete:"));

			Sorvete sorvete = new Sorvete(nomeSorvete, saborSorvete, precoSorvete);
			controle.cadastrarSorveteNoPedido(idPedido, sorvete);
			JOptionPane.showMessageDialog(null, "Sorvete adicionado com sucesso ao pedido!");
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "AVISO", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void removerSorvetePeloNome() {
		try {
			int idPedido = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do pedido:"));
			String nomeSorvete = JOptionPane.showInputDialog("Informe o nome do sorvete a remover:");

			boolean removido = controle.removerSorvetePeloNome(idPedido, nomeSorvete);
			if (removido) {
				JOptionPane.showMessageDialog(null, "Sorvete removido com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Sorvete não encontrado no pedido informado.");
			}
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "AVISO", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void informarQtdSorveteNoPedido() {
		try {
			int idPedido = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do pedido:"));
			int qtd = controle.informarQtdSorveteNoPedido(idPedido);
			JOptionPane.showMessageDialog(null, "O pedido " + idPedido + " possui " + qtd + " sorvete(s).");
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "AVISO", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void resultadoCaracterNomeSorvete() {
		try {
			int idPedido = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do pedido:"));
			String resultado = controle.resultadoCaracterNomeSorvete(idPedido);
			JOptionPane.showMessageDialog(null, resultado);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "AVISO", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void qtdSorvetePorSaborNoPedido() {
		try {
			int idPedido = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do pedido:"));
			String resultado = controle.qtdSorvetePorSaborNoPedido(idPedido);
			JOptionPane.showMessageDialog(null, resultado);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "AVISO", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void cadastrarNovoPedido() {
		try {
			int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do novo pedido:"));
			String nomeCliente = JOptionPane.showInputDialog("Informe o nome do cliente:");

			Pedido novoPedido = new Pedido(id, nomeCliente);
			controle.cadastrarNovoPedido(novoPedido);
			JOptionPane.showMessageDialog(null, "Pedido cadastrado com sucesso!");
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "AVISO", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void totalPedidos() {
		try {
			int total = controle.totalPedidos();
			JOptionPane.showMessageDialog(null, "Total de pedidos cadastrados: " + total);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "AVISO", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void localizarPedidoId() {
		try {
			int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do pedido que deseja buscar:"));
			Pedido p = controle.localizarPedido(id);

			if (p != null) {
				JOptionPane.showMessageDialog(null, "Pedido Encontrado:\nID: " + p.getId() + "\nCliente: " + p.getNomeCliente());
			} else {
				JOptionPane.showMessageDialog(null, "Pedido com ID " + id + " não foi localizado.");
			}
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "AVISO", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void qtdPedidosPorClientes() {
		try {
			String nomeCliente = JOptionPane.showInputDialog("Informe o nome do cliente:");
			String resultado = controle.qtdPedidosPorCliente(nomeCliente);
			JOptionPane.showMessageDialog(null, resultado);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "AVISO", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void pedidoMaiorQtdSorvetes() {
		try {
			String resultado = controle.pedidoMaiorQtdSorvetes();
			JOptionPane.showMessageDialog(null, resultado);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "AVISO", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] args) {
		new SistemaSorv();
	}
}