package com.api.parkingcontrol.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.services.ParkingSpotService;

@RestController   // Estereótipo do Spring (informa que a classe abaixo será um Bean do Spring). Indica também que a classe vai
// usar o padrão arquitetural REST (para representação de informações).
@CrossOrigin(origins = "*", maxAge = 3600)   // Para permitir que seja acessado de qualquer fonte.
@RequestMapping("/parking-spot")  // Definindo uri, a nível de classe. Para acessar este recurso, digite: localhost:8080/parking-spot
public class ParkingSpotController {
	
	// Controller vai receber requisições (GET, POST, PUT ou DELETE)
	// 				OBS: O Controller vai acionar o Service.
	
	// Abaixo, vamos criar um ponto de injeção de dependência (dentro da Controller, temos que ter uma injeção de dependência de
	// Service).
	
	// @Autowired
	// ParkingSpotService parkingSpotService;
	
	// Abaixo, uma outra maneira de se criar Injeção de Dependência.
	final ParkingSpotService parkingSpotService;
	
	public ParkingSpotController(ParkingSpotService parkingSpotService){
		super();
		this.parkingSpotService = parkingSpotService;
	}
	
	// @PostMapping   já indica que usará o Método POST .
	
	@PostMapping  // OBS: Esta usando esta notação, sem definir uma uri no método abaixo, pois
	// acima do nome da classe ParkingSpotController, foi definido uma uri a nível de classe. Portanto,
	// quando o cliente fizer uma gravação de dados (usando o Método POST), o cliente vai enviar esse POST
	// por meio da uri   /parking-spot , definindo um método POST HTTP. Portanto, nesse caso aqui, quando
	// fizer essa solicitação do método POST, o método saveParkingSpot será acionado pelo Spring.
	public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto){
		// ResponseEntity<Object>: O retorno deste método acima será esse. O retorno vai apresentar corpo
		// e Status da Resposta. Foi definido como Object, pois pode ser que a resposta varie, dependendo
		// das verificações.
		// @RequestBody : Indica que os dados (do objeto parkingSpotDto) serão representados em formato JSON.
		// @Valid : "Obrigatório" colocar esta notação, para validar os atributos do objeto parkingSpotDto, pois
		// se não colocar esta notação, vai dar erro. Ou seja, por exemplo, se algum dos campos do objeto parkingSpotDto
		// estiver em branco ou vazio, automaticamente o cliente receberá um Bad Request (Operação não foi realizada). Isso,
		// por parte, garante uma certa segurança, pois tem validação.
		var parkingSpotModel = new ParkingSpotModel(); // OBS: var foi inserida como tipo, no Java 9 ou "foi" no Java 11. Ele
		// serve (de uma maneira de um escopo fechado), pelo que entendi, para declarar e instanciar um objeto de uma classe.
		BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel); // Este método está realizando uma conversão, de DTO para Model,
		// ou seja, o Banco de Dados irá persistir dados de uma entidade Model, mas não de um DTO. POrtanto, o objeto parkingSpotDto
		// terá um "representante idêntico, mas de natureza Model", para poder persistir seus dados no Banco de Dados. Esse representante
		// é o objeto parkingSpotModel.
		parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC"))); // Setando a data do registro a ser persistido no Banco de
		// de Dados. 
		return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel)); // Resposta. O status foi definido
		// como criado; enquanto que o corpo (body) vai receber o retorno do método save (que vai possuir a vaga de estacionamento salva, com
		// a data, co o id gerado no Banco de Dados).
	}
}
