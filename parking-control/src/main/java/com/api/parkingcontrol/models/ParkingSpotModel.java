package com.api.parkingcontrol.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Esta classe faz parte da Camada de Dados.
//    Estaremos usando o JPA Hibernate, para realizar o Mapeamento desta Classe, para que seja uma Entidade no Banco de Dados.

@Entity   // Informando que a classe ParkingSpotModel é uma Entidade do Banco de Dados. 
@Table(name = "TB_PARKING_SPOT")  // Fornecendo um nome para a tabela do Banco de Dados. Ou seja, no BD, a entidade será chamada de TB_PARKING_SPOT
public class ParkingSpotModel implements Serializable{
	
	private static final long serialVersionUID = 1L;  // ID do Serializable da classe ParkingSpotModel. Essa parte do Serializable
	// nesta classe, é por conta de realizar conversão da classe java em bytes, para serem gravadas em um Banco de Dados. O atributo
	// definido na linha 14, é um controle usado pela JVM.
	
	@Id // Informando que o atributo id será um identificador desta classe (e na tabela também)
	@GeneratedValue(strategy = GenerationType.AUTO) // A chave será gerada automaticamente pelo Banco de Dados.
	private UUID id;   // Identificador. O uso do UUID é recomendável, por conta que o projeto web será uma distribuíção
	// (um software distribuído, que funcionará em uma Rede de Computadores Distribuído). OBS: O UUID também evita conflitos
	// de existência de um "id existir para mais de um registro". UUID também serve para arquitetura de microservices.
	
	@Column(nullable = false, unique = true, length = 10) // O campo abaixo, não pode ser nulo; não pode ter dois ou mais registros
	// com o mesmo valor e o seu tamanho vale 10, ou seja, a String abaixo tem que ter um tamanho menor ou igual a 10.
	private String parkingSpotNumber; // Número da Vaga de Estacionamento.
	
	@Column(nullable = false, unique = true, length = 7)
	private String licensePlateCar;  // Placa do Carro.
	
	@Column(nullable = false, length = 70)
	private String brandCar;  // Marca do Carro.
	
	@Column(nullable = false, length = 70)
	private String modelCar; // Modelo do Carro.
	
	@Column(nullable = false, length = 70)
	private String colorCar; // Cor do Carro.
	
	@Column(nullable = false)
	private LocalDateTime registrationDate;  // Data do Registro.
	
	@Column(nullable = false, length = 130)
	private String responsibleName; // Nome do Responsável.
	
	@Column(nullable = false, length = 30)
	private String apartment; // Apartamento.
	
	@Column(nullable = false, length = 30)
	private String block; // Bloco.
	
	
	// LOgo Abaixo, teremos os métodos Getters e Setters.
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getParkingSpotNumber() {
		return parkingSpotNumber;
	}

	public void setParkingSpotNumber(String parkingSpotNumber) {
		this.parkingSpotNumber = parkingSpotNumber;
	}

	public String getLicensePlateCar() {
		return licensePlateCar;
	}

	public void setLicensePlateCar(String licensePlateCar) {
		this.licensePlateCar = licensePlateCar;
	}

	public String getBrandCar() {
		return brandCar;
	}

	public void setBrandCar(String brandCar) {
		this.brandCar = brandCar;
	}

	public String getModelCar() {
		return modelCar;
	}

	public void setModelCar(String modelCar) {
		this.modelCar = modelCar;
	}

	public String getColorCar() {
		return colorCar;
	}

	public void setColorCar(String colorCar) {
		this.colorCar = colorCar;
	}

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getResponsibleName() {
		return responsibleName;
	}

	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName;
	}

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
