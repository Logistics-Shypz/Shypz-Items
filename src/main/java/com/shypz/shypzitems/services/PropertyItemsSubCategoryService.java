package com.shypz.shypzitems.services;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shypz.shypzitems.DAO.PropertyItemsSubCategoryDAO;
import com.shypz.shypzitems.controllers.PropertyItemsSubCategoryController;
import com.shypz.shypzitems.pojo.Category;
import com.shypz.shypzitems.pojo.Subcategory;

@Service
public class PropertyItemsSubCategoryService {
	
	
	public static final Logger log = LoggerFactory.getLogger(PropertyItemsSubCategoryService.class);
	
	@Autowired
	private PropertyItemsSubCategoryDAO piscdao;

	public boolean addPropertyItemsSubcat(Subcategory pisc) {
		// TODO Auto-generated method stub
		
		
		Subcategory sub_cat_exist = piscdao.findByUserItemSubCategoryName(pisc.getUserItemSubCategoryName());
		if(sub_cat_exist == null){
			System.out.println("In Add Sub Category Items");
			piscdao.save(pisc);
			return false;
			
		}
		else{
			System.out.println("Sub Category Item already exist");
			return true;
		}
		
	}

	public List<Subcategory> getAllItemsSubCat() {
		// TODO Auto-generated method stub
		List<Subcategory> propitemsubcat = new ArrayList<>();
		
		piscdao.findAll()
		.forEach(propitemsubcat::add);
		return propitemsubcat;
	}

	public List<Subcategory> getAllItemsSubCat(long category_id) {
		// TODO Auto-generated method stub
		log.info("In subcat service  2");
		List<Subcategory> propitemsubcat = new ArrayList<>();
		piscdao.findByCategoryUserItemCategoryId(category_id)
		.forEach(propitemsubcat::add);
		return propitemsubcat;
	}

	public boolean updatePropertyItemsSubcat(Subcategory pisc, long subcategory_id) {
		// TODO Auto-generated method stub
		Subcategory subcat = piscdao.findOne(subcategory_id);
		if(subcat == null){
			log.info("Posting a new subcategory object");
			piscdao.save(pisc);
			return false;
		}else{
			log.info("Updating a new subcategory object");
			subcat.setUserItemSubCategoryName(pisc.getUserItemSubCategoryName());
			subcat.setUserItemSubCategoryQuantity(pisc.getUserItemSubCategoryQuantity());
			piscdao.save(subcat);
			return true;
		}
		
	}
	
	

}
