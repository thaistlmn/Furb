
public class Dono {
	
	private String nome;
	private String contato;
	
	Dono(String nomeDono, String contatoDono) throws IllegalArgumentException {
		setNome(nomeDono);
		setContato(contatoDono);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nomeDono) throws IllegalArgumentException {
		if(nomeDono == null || nomeDono.isBlank()) {
			throw new IllegalArgumentException("Nome do dono deve ser informado!");
		}
		this.nome = nomeDono;
	}
	
	public String getContato() {
		return contato;
	}
	
	public void setContato(String contatoDono) throws IllegalArgumentException {
		if(contatoDono == null || contatoDono.isBlank()) {
			throw new IllegalArgumentException("Número de telefone insuficiente!");
		}
		this.contato = contatoDono;
	}

	public String imprimir() {
		return getNome() + getContato();
	}
	

}
