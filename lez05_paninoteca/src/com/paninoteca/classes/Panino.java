package com.paninoteca.classes;

public class Panino {
	
	private int id;
	private String nome;
	private String codi;
	private String desc;
	private float prez;
	private boolean vegan;
	
	public Panino() {
		
	}
	
	public Panino(String nome, String codi, String desc, float prez, boolean vegan) {
		this.nome = nome;
		this.codi = codi;
		this.desc = desc;
		this.prez = prez;
		this.vegan = vegan;
	}
	
	public Panino(int id, String nome, String codi, String desc, float prez, boolean vegan) {
		this.id = id;
		this.nome = nome;
		this.codi = codi;
		this.desc = desc;
		this.prez = prez;
		this.vegan = vegan;
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
	public String getCodi() {
		return codi;
	}
	public void setCodi(String codi) {
		this.codi = codi;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public float getPrez() {
		return prez;
	}
	public void setPrez(float prez) {
		this.prez = prez;
	}
	public boolean isVegan() {
		return vegan;
	}
	public void setVegan(boolean vegan) {
		this.vegan = vegan;
	}
	
	@Override
	public String toString() {
		return "Panino [id=" + id + ", nome=" + nome + ", codi=" + codi + ", desc=" + desc + ", prez=" + prez
				+ ", vegan=" + vegan + "]";
	}	
	
	public String stampaDettaglio() {
		return "Nome: " + nome + "\n"
				+ "Descrizione: " + desc  + "\n"
				+ "Vegano: " + (vegan ? "SI" : "NO")  + "\n";
	}
	
}
