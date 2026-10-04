import java.util.ArrayList;
import java.util.List;

public class Controle {

	private List<Pedido> pedidos;

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public Controle() {
		pedidos = new ArrayList<Pedido>();
	}

//métodos
	public void cadastrarSorveteNoPedido(int nrId, Sorvete novoSorvete) throws IllegalArgumentException {
		// validar o sorvete primeiro
		if (novoSorvete == null || novoSorvete.getNome() == null || novoSorvete.getNome().isBlank()) {
			throw new IllegalArgumentException("Nome do sorvete deve ser informado corretamente");
		}
		boolean pedidoEncontrado = false;

		// procurar pedidos
		for (Pedido p : pedidos) {
			if (p.getId() == nrId) {
				p.getSorvetes().add(novoSorvete); // Adiciona direto na lista existente
				pedidoEncontrado = true;
				break;
			}
			
		}
		if (!pedidoEncontrado) {
			throw new IllegalArgumentException("Pedido com o número " + nrId + " não foi encontrado.");
		}

	}

	public boolean removerSorvetePeloNome(int nrId, String nome) throws IllegalArgumentException {
		// remove sorvete do pedido ap buscar nome
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("Nome deve ser preenchido corretamente");
		}

		for (Pedido p : pedidos) {
			if (p.getId() == nrId) {
				if (p.getSorvetes() != null) {
					return p.getSorvetes().removeIf(s -> s.getNome().equalsIgnoreCase(nome.trim()));
					// removeif percorre listas e retorna true
					// lambda (parametros recebidos -> deve ser executado ou retornado
					// forma normal sem lambda
					// for (int i = 0; i < sorvetes.size(); i++)
					// { Sorvete s = sorvetes.get(i);
					// if (s.getNome().equalsIgnoreCase(nome))
					// {sorvetes.remove(i); } }

				}
			}
		}
		throw new IllegalArgumentException("Não exite sorvete com este nome"); // return false
	}

	public int informarQtdSorveteNoPedido(int nrId) throws IllegalArgumentException {
		int resultado = 0;

		if (nrId == 0) {
			throw new IllegalArgumentException("Número do pedido deve ser preenchido corretamente");
		}

		for (Pedido p : pedidos) {
			// confere se numero do pedido existe
			if (p.getId() == nrId) {
				// condere se sorvetes não é nulo
				if (p.getSorvetes() != null) {
					// retorna a quantidade dentro da lista
					return resultado = p.getSorvetes().size();
				}
			}
		}

		throw new IllegalArgumentException("Sem sorvetes cadastrados: " + resultado);
	}

	public String resultadoCaracterNomeSorvete(int nrId) throws IllegalArgumentException {
		String maiorCaracter = " ";
		boolean pedidoEncontrado = false;

		for (Pedido p : pedidos) {
			if (p.getId() == nrId) {
				pedidoEncontrado = true;
				if (p.getSorvetes() != null) {
					for (int i = 0; i < p.getSorvetes().size(); i++) {
						String nomeAtual = p.getSorvetes().get(i).getNome();
						if (nomeAtual.length() > maiorCaracter.length()) {
							maiorCaracter = nomeAtual;
						}
					}
				}
				break; // quando encontrar o numero do pedido
			}
		}
		if (!pedidoEncontrado) {
			throw new IllegalArgumentException("Número do pedido não existe");
		}
		if (maiorCaracter.isEmpty()) {
			throw new IllegalArgumentException("O pedido: " + nrId + "não possui sorvete cadastrado");
		}
		return "Sorvete com o maior número de caracteres é: " + maiorCaracter;
	}

	public String qtdSorvetePorSaborNoPedido(int nrId) throws IllegalArgumentException {
		boolean pedidoEncontrado = false;
		String dados = "";

		for (Pedido p : pedidos) {
			if (p.getId() == nrId) {
				pedidoEncontrado = true;

				if (p.getSorvetes() != null && !p.getSorvetes().isEmpty()) {
					// armazenar os sabores encontrados
					List<String> saboresJaContados = new ArrayList<>();

					// pega cada sorvete primeiro lopp
					for (Sorvete s1 : p.getSorvetes()) {
						String saborAtual = s1.getNome();

						if (saborAtual != null && !saborAtual.isBlank()) {
							boolean jaFoiContado = false;

							// primeiro verifica se o sabor foi encontrado
							for (String saborContado : saboresJaContados) {
								if (saborContado.equalsIgnoreCase(saborAtual)) {
									jaFoiContado = true;
									break;
								}
							}

							// se ainda não foi contado, faz contagem
							if (!jaFoiContado) {
								int contador = 0;

								for (Sorvete s2 : p.getSorvetes()) {
									if (s2.getNome() != null && s2.getNome().equalsIgnoreCase(saborAtual)) {
										contador++;
									}
								}

								saboresJaContados.add(saborAtual);
								dados += "-----Relatório Quantidade de Sabores Por Pedido -----";
								return dados += "\n\nSabor " + saborAtual + " - Quantidade: " + contador + "\n";
							}
						}
					}
				} else {
					return "O pedido " + nrId + " não possui sorvetes cadastrados.";
				}
			}
		}

		if (!pedidoEncontrado) {
			throw new IllegalArgumentException("Pedido com ID " + nrId + " não foi encontrado.");
		}
		return dados;

	}

	public void cadastrarNovoPedido(Pedido pedido) throws IllegalArgumentException {
		if (pedidos == null) {
			throw new IllegalArgumentException("Pedido deve ser completado para finalizar o cadastro!");
		} else {
			pedidos.add(pedido);
		}
	}

	public int totalPedidos() {
		// não precisaria da excesão pois retorno 0
		if (pedidos == null) {
			return 0;
		}

		return pedidos.size();
	}

	public Pedido localizarPedido(int nrId) {
		if (nrId != 0) {
			for (Pedido p : pedidos) {
				if (p.getId() == nrId) {
					return p;
				}
			}
		}
		return null;
	}

	public String qtdPedidosPorCliente(String nome) {
		// confirmar o nome
		// acessar pedidos
		// buscar nome lopp e ir adicionando a lista

		if (nome != null && !nome.isBlank()) {
			int qtdPedidos = 0;

			if (pedidos != null) {

				for (Pedido p : pedidos) {
					if (p.getNomeCliente().equalsIgnoreCase(nome)) {
						qtdPedidos++;
					}
				}
				return "Cliente: " + nome + "tem " + qtdPedidos + " pedido(s)";
			}

		}

		return "Não existe cliente com nome: " + nome + "cadastrado";
	}

	public String pedidoMaiorQtdSorvetes() throws IllegalArgumentException {
		if (pedidos.isEmpty()) {
			throw new IllegalArgumentException("Pedidos não foram cadastrados ainda");
		}

		String dados = " ";
		// assumir que primeiro pedido é o maior
		Pedido qtdMaiorSorvetes = pedidos.get(0);
		// variável para guardar a maior quantidade de sorvetes encontrada até o momento
		int maiorQtd = 0;
		//se a lista de sorvetes desse primeiro pedido não é nula
		if (qtdMaiorSorvetes.getSorvetes() != null) {
			//existe então, pega a quantidade de sorvetes do primeiro pedido e guarda em "maiorQtd"
			maiorQtd = qtdMaiorSorvetes.getSorvetes().size();
		}
		//percorrer cada "Pedido p" existente dentro da lista "pedidos"
		for (Pedido p : pedidos) {
			//confirma se a lista de sorvetes dele não é nula antes
			if (p.getSorvetes() != null) {
				// Pega a quantidade de sorvetes do pedido atual
				int qtdAtual = p.getSorvetes().size();
				//A quantidade do pedido atual é MAIOR que a maior quantidade registrada?
				if (qtdAtual > maiorQtd) {
					//Se for maior, atualiza a variável "maiorQtd" com este novo valor
					maiorQtd = qtdAtual;
					// Substitui a referência em "qtdMaiorSorvetes" pelo pedido "p" atual
					qtdMaiorSorvetes = p;
				}
			}

		}
		
		dados = "Pedido com maior quantidade de sorvetes: " +
                "ID " + qtdMaiorSorvetes.getId() + 
                " | Cliente: " + qtdMaiorSorvetes.getNomeCliente() + 
                " | Total de Sorvetes: " + maiorQtd;

		return dados;

	}

	public int contagemSorvetes(int nrId) throws IllegalArgumentException {
		int contador = 0;

		for (Pedido p : pedidos) {
			if (p.getId() == nrId) {
				if (p.getSorvetes() != null) {
					return p.getSorvetes().size();
				}
				return 0;
			}
		}
		throw new IllegalArgumentException("Pedido nr: " + nrId + " não encontrado!");
	}
}
