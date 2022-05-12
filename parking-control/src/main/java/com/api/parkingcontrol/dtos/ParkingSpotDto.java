package com.api.parkingcontrol.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/*
 *      				Data Transfer Object (DTO)
 *      Um simples objeto, que é utilizado para transferência de dados de um local
 *      para outro na aplicação, sem usar Lógica de Negócios. Associado em transferir
 *      dados entre camada de visão (view layer) e outra de persistência de dados (model layer).
 *      
 *         OBS: BO, DTO, VO, POJO e PO são padrões de projeto.
 */

// A classe ParkingSpotDto, será usada para gravar dados no Banco de Dados. Portanto, a requisição
// para esta finalidade é do Método POST.

public class ParkingSpotDto {
	
	// Nesta classe, não precisará dos seguintes atributos: id (id será criado automaticamente), registrationDate (nesse caso,
	// será criado pelo programador essa data, não o cliente)
	
	
	// OBS: Logo abaixo, temos validações para os atributos desta classe, usando as anotações do Spring Validation.
	
	// OBS: Existe anotações personalizadas, com o uso de 'constraints' personalizados (dependendo da Regra de Negócio e do Campo
	// a ser validado).
	
	@NotBlank   // Esta notação é para informar que o campo não pode ser vazio ou nulo.
	private String parkingSpotNumber;
	
	@NotBlank
	@Size(max = 7) // Aqui, indica que o tamanho máximo de licensePlateCar é 7.
	private String licensePlateCar;
	
	@NotBlank
	private String brandCar;
	
	@NotBlank
	private String modelCar;
	
	@NotBlank
	private String colorCar;
	
	@NotBlank
	private String responsibleName;
	
	@NotBlank
	private String apartment;
	
	@NotBlank
	private String block;
	
	// Logo Abaixo, temos os Métodos Getters e Setters.
	
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
		
}