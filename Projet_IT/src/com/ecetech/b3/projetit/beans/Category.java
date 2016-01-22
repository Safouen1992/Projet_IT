package com.ecetech.b3.projetit.beans;

public class Category {
	
	/**
	 * Attributes
	 */
	private int idCategory;
	private String nameCategory;

	/**
	 * 
	 * @return The id of a Category
	 */
	public int getIdCategory() {
		return idCategory;
	}
	/**
	 * 
	 * @param idCategory The id of a Category
	 */
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	/**
	 * 
	 * @return The name of a Category
	 */
	public String getNameCategory() {
		return nameCategory;
	}
	/**
	 * 
	 * @param nameCategory The name of a Category
	 */
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	
	/**
	 * Constructor
	 * @param idCategory
	 * 		The id of the Category
	 * @param nameCategory
	 * 		The name of the Category
	 */
	public Category(int idCategory, String nameCategory) {
		super();
		this.idCategory = idCategory;
		this.nameCategory = nameCategory;
	}
	/**
	 * Constructor null
	 */
	public Category() {
		this(0, null);
	}
	
	/**
	 * Display the attributes of a Category
	 */
	public void display() {
		System.out.println("idCategory: " + this.idCategory + ", nameCategory: " + this.nameCategory);
	}
	
}
