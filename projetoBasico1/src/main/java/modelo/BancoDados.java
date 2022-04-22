package modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Pessoa;

//				Classe da Camada de Dados (Arquitetura MVC)
//				  OBS: DAO também é a Camada de Dados

public class BancoDados{
	
	public int cadastrarRegistroPessoaBD(String nome, int idade, float altura){
		Pessoa pessoa = new Pessoa(null, nome, idade, altura);
		//System.out.println(nome + "  " + idade + "  " + altura);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo_aplicacao_jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();  // Iniciando uma Transação no Banco de Dados.
		em.persist(pessoa); // Inserindo um registro no Banco de Dados.
		em.getTransaction().commit();  // Confirmando as operações feitas acima, para
		// poder inserir um registro no Banco de Dados.
		em.close();  // Fechando o EntityManager.
		emf.close(); // Fechando o EntityManagerFactory.
		return 1;
	}
	
	public Pessoa consultarRegistroPessoaBD(int id){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo_aplicacao_jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Pessoa pessoa = em.find(Pessoa.class, id); // Aqui, está realizando uma busca pelo registro da tabela
		// Pessoa, ao qual possui um valor de identificador "consultado pelo usuário do programa".
		em.getTransaction().commit();
		em.close();
		emf.close();
		return pessoa;
	}
	
	public Pessoa atualizarRegistroPorCompletoPessoaBD(Pessoa pessoa){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo_aplicacao_jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(pessoa);  // Atualizando o registro de uma pessoa específica, na tabela Pessoa, por meio de seu id. OBS: Caso
		// o id seja inválido, então vai ser criado um novo registro na tabela Pessoa.
		em.getTransaction().commit();
		em.close();
		emf.close();
		return pessoa;
	}
	
	public Pessoa deletarRegistroPessoaBD(int id){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo_aplicacao_jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Pessoa pessoa = em.find(Pessoa.class, id);  // Obtendo o registro Pessoa encontrado no BD.
		em.remove(pessoa); // Removendo o Registro Encontrado da Tabela Pessoa.
		em.getTransaction().commit();
		em.close();
		emf.close();
		return pessoa;
	}
	
}
