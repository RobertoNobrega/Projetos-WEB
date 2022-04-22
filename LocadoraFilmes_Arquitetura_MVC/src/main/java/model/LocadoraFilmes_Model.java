package model;

public class LocadoraFilmes_Model {
	
	private Filme filmeLocadora;
	
	public LocadoraFilmes_Model(){
		
	}
	
	public String registrarFilme(String nomeFilme, int anoFilme, String generoFilme){
		filmeLocadora = new Filme();
		filmeLocadora.setNomeFilme(nomeFilme);
		filmeLocadora.setAnoFilme(anoFilme);
		filmeLocadora.setGeneroFilme(generoFilme);
		return "Filme " + nomeFilme + " foi Cadastrado com Sucesso.";
	}
	
}
