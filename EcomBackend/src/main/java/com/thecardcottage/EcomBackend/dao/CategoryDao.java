package com.thecardcottage.EcomBackend.dao;

import com.thecardcottage.EcomBackend.model.Category;

import java.util.List;

public interface CategoryDao {
	
	boolean insertCategory(Category category);
	boolean updateCategory(Category category);
	boolean deleteCategory(String catename);
    List<Category> selectAllCategories();
    Category selectOneCategory(String catename);

}
