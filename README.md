# Projeto Delivery-Food-Dextra


----------
***Instruções para executar***

----------


**1 -** Clonar o repositório no github

**2 -** Importar no Eclipse como projeto Maven (STS - Spring Tool Suit)
      File > Import > Maven > Existing Maven Projects
      
**3 -** Rodar a classe principal AppDeliveryfoodDextraApplication 
	Run as > Spring Boot App
	
**4 -** Pelo Postman ou Google Chrome é possível acessar a URI dos Recursos
	localhost:8080/lanches
	localhost:8080/ingredientes
	

***Tecnologias Utilizadas***
- Java 8 JDK
- Maven versão 3.0.5
- Spring Boot 2.0.x
- Google Chrome e Postman
- JUnit / Hamcrest / SpringBootTest
- STS - Spring Tool Suit (Eclipse / Maven / Tomcat / Jackson / JPA)


----------


***--- Relatório de justificativas para escolha do design de código ---***

----------


 1 - **Modelagem Conceitual**
https://github.com/marcosseibert/deliveryfood-dextra/blob/master/modelagem-food-dextra.png

Com base no modelo descritivo foi desenvolvido esse Modelo Conceitual (modelo de domínio em nível de análise) acima utilizando o Diagrama de Classe do UML , ele foi pensado e implementado sobre o paradigma orientado a objetos, usando padrões de desenvolvimento e boas práticas.

2 - **Modelo Arquitetural**
https://github.com/marcosseibert/deliveryfood-dextra/blob/master/modelo-arquitetural-food-dextra.png

O projeto foi concebido  seguindo o modelo arquitetural Orientado a Serviço e dividido em camadas, Camada de domínio, Camada de Repositório de dados, Camada de Serviço e Camada de Controladores Rest (endpoints da aplicação). Orientado a Serviços porque os recursos são disponibilizados através de Serviços, fazendo  o uso adequado do protocolo HTTP no padrão REST.
Para implementação do calculo de preço do lanche foi utilizado o **Design Patter Strategy**, para encapsular  os algoritmos , com isso a implementação pode ser trocada dinamicamente em tempo de execução, sendo assim a classe Lanche delega a responsabilidade de utilizar o algoritmo correto para a classe que a compõe (Composição de Objetos).