## Ambar Sand

Pequeno projeto com a finalidade de praticar os conceitos de POO. Ambar Sand é um programa que gerência os aluguéis de equipamentos de praia.

## Estrutura do Diretório

Os três principais paths do diretório são:

- `ambar-sand/src/ambar`: Pasta que armazena o código fonte.
- `ambar-sand/bin/classes/ambar`: Pasta que armazenas as classes compiladas.
- `ambar-sand`: Pasta principal. Aqui é possivel compilar e rodar o programa.

## Dependências

Há alguns requisitos para dar run no programa:

- `JDK` : É obrigatório te-lo para compilar e rodar o programa.
- `MAKE` : É opcional que o ambiente do sistema possa usar o makefile, mas caso queira usa-lo é necessário. Contudo, é possivel compilar com "javac -d bin/classes src/ambar/*.java" e dar run com "java -cp bin/classes ambar.AmbarSandAPP" (*é preciso estar na pasta principal para executar esses comandos com êxito*).
