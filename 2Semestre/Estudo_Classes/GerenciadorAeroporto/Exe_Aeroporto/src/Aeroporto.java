import java.util.ArrayList;
import java.util.List;

public class Aeroporto {
	// atributos
	private int codigo;
	private String nome;
	private String cidade;
	private List<Voo> voos;
	private List<Aeronave> aeronaves;

	// construtor
	public Aeroporto(int codigo, String nome, String cidade) {
		// colocar parametro e set
		// listas assim não colocar no parametro
		setCodigo(codigo);
		setNome(nome);
		setCidade(cidade);
		voos = new ArrayList<Voo>();
		aeronaves = new ArrayList<Aeronave>();
	}

	// set e get
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) throws IllegalArgumentException {
		if (codigo == 0 || codigo < 0) {
			throw new IllegalArgumentException("Código inválido\nCódigo deve ser maior que 0 (zero)");
		}
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws IllegalArgumentException {
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("Nome do aeroporto deve ser informado");
		}
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) throws IllegalArgumentException {
		if (cidade == null || cidade.isBlank()) {
			throw new IllegalArgumentException("Nome da cidade deve ser informado");
		}
		this.cidade = cidade;
	}

	public List<Voo> getVoos() {
		return voos;
	}

	public void setVoos(List<Voo> voos) throws IllegalArgumentException {
		if (voos == null || voos.isEmpty()) {
			throw new IllegalArgumentException("Não existem voos cadastrados\n Cadastre um voo primeiro");
		}
		this.voos = voos;
	}

	public List<Aeronave> getAeronaves() {
		return aeronaves;
	}

	public void setAeronaves(List<Aeronave> aeronaves) {
		this.aeronaves = aeronaves;

	}
	// metodos

	// passar o objeto para adicionar
	public void adicionarVoo(Voo voo, int codigoAeronave) throws IllegalArgumentException {
		if (voo == null) {
			throw new IllegalArgumentException("Voo deve ser informado");
		} else {

			// Valida se o número já existe na lista
			conferirCodigoVoo(voo.getNum());

			Aeronave aeronaveEncontrada = buscarAeronave(codigoAeronave);
			if (aeronaveEncontrada == null) {
				throw new IllegalArgumentException("Aeronave não consta nonsistema");
			}
			voo.setAeronave(aeronaveEncontrada);
			// Voo voos = conferirCodigo();
			voos.add(voo);
		}
	}
	

	// método objeto, retorna objeto
	public Voo buscarVoos(int numVoo) {
		if (numVoo != 0) {
			for (Voo v : voos) {
				// conferencia
				if (v.getNum() == numVoo) {
					return v;
				}
			}
		}
		return null;
	}

	public Aeronave buscarAeronave(int codigo) {
		if (codigo != 0) {
			for (Aeronave a : aeronaves) {
				if (a.getCodigo() == codigo) {
					return a;
				}
			}
		}
		return null;

	}

	public boolean removerVoo(int numVoo) throws IllegalArgumentException {
		if (voos == null) {
			throw new IllegalArgumentException("Não existem voos cadastrados");
		}
		// busca o valor dentro da lista de voo
		Voo voo = buscarVoos(numVoo);

		if (voo != null) {// se voo não for nulo
			voos.remove(voo); // remove o voo da lista voos
			return true;
		}
		return false;
	}

	public String listarVoos() {
		String lista = " ";

		if (voos.isEmpty()) {
			return "Voos não foram cadastrados até o momento!\nCadastre primeiro para imprimir!";
		}

		lista += "\n\n---------- Lista de Voos ----------";
		for (Voo v : voos) {
			lista += v.imprimir() + "\n-----------------------------------";
		}

		return lista;

	}
	
	public String listarAeronaves() {
	    if (aeronaves.isEmpty()) {
	        return "Nenhuma aeronave cadastrada até o momento!";
	    }
	    String lista = "\n---------- Lista de Aeronaves ----------\n";
	    for (Aeronave a : aeronaves) {
	        lista += a.imprimir() + "\n-----------------------------------\n"; 
	    }
	    return lista;
	}

	public void adicionarAeronave(Aeronave aeronave) throws IllegalArgumentException {
		if (aeronave == null) {
			throw new IllegalArgumentException("Aeronave deve ser informada");
		} else {
			
			conferirCodigoAeronave(aeronave.getCodigo());
			aeronaves.add(aeronave);
		}

	}

	public void conferirCodigoVoo(int valor) throws IllegalArgumentException {
		if(valor == 0) {
			throw new IllegalArgumentException("Valor inválido \n Digite um valor maior que 0 (zero)");
		}
		for (Voo v : voos) {
			if (v.getNum() == valor) {
				throw new IllegalArgumentException(
						"Tentativa de cadastro com mesmo código de voo \nInsira outro código ");
			}
		}
	}
	
	public void conferirCodigoAeronave(int valor) throws IllegalArgumentException {
		if(valor == 0) {
			throw new IllegalArgumentException("Valor inválido \n Digite um valor maior que 0 (zero)");
		}
		
		for(Aeronave a : aeronaves) {
			if(a.getCodigo() == valor) {
				throw new IllegalArgumentException(
						"Tentativa de cadastro com mesmo código de aeronave  \nInsira outro código ");
			}
		}
		
	}

	public String imprimir() {
		return "Código Aeroporto: " + getCodigo() + "\nNome Aeroporto: " + getNome() + "\nCidade Aeroporto: "
				+ getCidade();
	}
}
