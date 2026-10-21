# Exercício proposto em sala: 

1) A loja TechFácil vai lançar um panfleto com ofertas. A gerência quer simular como o preço “na última página” aparece para cada produto e como a garantia total muda conforme as características. Todo produto tem um preço-base e meses de garantia. Porém, Smartphones com 5G ganham 5% de desconto e modelos com 256 GB ou mais recebem +3 meses de garantia. Notebooks com SSD recebem 8% de desconto e, se tiverem 16 GB de RAM ou mais, ganham +6 meses de garantia. Você deve montar uma lista de produtos misturando smartphones e notebooks e imprimir o preço final e a garantia total de cada um — mas sempre enxergando tudo como Produto. Ao final, some os preços finais para estimar a receita daquela campanha.

## Regras de Negócio

### 1. Geral (Produto)
* Todo produto possui: Nome, Preço-base e Garantia-base (em meses).

### 2. Smartphone
* **Desconto:** 5% sobre o preço-base caso possua conectividade **5G**.
* **Garantia Adicional:** +3 meses caso possua **256 GB de armazenamento** ou mais.

### 3. Notebook
* **Desconto:** 8% sobre o preço-base caso possua armazenamento em **SSD**.
* **Garantia Adicional:** +6 meses caso possua **16 GB de RAM** ou mais.

## Conceitos de POO Aplicados

* **Encapsulamento:** Proteção dos atributos de cada classe com acesso controlado via métodos getters/setters e construtores.
* **Herança:** A classe abstrata/base `Produto` encapsula os atributos e comportamentos comuns, enquanto `Smartphone` e `Notebook` herdam essas propriedades.
* **Polimorfismo:** A classe `Campanha` manipula os itens estritamente como instâncias de `Produto`. A chamada dos métodos de cálculo de desconto e garantia é resolvida dinamicamente em tempo de execução de acordo com o tipo real do objeto (`Smartphone` ou `Notebook`).

## Estrutura da Solução

* `Produto`: Classe base que define os atributos gerais de um item do catálogo.
* `Smartphone`: Subclasse de `Produto` com atributos de armazenamento (GB) e suporte a 5G.
* `Notebook`: Subclasse de `Produto` com atributos de memória RAM (GB) e presença de SSD.
* `Campanha`: Classe responsável por armazenar a lista de produtos (`List<Produto>`), iterar sobre o catálogo para relatórios e calcular o faturamento total previsto.

## Testes Unitários

O projeto conta com uma suíte de testes desenvolvida com **JUnit** para garantir a precisão dos cálculos e das regras condicionais:

* Validação das porcentagens de desconto com base em flags de hardware (5G / SSD).
* Validação do acréscimo de meses de garantia por capacidade de hardware (RAM / Armazenamento).
* Cálculo do totalizador de receita da classe `Campanha`.

## Como Executar

### Pré-requisitos

* Java JDK 11 ou superior.
* JUnit 5.

### Passos

1. Clone o repositório:
   
```bash
   git clone [https://github.com/seu-usuario/techfacil-ofertas.git](https://github.com/seu-usuario/techfacil-ofertas.git)
