package com.api.parkingcontrol.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.parkingcontrol.models.ParkingSpotModel;

@Repository     // Estereótipo do Spring. Será um Repositório do Spring (Bean, do Spring)
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID>{ // A interface ParkingSpotRepository está
	// herdando de uma interface, chamada de JpaRepository. Em < , > , o primeiro argumento, deste caso, será um Model (neste
	// nosso caso será a classe ParkingSpotModel. O Segundo argumento, neste caso, será o tipo do identificador, que no caso de nosso Model
	// (da classe ParkingSpotModel) é do tipo UUID.
	
	// OBS: Está usando o JpaRepository, porque ele possui métodos prontos para realizar transações com o Banco de Dados.
	// ParkingSpotRepository, ao herdar da interface JpaRepository, torna ParkingSpotRepository em um Bean do Spring, pois
	// JpaRepository é um Bean.  Mas, se colocar a notação @Repository na interface ParkingSpotRepository, não fica errado e
	// não dá erro, mas fica opcional colocar ou não.
	
	public boolean existsByLicensePlateCar(String licensePlateCar);  // Primeira Assinatura de Método.
	public boolean existsByParkingSpotNumber(String parkingSpotNumber); // Segunda Assintura de Método.
	public boolean existsByApartmentAndBlock(String apartment, String block); // Terceira Assinatura de Método.
	
}
