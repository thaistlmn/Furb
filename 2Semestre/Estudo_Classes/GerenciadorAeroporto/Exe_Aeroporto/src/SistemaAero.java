import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class SistemaAero {

	// criar lista e aeroporto responsavel
	private List<Voo> voos;
	private List<Aeronave> aeronaves;
	private Aeroporto aeroPrincipal;

	public SistemaAero() {

		// instanciar
		voos = new ArrayList<Voo>();
		aeronaves = new ArrayList<Aeronave>();
		aeroPrincipal = new Aeroporto(230, "Aeroporto Leste", "Cidade A");
		aeroPrincipal.adicionarAeronave(new Aeronave(001, "Airbus", 285));
		aeroPrincipal.adicionarAeronave(new Aeronave(002, "Airbus", 285));
		aeroPrincipal.adicionarAeronave(new Aeronave(003, "Airbus", 285));
		aeroPrincipal.adicionarAeronave(new Aeronave(004, "Airbus", 330));
		aeroPrincipal.adicionarAeronave(new Aeronave(005, "Airbus", 330));
		aeroPrincipal.adicionarAeronave(new Aeronave(006, "Airbus", 330));

		// menu
		String menu = "---------- MENU ----------" + "\n1-Adicionar Voo" + "\n2-Buscar Voo" + "\n3-Remover Voo"
				+ "\n4-Listar Voo" + "\n5-Adicionar Aeronave" + "\n0-Sair";

		int op = 0;

		try {
			String opcao = JOptionPane.showInputDialog(menu);


			do {
				op = Integer.parseInt(opcao);

				switch (op) {
				case 1:
					adicionarVoo();
					break;
				case 2:
					buscarVoo();
					break;
				case 3:
					removerVoo();
					break;
				case 4:
					listarVoo();
					break;
				case 5:
					adicionarAeronave();
					break;
				case 0:
					JOptionPane.showMessageDialog(null, "Saindo...");
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção inválida!");
				}

			} while (op != 0);

		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "AVISO", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void adicionarAeronave() {
		// TODO Auto-generated method stub
		
		try {
			//int codigo, String modelo, int capMaxPassageiros
			int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da aeronave: "));
			
			String modelo = JOptionPane.showInputDialog("Digite o nome do modelo da aeronave: ");
			
			int qtdMaxPassageiros = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade máxima de passageiros da aeronave: "));
			
			Aeronave novoAeronave = new Aeronave(codigo, modelo, qtdMaxPassageiros);
			
			aeroPrincipal.adicionarAeronave(novoAeronave);
			
			JOptionPane.showMessageDialog(null, "Aeronave adicionado com sucesso!");
			
		} catch(IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "AVISO", JOptionPane.ERROR_MESSAGE);
		}
		

	}

	private void listarVoo() {
		// TODO Auto-generated method stub
		try {

			if (aeroPrincipal == null) {
				JOptionPane.showMessageDialog(null, "Nenhum voo cadastrado");
				return;
			}

			String lista = aeroPrincipal.listarVoos();
			JOptionPane.showMessageDialog(null, lista);

		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "AVISO", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void removerVoo() {
		// TODO Auto-generated method stub
		try {
			int numVoo = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do voo que deseja excluir: "));

			if (voos.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Voos não foram acadastrados ainda");
				return;
			}

			boolean excluirVoo = aeroPrincipal.removerVoo(numVoo);

			if (excluirVoo == true) {
				JOptionPane.showMessageDialog(null, "Voo excluído do sistema!");
			} else {
				JOptionPane.showMessageDialog(null, "Voo não encontrado no sistema!");

			}

		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "AVISO", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void buscarVoo() {
		// TODO Auto-generated method stub
		try {
			int numVoo = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do voo para busca: "));

			if (numVoo == 0) {
				throw new IllegalArgumentException("Número do vo deve ser informado!");
			}

			Voo vooEncontrado = aeroPrincipal.buscarVoos(numVoo);

			if (vooEncontrado != null) {
				JOptionPane.showMessageDialog(null, vooEncontrado.imprimir(), "INFORMAÇÕES DO VOO ",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "AVISO", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void adicionarVoo() {
		// TODO Auto-generated method stub
		try {
			// int num, String modelo, int qtdPassageiros, String hrPrevista, Aeronave
			// aeronave
			int num = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do voo: "));

			String destino = JOptionPane.showInputDialog("Digite o nome do destino: ");

			int qtdPassageiros = Integer
					.parseInt(JOptionPane.showInputDialog("Digite a quantidade de paseiros no voo: "));

			String hrPrevista = JOptionPane.showInputDialog("Digite a hora prevista: ");

			int codigoAeronave = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da aeronave: "));
			
			aeroPrincipal.buscarAeronave(codigoAeronave);
			// o aeroporto vai associar a aeronave
			Voo novoVoo = new Voo(num, destino, qtdPassageiros, hrPrevista, null);

			// chama o método aeroporto e passa os atributos voo e codigo
			aeroPrincipal.adicionarVoo(novoVoo, codigoAeronave);

			JOptionPane.showMessageDialog(null, "Voo adicionado com sucesso!");

		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "AVISO", JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void main(String[] args) {
		new SistemaAero();
	}
}
