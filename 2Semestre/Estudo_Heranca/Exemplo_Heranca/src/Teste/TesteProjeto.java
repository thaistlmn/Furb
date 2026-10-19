package Teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import heranca.Funcionario;
import heranca.Gerente;

public class TesteProjeto {
	
	@Test
	void test() {
		assertTrue(true);
		assertEquals("Ana", "Ana");
	}
	
	//testar o objeto
	@Test
	void testarFuncionario() {
		Funcionario f = new Funcionario("Ana", 2000.00);
		assertEquals(f.getNome(), "Ana");
		assertEquals(f.getSalarioBase(),2000.00);
	}
	
	@Test
	void testarGerente() {
		Gerente g = new Gerente("Andre", 3000.00, 1580.00);
		assertEquals(g.getNome(), "Andre");
		assertEquals(g.getSalarioBase(), 3000,00);
		assertEquals(g.getBonus(), 1580.00);
	}
	
	@Test
	void testarCalculoSalario() {
		Gerente g = new Gerente("Carlos", 4000.00, 1200.00);
		assertEquals(5200.00, g.calcularSalario(), "O cálculo do salário do gerente está incorreto!");
		
		}
	
	@Test
	void testarGerenteComBonusNegativo() {
		//O assertThrows serve para testar se um bloco de código lança uma exceção esperada
		//assertThrows espera que a linha de código dentro da expressão lambda lance a exceção informada
		assertThrows(IllegalArgumentException.class, () -> {
			new Gerente("Carlos", 4000.00, -500.00); // tentando passar um bônus negativo
		});
	}
	}
	
