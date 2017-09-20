package com.shypz.shypzitems.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shypz.shypzitems.pojo.Category;
import com.shypz.shypzitems.pojo.Subcategory;


public interface PropertyItemsSubCategoryDAO extends CrudRepository<Subcategory, Long>{
	
	
	public List<Subcategory> findByCategoryUserItemCategoryId(long id);
	public Subcategory findByUserItemSubCategoryName(String sub_category_name);
}