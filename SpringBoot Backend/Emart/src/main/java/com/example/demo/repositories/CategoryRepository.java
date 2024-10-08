package com.example.demo.repositories;
import com.example.demo.entites.Category;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, Integer> 
{
    List<Category> findByCategoryName(String categoryName);
    
    @Query("SELECT c FROM Category c WHERE c.parentCatID = :parentId")
    List<Category> findByParentCatID(@Param("parentId") int parentCatID);

}
