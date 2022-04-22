package model;

public class Filme {
	
	private String nomeFilme, generoFilme;
	private int anoFilme;
	
	public Filme(){
		
	}
	
	public String getNomeFilme(){
		return this.nomeFilme;
	}
	
	public void setNomeFilme(String nomeFilme){
		this.nomeFilme = nomeFilme;
	}
	
	public String getGeneroFilme(){
		return this.generoFilme;
	}
	
	public void setGeneroFilme(String generoFilme){
		this.generoFilme = generoFilme;
	}
	
	public int getAnoFilme(){
		return this.anoFilme;
	}
	
	public void setAnoFilme(int anoFilme){
		this.anoFilme = anoFilme;
	}
	
}