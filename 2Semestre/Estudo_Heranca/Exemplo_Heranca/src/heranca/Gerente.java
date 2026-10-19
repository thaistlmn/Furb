package heranca;


public class Gerente extends Funcionario {
	
	private double bonus;
	
	public Gerente(String nome, double salarioBase, double bonus) {
		super(nome, salarioBase);
		setBonus(bonus);
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		if(bonus <= 0) {
			throw new IllegalArgumentException("Valor do bonus deve ser maior que zero");
		}
		this.bonus = bonus;
	}
	
	@Override
	public double calcularSalario() {
		return getSalarioBase() + this.bonus;
	}

}
