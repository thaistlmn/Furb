# Sistema de Gerenciamento de Funcionários - Exercício Prático de POO e Testes Unitários

Este exercício é uma aplicação Java orientada a objetos desenvolvida para gerenciar e calcular a remuneração de colaboradores em uma empresa, diferenciando funcionários comuns de gerentes que possuem direito a bônus salarial.

O projeto também conta com uma suíte de **testes unitários automatizados com JUnit 5**, cobrindo validações de regra de negócio, tratamento de exceções e o uso do polimorfismo.

---

## Tecnologias Utilizadas

- **Linguagem:** Java (versão 21)
- **Framework de Testes:** JUnit 5 (Jupiter API)
- **IDE:** Eclipse

---

## Funcionalidades e Regras de Negócio

1. **Superclasse `Funcionario`**:
   - Possui os atributos `nome` (String) e `salarioBase` (double).
   - O método `calcularSalario()` retorna apenas o salário base do funcionário.

2. **Subclasse `Gerente` (Herança)**:
   - Estende a superclasse `Funcionario`.
   - Possui o atributo adicional `bonus` (double).
   - Reutiliza o construtor da superclasse (`super`).
   - Realiza a **sobrescrita (`@Override`)** do método `calcularSalario()`, somando o `salarioBase` com o `bonus`.
   - **Validação de Segurança:** Não permite a criação de gerentes com valores de bônus negativos, lançando a exceção `IllegalArgumentException`.

---

## Testes Unitários (JUnit 5)

A classe `TesteProjeto` contém testes automatizados para validar a integridade da aplicação:

- **Instanciação e Getters:** Confirma a correta atribuição de nomes, salários base e bônus.
- **Cálculo de Salário:** Valida se a sobrescrita do método `calcularSalario()` calcula a soma exata para o gerente (`salarioBase + bonus`) e o valor base correto para o funcionário.
- **Polimorfismo:** Garante que referenciar um objeto do tipo `Gerente` por meio do tipo genérico `Funcionario` chama a implementação correta de `calcularSalario()`.
- **Tratamento de Exceções (`assertThrows`):** Testa a resistência da regra de negócio ao tentar cadastrar um bônus negativo.

---

## Estrutura do Projeto

```text
src/
├── heranca/
│   ├── Funcionario.java
│   └── Gerente.java

└── Teste/
    └── TesteProjeto.java
