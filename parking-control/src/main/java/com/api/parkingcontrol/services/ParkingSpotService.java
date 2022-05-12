package com.api.parkingcontrol.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;

@Service   // Estereótipo do Spring. Indica que a classe será um serviço do Spring (Bean do Spring, de Serviço).
public class ParkingSpotService {
	
	// Dentro desta classe, temos que criar um ponto de injeção do nosso Repository.
	// Dentro do Service, é camada intermediária entre o Controller e o Repository. Em determinados casos, o Service
	// vai ter que acionar o Repository (para realizar transações no Banco de Dados). Ou seja, além do Controller solicitar
	// diretamente no Repository; o Controller solicita ao Service e o Service solicita ao Repository.
	// Para que aconteça essa Injeção de Dependêcnias, dentro da classe ParkingSpotService, tem que ter um ponto de Injeção
	// de Dependência de ParkingSpotRepository.
	
	// @Autowired   // Serve para criar um ponto de Injeção de Dependência (representado pela variável abaixo, parkingSpotRepository)
	// ParkingSpotRepository parkingSpotRepository;
	
	// Outra maneira de criar a Injeção de Dependência, é descrita logo abaixo (ou seja, com o atributo parkingSpotRepository e o
	// construtor ParkingSpotRepository.
	
	final ParkingSpotRepository parkingSpotRepository;

	public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
		super();
		this.parkingSpotRepository = parkingSpotRepository;
	}
	
	// OBS: Métodos Construtivos ou Destrutivos, devem ser anotados com @Transactional. Para,
	// principalmente, quando temos relacionamentos, que vai ter deleção em cascata ou salvamento
	// em cascata; pois usando essa notação em deleção em cascata ou salvamento em cascata, caso ocorra
	// algum problema na transação de deleção ou salvamento, vai garantir o roll back e garantindo que
	// tudo volte ao normal.
	
	@Transactional  // Como o método abaixo é usado com requisição POST, então é bom usarmos ela.
	public ParkingSpotModel save(ParkingSpotModel parkingSpotModel){
		// TODO Auto-generated method stub
		// Neste método, iremos usar dos métodos do Hibernate JPA.
		//    Usaremos o ponto de injeção da classe ParkingSpotRepository.
		return parkingSpotRepository.save(parkingSpotModel); // Gravando, no Banco de Dados, um registro da
		// entidade (da classe ParkingSpotModel).
	}
	
}
