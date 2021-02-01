# Máquina de Turing

O objetivo dessa aplicação é desenvolver uma Máquina de Turing Determinística Padrão que computa funções numéricas.

## Organização do código-fonte
* [Transicao.java](./src/Transicao.java): Representa uma transição de um estado para outro. Armazena o estado inicial, o caractere a ser lido, o caractere a ser escrito, o estado para qual a máquina irá e qual operação precisa ser feita na fita.
* [MaquinaTuring.java](./src/MaquinaTuring.java): Representa a Máquina de Turing em si. Armazena a quíntupla de dados e possui o método executar() junto com seus auxiliares. O método executar executa todas as transições e retorna uma lista de String que contém o estado da máquina em cada transição.
* [ManipuladorArquivo.java](./src/ManipuladorArquivo.java): Possui os métodos de leitura e escrita em arquivos de texto.
* [Principal.java](./src/Principal.java): Possui o método main, responsável pela execução da aplicação. Lê o arquivo de entrada, executa a Máquina de Turing e escreve o resultado no arquivo de saída.

## Execução da aplicação
```
java -jar dist/MaquinaTuring.jar input.txt output.txt
```
