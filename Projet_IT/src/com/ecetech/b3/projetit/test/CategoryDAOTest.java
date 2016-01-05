package com.ecetech.b3.projetit.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.ecetech.b3.projetit.beans.Category;
import com.ecetech.b3.projetit.dao.CategoryDAO;

public class CategoryDAOTest {

	@Test
	public void test() throws SQLException {
		Category cat = new Category();
		cat.setNameCategory("o");
		cat.setIdCategory(1);
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
