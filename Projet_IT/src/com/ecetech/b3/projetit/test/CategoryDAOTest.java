package com.ecetech.b3.projetit.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.ecetech.b3.projetit.beans.Category;
import com.ecetech.b3.projetit.dao.CategoryDAO;

public class CategoryDAOTest {

	/**
	 * Test getCategory
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testGet() throws SQLException {
		Category cat = new Category();
		CategoryDAO catDAO = new CategoryDAO();
		ArrayList<Category> cats = catDAO.getCategory(cat);
		assertEquals( "Sport" , cats.get(0).getNameCategory());
	}
	
	/**
	 * Test insertCategory
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testInsert() throws SQLException {
		Category cat = new Category();
		cat.setIdCategory(6);
		cat.setNameCategory("Gaming");
		CategoryDAO catDAO = new CategoryDAO();
		int i = catDAO.insertCategory(cat);
		assertEquals( 1 , i);
		catDAO.deleteCategory(6);
	}
	
	
	/**
	 * Test UpdateCategory
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testUpdate() throws SQLException {
		Category cat = new Category();
		cat.setIdCategory(6);
		cat.setNameCategory("Gaming");
		CategoryDAO catDAO = new CategoryDAO();
		catDAO.insertCategory(cat);
		cat.setNameCategory("Jeux de plateaux");
		int i = catDAO.updateCategory(cat);
		assertEquals( 1 , i);
		catDAO.deleteCategory(6);
	}
	
	
	/**
	 * Test deleteCategory
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testDelete() throws SQLException {
		Category cat = new Category();
		cat.setIdCategory(6);
		cat.setNameCategory("Gaming");
		CategoryDAO catDAO = new CategoryDAO();
		catDAO.insertCategory(cat);
		int i = catDAO.deleteCategory(6);
		assertEquals( 1 , i);
	}
	
	
	/**
	 * Test a transaction
	 * 
	 * @throws SQLException
	 */
	@Test
	public void test() throws SQLException {
		Category cat = new Category();
		cat.setNameCategory("o");
		cat.setIdCategory(0);
		CategoryDAO catDAO = new CategoryDAO();
		ArrayList<Category> cats = catDAO.getCategory(cat);
		for(int i=0; i<cats.size(); i++)
			System.out.println(cats.get(i).getNameCategory());
		
		cat.setIdCategory(6);
		cat.setNameCategory("Gaming");
		catDAO.insertCategory(cat);
		cats = catDAO.getAllCategory();
		for(int i=0; i<cats.size(); i++)
			System.out.println(cats.get(i).getNameCategory());
		cat.setNameCategory("Jeux de plateaux");
		catDAO.updateCategory(cat);
		cats = catDAO.getAllCategory();
		for(int i=0; i<cats.size(); i++)
			System.out.println(cats.get(i).getNameCategory());
		catDAO.deleteCategory(cat.getIdCategory());
		cats = catDAO.getAllCategory();
		for(int i=0; i<cats.size(); i++)
			System.out.println(cats.get(i).getNameCategory());
	}

}
