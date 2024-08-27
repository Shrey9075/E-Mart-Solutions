package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Category;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.managers.*;

@Service
public class CategoryServiceImpl implements CategoryService
{
	@Autowired
	private CategoryRepository categoryRepository;

	//delete
	@Override
	public void deleteCategory(int categoryId) 
	{
		Category c=categoryRepository.findById(categoryId).get();
		if(c!=null) {
			categoryRepository.delete(c);
		}	
	}

	//update
    @Override
    public Category updateCategory(int categoryId, Category updatedCategory) {
        Category existingCategory = categoryRepository.findById(categoryId).orElse(null);

        if (existingCategory != null) {
            
            existingCategory.setCategoryName(updatedCategory.getCategoryName());
            existingCategory.setchildflag(updatedCategory.getchildflag());
            existingCategory.setParentCatID(updatedCategory.getParentCatID());
            existingCategory.setCatImgPath(updatedCategory.getCatImgPath()); 
            return categoryRepository.save(existingCategory);
        }

        return null; 
    }

    //insert
	@Override
	public Category addCategory(Category category) {
		
		return categoryRepository.save(category);
	}

	//getbyID
	@Override
	public Category getCategoryById(int categoryId) {
		
		return categoryRepository.findById(categoryId).get();
	}

	//GetAll
	@Override
	public List<Category> getAllCategorys() 
	{
		return categoryRepository.findAll();
		
	}
	
	public List<Category> getCategoriesByCategoryName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }
	
	@Override
	public List<Category> findByParentCatID(int id) {
		// TODO Auto-generated method stub
		return categoryRepository.findByParentCatID(id);
	}

}
