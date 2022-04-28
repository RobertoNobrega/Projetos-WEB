package aplicacao;

import java.util.Scanner;
import javax.swing.JOptionPane;
import controle.ControlePrograma;
import modelo.Pessoa;

//      				Camada de Aplicação (Arquitetura MVC)


// OBS: Pelo que observei, talvez, o servidor TomCat não atende requisições de uma Aplicação Java, que usa
// o Gerenciador de Dependências chamado Maven.
//      Portanto, para que este programa funcione, tem que executar o XAMPP (o servidor web Apache e o MySQL, softwares
//      que já vem no XAMPP).

public class Programa1{
	
	public void executarPrograma(){
		boolean resposta = true;
		System.out.println("\n\tPrograma, usando Java, Hibernate (Ferramenta de ORM), JPA, Maven, MySQL e XAMPP"
		+ "\n-------------------------------------------------------");
		while(resposta){
			resposta = executarMenu();
			if(!resposta)
				break;
		}
	}
	
	public boolean executarMenu(){
		/*
		Integer opcao;
		Scanner inputKeyboard = new Scanner(System.in);  // Entrada de Dados pelo uso do Teclado.
		//limparBuffer(inputKeyboard);
		System.out.print("\n-------------------------------------------------------"
		 + "\n\t Qual operação deseja fazer?\n\n\t   1. Cadastrar uma nova pessoa; \n\t   2. Consultar uma pessoa; "
		 + "\n\t   3. Remover uma pessoa; \n\t   4. Sair do Programa. \n\n\t   Insira aqui o número da operação >> ");
		opcao = inputKeyboard.nextInt();
		//System.out.println("\n\tValor da Opção: " + opcao);
		*/
		String opcao = JOptionPane.showInputDialog("\n\t Qual operação deseja fazer?\n\n\t   1. Cadastrar uma nova pessoa; \n\t   "
		+ "2. Consultar uma pessoa; \n\t   3. Remover uma pessoa; \n\t   4. Atualizar uma pessoa; \n\t   5. Sair do Programa."
		+ "\n\n\t   Insira aqui o número da operação");
		switch(Integer.parseInt(opcao)){
			case 1:
			  inserirPessoa(1);
			  break;
			case 2:
			  consultarPessoa();
			  break;
			case 3:
			  deletarPessoa();
			  break;
			case 4:
			  inserirPessoa(2);  // Para atualizar um registro de Pessoa.
			  break;
			case 5:
			  System.out.println("\n-------------------------------------------------------"
			  + "\n\t    Obrigado pelo uso de nosso programa. Até a Próxima!");
			  //inputKeyboard.close();
			  return false;
			default:
			  System.out.println("\n-------------------------------------------------------"
			  + "\n\t    Operação Inválida. Tente Novamente.");
		}
		//limparBuffer(inputKeyboard);  // Limpando o "Buffer do Teclado". OBS: Para o caso do valor int ou Integer, não deu certo (pelo que
		// percebi).
		//inputKeyboard.close();
		return true;
	}
	
	public void inserirPessoa(int opcao){
		String mensagens[] = {"Insira seu Nome","Insira sua Idade","Insira sua Altura"};
		String nome = "";
		int id = 0, idade = 0;
		float altura = 0;
		//Scanner entradaDadosTeclado = new Scanner(System.in);
		if(opcao == 1)
			System.out.println("\n\tOperação para inserir um registro de Pessoa.\n");
		else{
			System.out.println("\n\tOperação para atualizar um registro de Pessoa.\n");
			id = Integer.parseInt(JOptionPane.showInputDialog("Insira o id correto do registro da pessoa"));
		}
		for(int pos = 0; pos < mensagens.length; ++pos){
			//System.out.print("\n-------------------------------------------------------------" 
		    //+ "\n\n\t" + mensagens[pos]);
			switch(pos){
				case 0:
				  //nome = entradaDadosTeclado.nextLine();  // Lendo uma String, ao qual será o nome fornecido pelo usuário.
				  //entradaDados.nextLine(); // Após a leitura, estamos esvaziando o buffer do teclado, para poder ler
				  // novamente algum dado informado pelo usuário, por meio do teclado.
				  nome = JOptionPane.showInputDialog(mensagens[pos]);
				  break;
				case 1:
				  //idade = entradaDadosTeclado.nextInt(); // Lendo um Valor Inteiro.
				  //entradaDados.nextLine(); // Esvaziando o Buffer do Teclado.
				  idade = Integer.parseInt(JOptionPane.showInputDialog(mensagens[pos]));
				  break;
				case 2:
				  //altura = entradaDadosTeclado.nextFloat();  // OBS: Quando for inserir um valor real no teclado (float ou double),
				  // tem que inserir o valor separado por vírgula (EX: 1,67 ) . Isso é quando usa-se a classe Scanner, mas quando
				  // usar a classe JOptionPane, tem que usar ponto (EX: 1.67)
				  altura = Float.parseFloat(JOptionPane.showInputDialog(mensagens[pos]));
			}
		}
		//System.out.println("\n\tDados Fornecidos da Pessoa: " + nome + " | " + idade + " anos | " + altura);  // OK. Funciona.
		ControlePrograma cp = new ControlePrograma();
		if(opcao == 1)
			cp.cadastrarPessoa(nome, idade, altura);
		else
			cp.atualizarRegistroPorCompletoPessoa(new Pessoa(id, nome, idade, altura));
		//entradaDadosTeclado.close();  // Fechando a Leitura de Dados pelo Teclado.
	}
	
	public void consultarPessoa(){
		int id;
		//Scanner dadoIdTeclado = new Scanner(System.in);
		ControlePrograma cp = new ControlePrograma();
		//System.out.print("\n-------------------------------------------------------------"
		// + "\n\t  Insira o id da pessoa >> ");
		//id = dadoIdTeclado.nextInt();
		System.out.println("\n\tOperação para consultar um registro de Pessoa.\n");
		id = Integer.parseInt(JOptionPane.showInputDialog("Insira o id da pessoa"));
		Pessoa pessoa = cp.consultarRegistroPessoa(id);
		if(pessoa != null){
			System.out.println("\n-------------------------------------------------------------"
			+ "\n\t\tDados da Pessoa\n\tNome: " + pessoa.getNome() + "\n\tIdade: " + pessoa.getIdade()
			+ "\n\tAltura: " + pessoa.getAltura() + "\n-------------------------------------------------------------");
		}else{
			System.out.println("\n-------------------------------------------------------------"
			+ "\n\t Registro de Pessoa Não Existente no Banco de Dados." 
			+ "\n-------------------------------------------------------------");
		}
		//dadoIdTeclado.close();
	}
	
	public void deletarPessoa(){
		int id;
		//Scanner dadoIdTeclado = new Scanner(System.in);
		ControlePrograma cp = new ControlePrograma();
		//System.out.print("\n-------------------------------------------------------------"
		// + "\n\t  Insira o id da pessoa >> ");
		//id = dadoIdTeclado.nextInt();
		System.out.println("\n\tOperação para deletar um registro de Pessoa.\n");
		id = Integer.parseInt(JOptionPane.showInputDialog("Insira o id da pessoa"));
		Pessoa pessoa = cp.deletarRegistroPessoa(id);
		if(pessoa != null){
			System.out.println("\n-------------------------------------------------------------"
			+ "\n\t\tDados da Pessoa deletada no Banco de Dados\n\tNome: " + pessoa.getNome() + "\n\tIdade: "
			+ pessoa.getIdade() + "\n\tAltura: " + pessoa.getAltura()
			+ "\n-------------------------------------------------------------");
		}else{
			System.out.println("\n-------------------------------------------------------------"
			+ "\n\t Registro de Pessoa Não Existente no Banco de Dados."
			+ "\n-------------------------------------------------------------");
		}
		//dadoIdTeclado.close();
	}
	
	public void limparBuffer(Scanner entradaDadosTeclado){
		if(entradaDadosTeclado.hasNextLine())
		   entradaDadosTeclado.nextLine();
	}
	
}
