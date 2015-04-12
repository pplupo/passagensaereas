=Trabalho de Sistemas Operacionais da UFRJ do período 2007/02 em Java.=

Implementar um servidor remoto para venda de passagens aéreas que poderá atender clientes através de uma rede TCP/IP. Cada solicitação recebida pelo servidor será executada por uma thread distinta.

A companhia opera 5 vôos domésticos ligando Rio a São Paulo (Boeing 737 com 100 lugares), Rio a Salvador (50 assentos), Rio a Belo Horizonte (30 assentos), Rio a Brasília (100 assentos) e Rio a Manaus (20 assentos).

==Características da aplicação==

===Módulo Cliente===
 # Recebe como entrada o endereço IP do servidor ex: ./cliente 192.168.0.1
 # Exibe um prompt e permanece em loop para execução interativa das seguintes funções:
  # Lista trechos (listatrechos)
  # Consulta disponibilidade (vagas <trecho>)
  # Reserva (reserva <trecho, #assentos >)
  # Efetua compra (compra <trecho, #assentos>)
  # Consulta reserva (consres <trecho>)
  # Consulta compra (conscomp <trecho>)
  # Consulta reservas (consress) _retorna as reservas em todos os trechos_
  # Consulta compras (conscomps) _retorna as compras em todos os trechos_
 # Após a compra o cliente encerra a conexão.
 # Devem ser levantadas e feitas todas as verificações de consistência.

===Módulo Servidor===
 # Aguarda solicitações de um ou mais clientes e dispara uma thread para atender cada uma destas solicitações.
 # Não tem interface com o usuário.
 # Só é encerrado através de um comando de stop.
 # Deve permitir leituras concorrentes para uma mesma aeronave.
 # A reserva é um artifício para permitir ao cliente pensar antes de efetuar a compra. Uma reserva cai automaticamente após um tempo pré-fixado de 5s.
 # Os assentos são distribuídos automaticamente (o cliente não escolhe).
 # A compra requer reserva prévia.
 # É política da empresa adotar um overbook de até 10% da lotação da aeronave.

O grupo deve preparar uma demonstração com 01 servidor e até 05 clientes concorrentes em diferentes estações de trabalho.

A descrição é basicamente a descrição do trabalho do período anterior (2007/01).
No entanto, neste período o professor liberou a utilização de Java e deixou claro que gostaria de uma interface gráfica.

Este trabalho é feito totalmente em Java e tem interface gráfica tanto para o cliente quanto para o servidor.

Melhorias a serem feitas:
 # Incluir confirmação de compra no cliente Mobile.
 # Atualizar as informações das vagas disponíveis em cada trecho após a compra no cliente Mobile.
 # Incluir funcionalidade de reserva e confirmação de reserva no cliente Mobile.
 # Atualizar as informações das vagas disponíveis em cada trecho após a reserva no cliente Mobile.
 # Incluir no cliente e no servidor opções para troca de look&feel e tema.
 # Documentar o código com Javadoc.
 # Gerar diagramas UML (pelo menos classe e seqüência).
 # Remodelar o MVC fazendo com que a interface seja observadora dos trechos para refletir as mudanças no modelo.
 # Implementar a persistência utilizando JPA e Hibernate.
 # Mostrar automaticamente os reflexos das mudanças do servidor em todos os clientes.
 # Unificar as classes "Trecho" do cliente e do servidor em uma classe Trecho apenas e fazer as instâncias desta classe serem enviadas pela rede ao invés de strings.
 # Implementar a internacionalização dos textos da interface usando o mecanismo de Resource Bundle do Java.
 # Rever o tratamento de exceções. Há lugares onde deveriam ser lançadas e são "tratadas" e vice-versa.
 # Implementar na interface do servidor uma área de mensages das ações solicitadas pelos clientes com os resultados (como um log).
 # Acrescentar na interface do cliente as compras efetuadas em cada trecho e as reservas efetuadas em cada trecho.
 # Implementar um mecanismo de log no cliente e no servidor utilizando Log4J.
 # Implementar testes automatizados com JUnit.
