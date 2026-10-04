import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class SistemaVet {

	private List<Animal> animais;
	private Veterinario vetPrincipal; // adm

	public SistemaVet() {

		animais = new ArrayList<Animal>();
		vetPrincipal = new Veterinario("Adm");

		String menu = "\n---- MENU ----" + "\n1- Cadastrar Animal" + "\n2- Pesquisar Animal"
				+ "\n3- Alterar Informações Animal" + "\n4- Excluir Animal" + "\n5- Listar Animais"
				+ "\n6- Listar Animais Maior Peso" + "\n7- Listar Animais de Um Dono"
				+ "\n8- Quantidade Animais por Dono" + "\n9-Pesquidar Contato Dono por Animal"
				+ "\n10-Pesquisar por peso"+ "\n0- Sair";

		int opcao = 0;

		do {
			String op = JOptionPane.showInputDialog(menu);

			try {
				opcao = Integer.parseInt(op);
				switch (opcao) {
				case 1:
					cadastrarAnimal();
					break;
				case 2:
					pesquisarAnimal();
					break;
				case 3:
					alterarInfosAnimal();
					break;
				case 4:
					excluirAnimal();
					break;
				case 5:
					listarAnimais();
					break;
				case 6:
					listarAnimaisMaiorPeso();
					break;
				case 7:
					listarAnimaisDono();
					break;
				case 8:
					qtaAnimaisDono();
					break;
				case 9:
					pesquisarDadosDono();
					break;
				case 10:
					descobrirPeso();
					break;
				case 0:
					JOptionPane.showMessageDialog(null, "Saindo...");
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção inválida!");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Digite um número válido!");
			}
		} while (opcao != 0);

	}

	private void descobrirPeso() {
		// TODO Auto-generated method stub
		
		try {
			float valorLimite = Float.parseFloat(JOptionPane.showInputDialog("Digite o peso que deseja pesquisar"));
			int valorQtd = 0;
			
			valorQtd = vetPrincipal.mediaSuperiorParametro(valorLimite);
			
			
			JOptionPane.showMessageDialog(null, "Animais acima de " + valorLimite + " são: " + valorQtd);
			
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	private void pesquisarDadosDono() {
		// TODO Auto-generated method stub
		try {
			String nomeDono = JOptionPane.showInputDialog("Digite o nome do animal: ");

			if (nomeDono == null) {
				JOptionPane.showMessageDialog(null, "Operação cancelada");
				return;
			}

			if (nomeDono.isBlank()) {
				JOptionPane.showMessageDialog(null, "Nome do dono deve ser informado");
				return;
			}

			String relatorio = vetPrincipal.dadosContatoDono(nomeDono);
			JOptionPane.showMessageDialog(null, relatorio, "Dados de Contato", JOptionPane.INFORMATION_MESSAGE);

		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "AVISO", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void qtaAnimaisDono() {
		// TODO Auto-generated method stub
		try {
			String nomeDono = JOptionPane.showInputDialog("Digite o nome do dono: ");

			if (nomeDono == null) {
				JOptionPane.showMessageDialog(null, "Operação cancelada");
				return;
			}

			if (nomeDono.isBlank()) {
				JOptionPane.showMessageDialog(null, "Nome do dono deve ser informado");
				return;
			}

			int qtdAnimais = vetPrincipal.qtdAnimaisDono(nomeDono);
			JOptionPane.showMessageDialog(null, "Quantidade total de animais: " + qtdAnimais,
					"Quantidade de animais - Responsável: " + nomeDono, JOptionPane.INFORMATION_MESSAGE);

		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "AVISO", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void listarAnimaisDono() {
		// TODO Auto-generated method stub
		try {
			String nomeDono = JOptionPane.showInputDialog("Digite o nome do dono: ");

			if (nomeDono == null) {
				JOptionPane.showMessageDialog(null, "Operação cancelada");
				return;
			}

			if (nomeDono.isBlank()) {
				JOptionPane.showMessageDialog(null, "Nome do dono deve ser informado");
				return;
			}

			String dados = vetPrincipal.listaAnimaisDono(nomeDono);

			JOptionPane.showMessageDialog(null, dados, "Animais do Dono " + nomeDono, JOptionPane.INFORMATION_MESSAGE);

		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "AVISO", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void listarAnimaisMaiorPeso() {
		// TODO Auto-generated method stub
		try {
			String lista = vetPrincipal.animalMaiorMediaPeso();
			JOptionPane.showMessageDialog(null, lista);

		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "AVISO", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void listarAnimais() {
		// TODO Auto-generated method stub
		try {

			if (vetPrincipal == null) {
				JOptionPane.showMessageDialog(null, "Nenhum animal cadastrado! Retornando ao menu...");
				return;
			}
			String lista = vetPrincipal.listarAnimais();
			{
				JOptionPane.showMessageDialog(null, lista);
			}

		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "AVISO", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void cadastrarAnimal() {
		// TODO Auto-generated method stub
		try {
			String nome = JOptionPane.showInputDialog("Digite o nome do animal");
			if (nome == null || nome.isBlank()) return;
			String especie = JOptionPane.showInputDialog("Digite a espécie do animal: ");
			if (especie == null || especie.isBlank()) return;
			String nomeDono = JOptionPane.showInputDialog("Digite o nome do dono: ");
			if (nomeDono == null || nomeDono.isBlank()) return;
			
			
			
			//Procura o dono diretamente na lista da classe Veterinario
			Dono donoEncontrado = vetPrincipal.buscarDono(nome);
	        
	     // Se NÃO encontrou o dono, cadastra um novo
	        if (donoEncontrado == null) {
	            String contato = JOptionPane.showInputDialog("Dono não encontrado. Digite o telefone de contato para cadastrá-lo:");
	            if (contato == null) return;

	            donoEncontrado = new Dono(nomeDono, contato);
	            vetPrincipal.novoDono(donoEncontrado); //// Adiciona na lista interna do Veterinario!
	        }

			String peso1 = JOptionPane.showInputDialog("Digite o primeiro peso: ");
			if (peso1 == null) {
				return;
			}
			Float p1 = Float.parseFloat(peso1);

			String peso2 = JOptionPane.showInputDialog("Digite o segundo peso: ");
			if (peso2 == null) {
				return;
			}
			Float p2 = Float.parseFloat(peso2);

			String peso3 = JOptionPane.showInputDialog("Digite o segundo peso: ");
			if (peso3 == null) {
				return;
			}
			Float p3 = Float.parseFloat(peso3);

			Animal novoAnimal = new Animal(nome, especie, donoEncontrado, p1, p2, p3);
			vetPrincipal.novoAnimal(novoAnimal);
			
			JOptionPane.showMessageDialog(null, "Animal cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Valor de peso inválido! Digite apenas números válidos.",
					"Erro de Digitação", JOptionPane.ERROR_MESSAGE);
		} catch (IllegalArgumentException e) {
			// Captura as validações dos setters/construtores da classe Animal
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro no Cadastro", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void pesquisarAnimal() {
		// TODO Auto-generated method stub

		String nome = JOptionPane.showInputDialog("Digite o nome do animal que deseja pesquisar:");
		if (nome == null) {
			JOptionPane.showInternalMessageDialog(null, "Operação cancelada! Retornando ao menu principal...");
			return;
		}

		Animal animalEncontrado = vetPrincipal.buscarAnimal(nome);


		if (animalEncontrado != null) {
			JOptionPane.showMessageDialog(null, animalEncontrado.imprimir(), "Dados do Animal", JOptionPane.INFORMATION_MESSAGE);
			
			Dono donoDoAnimal = animalEncontrado.getDono();
			JOptionPane.showMessageDialog(null, donoDoAnimal.imprimir(), "Dados do Dono", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Animal não encontrado. Retornando ao menu principal");
			return;
		}

	}

	private void alterarInfosAnimal() {
		// TODO Auto-generated method stub

		String nome = JOptionPane.showInputDialog("Digite o nome do animal para alterar: ");
		if (nome == null) {
			JOptionPane.showMessageDialog(null, "Operação cancelada! Retornando ao menu principal...");
			return;
		}

		Animal animalEncontrado = vetPrincipal.buscarAnimal(nome);

		if (animalEncontrado != null) {
			try {
				String novoNome = JOptionPane.showInputDialog("Digite o novo nome: ", animalEncontrado.getNome());

				boolean novoCadastro = vetPrincipal.alterarInformacoes(nome, novoNome);

				if (novoCadastro == true) {
					JOptionPane.showMessageDialog(null, "Novo nome salvo no sistema!" + animalEncontrado.imprimir());
				} else {
					JOptionPane.showMessageDialog(null, "Não foi possível salvar o novo nome!");
				}
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de validação", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void excluirAnimal() {
		// TODO Auto-generated method stub
		String nome = JOptionPane.showInputDialog("Digite o nome do animal que deseja excluir: ");
		if (nome == null || nome.isBlank()) {
			JOptionPane.showMessageDialog(null, "Operação cancelada! Retornando ao menu principal...");
			return;
		}

		if (animais.isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"Animais devem ser cadastrados primeiro! Retornando ao menu principal...");
			return;
		}

		boolean excluirAnimal = vetPrincipal.excluirAnimal(nome);

		if (excluirAnimal == true) {
			JOptionPane.showMessageDialog(null, "Animal excluído do sistema!");
		} else {
			JOptionPane.showMessageDialog(null, "Animal não encontrado!");
		}

	}

	public static void main(String[] args) {
		new SistemaVet();
	}
}
