package net.kzn.ShoppingBackend.dao;

import java.util.List;

import net.kzn.ShoppingBackend.dto.Category;

public interface CategoryDAO {

	 List<Category> list();
	 Category get(int id);
	 
	
}
