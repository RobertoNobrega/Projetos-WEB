package controle;

import modelo.BancoDados;
import modelo.Pessoa;

//			Classe da Camada de Controle (Arquitetura MVC)

public class ControlePrograma{
	
	private BancoDados bd;
	
	public ControlePrograma(){ // Construtor da Classe ControlePrograma.
		if(bd == null)
		   bd = new BancoDados();
	}  
	
	public int cadastrarPessoa(String nome, int idade, float altura){
		return bd.cadastrarRegistroPessoaBD(nome, idade, altura);
	}
	
	public Pessoa consultarRegistroPessoa(int id){
		return bd.consultarRegistroPessoaBD(id);
	}
	
	public Pessoa atualizarRegistroPorCompletoPessoa(Pessoa pessoa){
		return bd.atualizarRegistroPorCompletoPessoaBD(pessoa);
	}
	
	public Pessoa deletarRegistroPessoa(int id){
		return bd.deletarRegistroPessoaBD(id);
	}
	
}
