package heranca;

import excecao.CampoVazioException;

public class Funcionario {
	
	private String nome;
	private double salarioBase;
	
	public Funcionario(String nome, double salarioBase) {
		setNome(nome);
		setSalarioBase(salarioBase);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws CampoVazioException {
		if(nome == null)
			throw new CampoVazioException("Nome Funcionário");
		this.nome = nome;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		if(salarioBase <= 0) {
			throw new IllegalArgumentException("Valor do saládio deve ser maior que zeros");
		}
		this.salarioBase = salarioBase;
	}
	
	public double calcularSalario() {
		return this.salarioBase;
	}
	

}
