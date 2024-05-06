package com.ferramenta.classes;

public class Prodotto {

	private int id;
	private String nome;
	private String desc;
	private int quan;
	private float prez;
	
	public Prodotto() {
		
	}
	
	public Prodotto(String varNome, String varDesc) {
		this.nome = varNome;
		this.desc = varDesc;
	}
	
	public Prodotto(String varNome, String varDesc, int varQuan, float varPrez) {
		this.nome = varNome;
		this.desc = varDesc;
		this.quan = varQuan;
		this.prez = varPrez;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getQuan() {
		return quan;
	}

	public void setQuan(int quan) {
		this.quan = quan;
	}

	public float getPrez() {
		return prez;
	}

	public void setPrez(float prez) {
		this.prez = prez;
	}

	@Override
	public String toString() {
		return "Prodotto [id=" + id + ", nome=" + nome + ", desc=" + desc + ", quan=" + quan + ", prez=" + prez + "]";
	}
}
