package excecao;

public class CampoVazioException extends IllegalArgumentException {
	
	public CampoVazioException(String campo) {
		super(campo + " deve ser informado.");
	}

}



