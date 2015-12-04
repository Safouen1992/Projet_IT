package com.ecetech.b3.projetit.beans;

public class Category {
	private int idCategory;
	private String nomCategory;

	/**
	 * builders J'ai changé ça
	 */
	public Category(int idCategory, String nomCategory) {
		super();
		this.idCategory = idCategory;
		this.nomCategory = nomCategory;
	}

	public Category() {
		this(0, null);
	}

	/**
	 * getters & setters
	 */
	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getNomCategory() {
		return nomCategory;
	}

	public void setNomCategory(String nomCategory) {
		this.nomCategory = nomCategory;
	}
}
