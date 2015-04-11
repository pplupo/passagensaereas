# Trabalho de Sistemas Operacionais da UFRJ do período 2007/02 em Java. #

Implementar um servidor remoto para venda de passagens aéreas que poderá atender clientes através de uma rede TCP/IP. Cada solicitação recebida pelo servidor será executada por uma thread distinta.

A companhia opera 5 vôos domésticos ligando Rio a São Paulo (Boeing 737 com 100 lugares), Rio a Salvador (50 assentos), Rio a Belo Horizonte (30 assentos), Rio a Brasília (100 assentos) e Rio a Manaus (20 assentos).

## Características da aplicação ##

### Módulo Cliente ###
  1. Recebe como entrada o endereço IP do servidor ex: ./cliente 192.168.0.1
  1. Exibe um prompt e permanece em loop para execução interativa das seguintes funções:
    1. Lista trechos (listatrechos)
    1. Consulta disponibilidade (vagas 

&lt;trecho&gt;

)
    1. Reserva (reserva <trecho, #assentos >)
    1. Efetua compra (compra <trecho, #assentos>)
    1. Consulta reserva (consres 

&lt;trecho&gt;

)
    1. Consulta compra (conscomp 

&lt;trecho&gt;

)
    1. Consulta reservas (consress) _retorna as reservas em todos os trechos_
    1. Consulta compras (conscomps) _retorna as compras em todos os trechos_
  1. Após a compra o cliente encerra a conexão.
  1. Devem ser levantadas e feitas todas as verificações de consistência.

### Módulo Servidor ###
  1. Aguarda solicitações de um ou mais clientes e dispara uma thread para atender cada uma destas solicitações.
  1. Não tem interface com o usuário.
  1. Só é encerrado através de um comando de stop.
  1. Deve permitir leituras concorrentes para uma mesma aeronave.
  1. A reserva é um artifício para permitir ao cliente pensar antes de efetuar a compra. Uma reserva cai automaticamente após um tempo pré-fixado de 5s.
  1. Os assentos são distribuídos automaticamente (o cliente não escolhe).
  1. A compra requer reserva prévia.
  1. É política da empresa adotar um overbook de até 10% da lotação da aeronave.

O grupo deve preparar uma demonstração com 01 servidor e até 05 clientes concorrentes em diferentes estações de trabalho.

A descrição é basicamente a descrição do trabalho do período anterior (2007/01).
No entanto, neste período o professor liberou a utilização de Java e deixou claro que gostaria de uma interface gráfica.

Este trabalho é feito totalmente em Java e tem interface gráfica tanto para o cliente quanto para o servidor.

Melhorias a serem feitas:
  1. Incluir confirmação de compra no cliente Mobile.
  1. Atualizar as informações das vagas disponíveis em cada trecho após a compra no cliente Mobile.
  1. Incluir funcionalidade de reserva e confirmação de reserva no cliente Mobile.
  1. Atualizar as informações das vagas disponíveis em cada trecho após a reserva no cliente Mobile.
  1. Incluir no cliente e no servidor opções para troca de look&feel e tema.
  1. Documentar o código com Javadoc.
  1. Gerar diagramas UML (pelo menos classe e seqüência).
  1. Remodelar o MVC fazendo com que a interface seja observadora dos trechos para refletir as mudanças no modelo.
  1. Implementar a persistência utilizando JPA e Hibernate.
  1. Mostrar automaticamente os reflexos das mudanças do servidor em todos os clientes.
  1. Unificar as classes "Trecho" do cliente e do servidor em uma classe Trecho apenas e fazer as instâncias desta classe serem enviadas pela rede ao invés de strings.
  1. Implementar a internacionalização dos textos da interface usando o mecanismo de Resource Bundle do Java.
  1. Rever o tratamento de exceções. Há lugares onde deveriam ser lançadas e são "tratadas" e vice-versa.
  1. Implementar na interface do servidor uma área de mensages das ações solicitadas pelos clientes com os resultados (como um log).
  1. Acrescentar na interface do cliente as compras efetuadas em cada trecho e as reservas efetuadas em cada trecho.
  1. Implementar um mecanismo de log no cliente e no servidor utilizando Log4J.
  1. Implementar testes automatizados com JUnit.