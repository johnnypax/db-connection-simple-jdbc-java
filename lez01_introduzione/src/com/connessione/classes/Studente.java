package com.connessione.classes;

public class Studente{
	
	private int id;
	
	private String nome;
	
	private String cogn;
	
	private String matr;
	
	private int cred;
	
	public Studente() {
		
	}
	
	public Studente(String nome, String cognome) {
		this.nome = nome;
		this.cogn = cognome;
	}
	
	public Studente(int identificatore, String nome, String cognome, String matricola, int crediti) {
		this.id = identificatore;
		this.nome = nome;
		this.cogn = cognome;
		this.matr = matricola;
		this.cred = crediti;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCogn() {
		return cogn;
	}

	public void setCogn(String cogn) {
		this.cogn = cogn;
	}

	public String getMatr() {
		return matr;
	}

	public void setMatr(String matr) {
		this.matr = matr;
	}

	public int getCred() {
		return cred;
	}

	public void setCred(int cred) {
		this.cred = cred;
	}

	@Override
	public String toString() {
		return "Studente [id=" + id + ", nome=" + nome + ", cogn=" + cogn + ", matr=" + matr + ", cred=" + cred + "]";
	}
	
	
	

}
