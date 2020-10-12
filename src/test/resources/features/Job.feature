#language: pt
#encoding: utf-8

Funcionalidade: Consultar vaga de emprego

  Esquema do Cenario: Buscar por vaga em aberto oferecidas pela BRQ
    Dado que o usuario acessa o site de vaga
    E preenche o campo de busca com "<cargo>"
    E seleciona a "<localidade>" para exibir o resultado da busca
    Quando o usuario clicar na vaga do "<cargo>" desejado
    Entao visualiza o "<cargo>" e a "<localidade>" na vaga exibida

    Exemplos:
      | cargo                 |localidade     |
      | Desenvolvedor IOS     |Sao Paulo      |
      | Programador .NET      |Rio de Janeiro |
      | Analista de Sistemas  | Curitiba      |
