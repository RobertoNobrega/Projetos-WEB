package com.api.parkingcontrol.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
	
	// OBS: A data é gravada no formato UTC. No Brasil, o valor do offset é de três horas a menos. Ou seja,
	// se por acaso um registro de uma "entidade" for feito às 15h (Horário de Brasília), então, por exemplo,
	// usando o software Postman, quando for realizar um GET desta entidade, vai mostrar que o horário será
	// às 18h.
	
	
	@Transactional  // Como o método abaixo é usado com requisição POST, então é bom usarmos ela.
	public ParkingSpotModel save(ParkingSpotModel parkingSpotModel){
		// TODO Auto-generated method stub
		// Neste método, iremos usar dos métodos do Hibernate JPA.
		//    Usaremos o ponto de injeção da classe ParkingSpotRepository.
		return parkingSpotRepository.save(parkingSpotModel); // Gravando, no Banco de Dados, um registro da
		// entidade (da classe ParkingSpotModel).
	}

	public boolean existsByLicensePlateCar(String licensePlateCar) {
		// OBS: O Método existsByLicensePlateCar, precisa ser declarado no Repository (neste caso, na interface
		// ParkingSpotRepository), para que posteriormente possa ser chamado em uma outra classe (neste caso, na
		// classe ParkingSpotController).
		return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);  // OBS: Percebi que, este método
		// existsByLicensePlateCar, da interface ParkingSpotRepository, não está "implementada"; porém a interface
		// ParkingSpotRepository herda da interface JpaRepository.
	}

	public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
		// OBS: A explicação deste método é similar ao do método existsByLicensePlateCar acima.
		return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
	}

	public boolean existsByApartmentAndBlock(String apartment, String block) {
		// OBS: A explicação deste método é similar ao do método existsByLicensePlateCar acima.
		return parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
	}

	public List<ParkingSpotModel> findAll(){  // Buscar e Retornar os "ParkingSpotModel".
		return parkingSpotRepository.findAll();
	}

	public Optional<ParkingSpotModel> findById(UUID id){  // Retornando apenas um objeto ParkingSpotModel.
		return parkingSpotRepository.findById(id);
	}
	
	@Transactional   // Para usar, em método de gravação ou de exclusão.
	public void delete(ParkingSpotModel parkingSpotModel){ // Apagando apenas um ParkingSpotModel.
		parkingSpotRepository.delete(parkingSpotModel);
	}
	
}