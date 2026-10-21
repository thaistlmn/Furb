
public class Notebook extends Produto {

	private int ram;
	private boolean ssd;

	public Notebook(String nome, double preco, int mesesGarantia, int ram, boolean ssd) {
		super(nome, preco, mesesGarantia);
		setRam(ram);
		setSsd(ssd);
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		if (ram < 0) {
			throw new ValorMenosQueZeroException("Ram");
		}
		this.ram = ram;
	}

	public boolean isSsd() {
		return ssd;
	}

	public void setSsd(boolean ssd) {
		this.ssd = ssd;
	}

	public double desconto() {
		if(ssd) {
			return getPreco() * 0.08;
		}
		return 0;
	}
	
/*
	public double precoComDesconto() {
		if(ssd) {
			return getPreco() * 0.92;
		}
		return getPreco();
		
	}
*/
	
	@Override
	public int getMesesGarantia() {
		if(this.ram >= 16) {
			return super.getMesesGarantia() + 6;
		}
		return super.getMesesGarantia();
	}
	

	
}
