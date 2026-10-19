
public class Animal {
	
	private String nome;
	private String especie;
	private Dono dono;
	private float p1;
	private float p2;
	private float p3;

	
	//construtor
	
	public Animal(String nomeAnimal, String especieAnimal, Dono dono, float p1, float p2, float p3) throws IllegalArgumentException {
		setNome(nomeAnimal);
		setEspecie(especieAnimal);
		setDono(dono);
		setP1(p1);
		setP2(p2);
		setP3(p3);
	}
	
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nomeAnimal) throws IllegalArgumentException{
		if(nomeAnimal == null || nomeAnimal.isBlank()) {
			throw new IllegalArgumentException("Nome deve ser informado!");
		}
		this.nome = nomeAnimal;
		
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especieAnimal) throws IllegalArgumentException {
		if(especieAnimal == null  || especieAnimal.isBlank()) {
			throw new IllegalArgumentException("Espécie deve ser informada!");
			}
		this.especie = especieAnimal;
	}
	public Dono getDono() {
		return dono;
	}
	public void setDono(Dono dono) throws IllegalArgumentException {
		if(dono == null) {
			throw new IllegalArgumentException("Dono precisa ser cadastrado");
		}
		this.dono = dono;
	}
	
	public float getP1() {
		return p1;
	}

	public void setP1(float p1) throws IllegalArgumentException {
		if(p1 < 0) {
			throw new IllegalArgumentException("Primeiro peso precisa ser informado!");
		}
		this.p1 = p1;
	}

	public float getP2() {
		return p2;
	}

	public void setP2(float p2) throws IllegalArgumentException {
		if(p2 < 0) {
			throw new IllegalArgumentException("Segundo peso precisa ser informado!");
		}
		this.p2 = p2;
	}

	public float getP3() {
		return p3;
	}

	public void setP3(float p3) throws IllegalArgumentException {
		if(p3 < 0) {
			throw new IllegalArgumentException("Terceiro peso precisa ser informado!");
		}
		this.p3 = p3;
	}
	
	public float mediaPesos() {
		float media = (p1 + p2 + p3) / 3;
		return media;
	}
	

	public String imprimir() {
		String dados = " ";
		 dados += "\nNome: " + getNome() 
		 + "\nEspécie: " + getEspecie() 
		 + "\nDono: " + dono.getNome()
		 + "\nÚltimo peso: " + getP3()
		 +"\nMédia peso: " + mediaPesos()
		 + "\n";
		 
		 return dados;
	}
	
}
