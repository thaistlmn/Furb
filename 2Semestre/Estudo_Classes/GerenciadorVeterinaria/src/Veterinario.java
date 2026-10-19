import java.util.ArrayList;
import java.util.List;

public class Veterinario {

	private String nome;
	private List<Animal> animais;
	private List<Dono> donos;

	public Veterinario(String nome) throws IllegalArgumentException {
		setNome(nome);
		animais = new ArrayList<Animal>();
		donos = new ArrayList<Dono>();
	}

	public String getNome() {
		return nome;
	}

	public List<Animal> getAnimais() {
		return animais;
	}

	public void setNome(String nome) throws IllegalArgumentException {
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("Nome do veterinario deve ser informado!");
		}
		this.nome = nome;
	}

	public void setAnimais(List<Animal> animais) throws IllegalArgumentException {
		if (animais == null) {
			throw new IllegalArgumentException("Não há animais cadastrados!");
		}
		this.animais = animais;
	}

	// métodos
	// cadastro novo animal
	public void novoAnimal(Animal animais) throws IllegalArgumentException {
		if (animais == null) {
			throw new IllegalArgumentException("Animal deve ser informado!");
		} else {
			this.animais.add(animais);
		}
	}

	// buscar animal
	public Animal buscarAnimal(String nome) {
		// recebe o nome
		if (nome != null) {
			for (Animal a : animais) {
				if (a.getNome().equalsIgnoreCase(nome)) {
					return a;
				}
			}
		}
		return null;
		// compara
	}

	public Dono buscarDono(String nome) {
		if (nome != null) {
			for (Dono d : donos) {
				if (d.getNome().equalsIgnoreCase(nome)) {
					return d;
				}
			}
		}
		return null;
	}
	
	public void novoDono(Dono dono) throws IllegalArgumentException {
	    if (dono == null) {
	        throw new IllegalArgumentException("Dono deve ser informado!");
	    }
	    this.donos.add(dono);
	}
	

	// alterar informacoes
	public boolean alterarInformacoes(String nomeAtual, String novoNome) {
		// buscar animal
		Animal animalAtual = buscarAnimal(nomeAtual);
		if (animalAtual != null) {
			if (novoNome != null) {
				animalAtual.setNome(novoNome);
			}
			return true;
		}
		return false;
	}

	// excluir
	public boolean excluirAnimal(String nome) {
		Animal animal = buscarAnimal(nome);

		if (nome != null) {
			animais.remove(animal);
			return true;
		}
		return false;
	}

	public String listarAnimais() {
		String dados = " ";

		if (animais.isEmpty()) {
			return "Animais não foram cadastrados! Cadastre primeiro para imprimir!";
		}

		dados += "-----------Lista animais cadastrados-----------";

		for (Animal a : animais) {
			dados += a.imprimir();
			dados += "-----------------------------------------------";
		}
		return dados;
	}

	public String animalMaiorMediaPeso() {

		if (animais.isEmpty()) {
			return "Animais não foram cadastrados! Cadastre primeiro para imprimir!";
		}

		String dados = "";

		// Assumir que o primeiro animaç ´é o maior:
		Animal animalMaior = animais.get(0);
		float maiorMedia = animalMaior.mediaPesos();

		for (Animal a : animais) {
			float mediaAtual = a.mediaPesos();
			if (mediaAtual > maiorMedia) { // se o animal que eu estou comparando é maior que o primeiro
				maiorMedia = mediaAtual; // vou guardar dentro do maior media o valor maior
				animalMaior = a; // Guarda a referência para o novo animalMaior.maiorMedia
			}
		}
		dados += "Animal com maior média de peso: " + animalMaior.imprimir();
		return dados;

	}

	public int mediaSuperiorParametro(float valorLimite) {
		int contador = 0;

		for (Animal a : animais) {
			float mediaAnimal = a.mediaPesos();

			if (mediaAnimal > valorLimite) {
				contador++;
			}
		}

		return contador;
	}

	public String listaAnimaisDono(String nomeDono) {

		Dono donoEncontrado = buscarDono(nomeDono);

		if (donoEncontrado == null) {
			return "Nome não existe no sistema!";
		}

		String dados = " ";

		dados += "-------- Lista animais do dono: " + donoEncontrado.getNome() + "--------";
		for (Animal a : animais) {
			if (a.getDono().equals(donoEncontrado) || a.getDono().getNome().equalsIgnoreCase(nomeDono)) {
				dados += a.imprimir();
				dados += "\n-----------------------------------------------";
			}

		}
		return dados;

	}

	public int qtdAnimaisDono(String nomeDono) {
		// encontrar dono no sistema
		Dono donoEncontrado = buscarDono(nomeDono);

		if (donoEncontrado == null) {
			return 0;
		}

		int contadorAnimais = 0;

		// percorer a lista de animais
		for (Animal a : animais) {
			// validar com if
			if (a.getDono().equals(donoEncontrado) || a.getDono().getNome().equalsIgnoreCase(nomeDono)) {
				contadorAnimais++;
			}
		}
		return contadorAnimais;
	}

	public String dadosContatoDono(String nome) {
		String dados = " ";

		Animal animalEncontrado = buscarAnimal(nome);

		if (animalEncontrado == null) {
			return "Animal não cadastrado";
		} else {
			dados += "\nNome animal: " + animalEncontrado.getNome() + "\n\nNome dono: "
					+ animalEncontrado.getDono().getNome() + "\nContato: " + animalEncontrado.getDono().getContato();
		}

		return dados;

	}

	//

}
