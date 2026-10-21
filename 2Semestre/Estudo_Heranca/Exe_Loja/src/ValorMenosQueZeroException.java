
public class ValorMenosQueZeroException extends IllegalArgumentException{
	
	private static final long SerialVersionUD = 1L;
	public ValorMenosQueZeroException (String campo) {
		super(campo + " deve ser maior ou igual a zero");
	}

}
