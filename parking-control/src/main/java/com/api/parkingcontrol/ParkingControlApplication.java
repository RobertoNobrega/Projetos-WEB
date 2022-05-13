package com.api.parkingcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// OBS: Esse projeto foi criado no site do Spring Initializer, sendo feito o download dele e feito o import dele no Eclipse IDE.

//  OBS: Na pasta src/main/java, no pacote com.api.parkingcontrol, a classe ParkingControlApplication fica na raiz do pacote, ou
// seja, fica em parkingcontrol.  Ou seja, a classe ParkingControlApplication é uma classe principal e tem que ficar na raiz do
// pacote parkingcontrol. parkingcontrol é o pacote da nossa aplicação (nele, vão estar classes, interfaces e outros).
// Como parkingcontrol é a pasta raiz, foram criadas, dentro dela, quatro pacotes: controllers, models, repositories, services

// OBS: Em src/main/resources, tem duas pastas: templates e test. Como este projeto é para criar uma API, então não é preciso tê-las.
// Portanto, pode excluí-las.   Agora, se o projeto tivesse views (visualização), com "timelief" ou jsp, então estas pastas poderiam
// continuar no projeto.

// Segue abaixo, o código a ser inserido no arquivo application.properties, para que haja uma conexão com o Banco de Dados do pgAdmin4.

 /*
   	                  
        spring.datasource.url=jdbc:postgresql://localhost:5432/parking-control-db
		# Linha 1: Informando a Base de Dados. Aqui, está usando a base chamada parking-control-db, do pgAdmin4.
		spring.datasource.username=postgres
		# Linha 3: Informando o Usuário do pgAdmin4 (aqui, foi definido como postgres)
		spring.datasource.password=postgres
		# Linha 5: Informando a senha do Usuário (aqui, foi definido como postgres)
		spring.jpa.hibernate.ddl-auto=update
		# Linha 7: Ao colocar update, indica que as tabelas e os registros que se encontram no BD, continuarão sendo persistidos, mesmo
		# quando o BD for fechado ou até quando o computador estiver desligado.  OBS: Ele também faz o mapeamento das entidades, das models.
		spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
		# Linha 10: Ao colocar true, indica que o JPA não colocará Metadados, para que não ocorra nenhum tipo de conflito com o Banco de Dados.
  
 */

// Ao colocar estas linhas no arquivo application.properties, basta executar este projeto. Vai executar numa boa, quando o pgAdmin4 estiver
// em execução e aberto na base de dados parking-control-db

// Após isso, vá no browser (Google Chrome, por exemplo) e digite localhost:8080
//     Vai observar a seguinte mensagem do Browser

/*
				 * 			Whitelabel Error Page
				This application has no explicit mapping for /error, so you are seeing this as a fallback.
				
				Wed May 11 12:30:09 BRT 2022
				There was an unexpected error (type=Not Found, status=404).
 * 
 * 
 */

//		Na mensagem acima, significa que não foi mapeado nenhum endpoint, método.


@SpringBootApplication   // O Spring, por padrão, coloca esta notação, quando é criado o projeto.
@RestController   // Usando esta notação (estereótipo do Spring), indica que a classe ParkingControlApplication será um Bean do Spring, do tipo
// controller; para que o Spring gere as dependências quando for necessário.

// Bean é um objeto, que é instanciado, montado e usado dentro do Core Container do Spring Framework, pois vai possuir injeção de dependência e
// inversão de controle.  OBS: Inversão de Controle é um padrão de projeto, ao qual um objeto define(m) dependência(s) que devem ser implementado(s)
// por um outro "objeto"; ou seja, a implementação destas dependências é a Injeção de Dependências.


/*
 * 				Overview: Este projeto é para desenvolver uma API, para controle de estacionamento (de um condomínio).
 *       O recurso que será focado para construir essa API, os endpoints : A Vaga de Estacionamento (Parking Spot)
 *         Como é esse o recurso, será também criado um model de Parking Spot, para que possa ser mapeado no JPA,
 *         tornando uma entidade (tabela) no Banco de Dados (tendo futuramente registros na tabela).
 * 
 * 
 * 
 */


/*					Deixar o Eclipse, em Modo Dark (Referência: Google)
 *      Window > Preferences > General > Appearence > Color Theme (em Theme, escolha a opção de Dark)
 *                
 *      			Aumentar o Tamanho de Fonte do Eclipse (Referência: Google. https://www.youtube.com/watch?v=T3zFeX0oSWQ)
 *      Menu Window -> Preferences -> No campo digite “font” -> Seleciona Colors and Font -> Na janela nova, busque
 *      pela pasta chamada Java. Clique Nela para expandir. Após isso, procure pela opção Java Editor Text Font. Clique
 *      nela e após isso, clique na opção de Edit. Vai aparecer uma janela. Nela vai ter a opção para alterar o tamanho
 *      de fonte. Escolha o tamanho e clique Apply e em seguida Apply and Close.
 *      
 *      Atalho: Botão do Windows + Tecla de "Pause Break" : Abre uma janela, informando as configurações básicas do Windows.
 */



public class ParkingControlApplication{

	public static void main(String[] args) {
		SpringApplication.run(ParkingControlApplication.class, args);
	}
	
	// O método index abaixo, será mapeado (para ser chamado em uma requisição HTTP). 
	@GetMapping("/")  // OBS: Como não está colocando uma URI, então ficará na raiz a chamada do método index, para que possa ser usado em localhost:8080
	public String index(){
		return "Olá Mundo!";
	}
	
	/*
	 * 		Por debaixo dos "panos", o Spring tem um Dispatcher Servlet e sempre que nós enviamos requisições para a nossa aplicação, para o nosso
	 *    servidor, o dispatcher servlet recebe e faz uma espécie de roteamento, indicando para qual controller que irá receber e responder tal 
	 *    solicitação.   EX1: Foi o que ocorreu em localhost:8080
	 *    
	 *      A partir disso, podemos trabalhar com a Estrutura MVC, trabalhando com model, controller, camada service e com camada de transação (envolvendo
	 *      o uso do Repository).
	 *      
	 *  
	 */
}
