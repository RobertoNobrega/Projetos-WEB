package modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//				Classe da Camada de Dados (Arquitetura MVC)
//					OBS: DAO também é a Camada de Dados

@Entity  // Inserindo a Notação, ao qual indica que a classe Pessoa é uma entidade de um BD Relacional.
public class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id // Esta notação, é para realizar o mapeamento do atributo id da classe para a tabela Pessoa.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Aqui, o id da tabela será criado automaticamente
	// pelo Banco de Dados (toda vez quando for inserir um novo registro na tabela Pessoa).
	
	private Integer id;  // Este atributo será o id de um Registro de uma Pessoa.
	private String nome;
	private int idade;
	private float altura;
	
	public Pessoa(){ }  // Construtor. OBS: Observei que é preciso colocar este construtor assim, para que se possa usar
	// a notação @Entity , caso contrário, vai dar erro aqui.
	
	public Pessoa(Integer id, String nome, int idade, float altura){  // Construtor da Classe Pessoa.
		super(); // Chamando o construtor da classe pai (ou seja, a classe Object).
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.altura = altura;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}
	
}
