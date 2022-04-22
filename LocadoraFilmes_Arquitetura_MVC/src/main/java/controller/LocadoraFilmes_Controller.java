package controller;
import model.LocadoraFilmes_Model;

public class LocadoraFilmes_Controller {
	
	private LocadoraFilmes_Model dadosLocadoraFilmes;   // Atributo.
	
	public LocadoraFilmes_Controller(){  // Construtor da Classe LocadoraFilmes_Controller.
		
	}
	
	public String cadastrarFilme(String nomeFilme, int anoFilme, String generoFilme){
		dadosLocadoraFilmes = new LocadoraFilmes_Model();
		return dadosLocadoraFilmes.registrarFilme(nomeFilme, anoFilme, generoFilme); 
	}
	
}