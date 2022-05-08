package br.com.roberto.pacote.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *		 Para executar este projeto, esteja na classe Projeto1SpringApplication.java , para
 *     executar o método main dele. Após isso, vai verificar no Console da IDE Eclipse que 
 *     o Spring está em execução (ele também vai por no ar o Servidor de Aplicação TomCat, ao
 *     qual este servidor estará executando na porta 8080).
 *    
 * 		 Depois de colocar em execução, vá no navegador.
 *          Na classe ExampleController, tem dois endpoints ( get e mensagemPrincipal)
 *            http://localhost:8080/api/example/hello-world
 *                Vai acessar o método get, ao qual irá exibir uma String na tela ( Hello World. ).
 *            http://localhost:8080/api/example/mensagem-principal
 *            	  Vai acessar o método mensagemPrincipal, ao qual irá exibir uma String na tela;
 *	   Referência: https://medium.com/danielpadua/java-spring-boot-eclipse-7a1c4c364839
 * 
 */


@RestController
@RequestMapping("/api/example")
public class ExampleController {
	
	/*
	*     Nesta classe, terá um endpoint, ao qual será usada para
	*     retornar uma String "fixa" ( Hello World ).
	*/
	
	@GetMapping("/hello-world")
	public ResponseEntity<String> get(){
		return ResponseEntity.ok("Hello World.");
	}
	
	@GetMapping("/mensagem-principal")
	public ResponseEntity<String> mensagemPrincipal(){
		return ResponseEntity.ok("Olá. Bem-Vindo a tecnologia WEB, usando Java e Spring Boot.");
	}
	
}
