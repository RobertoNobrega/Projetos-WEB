package com.api.parkingcontrol.configs;

import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

// Classe foi criada e explicada pela própria Michelli.

@Configuration   // Estereótipo do Spring. Ao usar esta notação, indica que a classe será
// de configuração do Spring.
public class DateConfig {
	// Configurações Customizadas. Quando a aplicação estiver online, deverá levar em conta
	// também essas configurações.
	
	// Criando uma Formatação Global para Datas, usando o Padrão ISO 8601 UTC.
	
	public static final String DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"; // y é o ano. M é o mês. d é o dia. H é hora. m é minuto e s é o segundo.
	// A letra T é um padrão, mas a letra Z indica que está no formato de UTC.
	
	public static LocalDateTimeSerializer LOCAL_DATETIME_SERIALIZER = new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATETIME_FORMAT));
	
	@Bean  // Estereótipo do Spring. Indica que o método abaixo é um produtor.
	@Primary // Estereótipo do Spring. Indica prioridade, caso haja outros beans do Spring para Object Mapper. 
	public ObjectMapper objectMapper() {
		JavaTimeModule module = new JavaTimeModule();
		module.addSerializer(LOCAL_DATETIME_SERIALIZER); // Serializando a data, com o JavaTimeModule, para que seja "mapeado" no Object Mapper,
		// pois, por padrão do Spring, quando ele trabalha com serializações, ele usa do ObjectMapper, para poder definir essa data.
		return new ObjectMapper().registerModule(module);
	}
}
