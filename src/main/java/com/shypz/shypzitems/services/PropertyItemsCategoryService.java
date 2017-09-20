package com.shypz.shypzitems.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shypz.shypzitems.DAO.PropertyItemsCategoryDAO;
import com.shypz.shypzitems.pojo.Category;



@Service
public class PropertyItemsCategoryService {
	
	@Autowired
	private PropertyItemsCategoryDAO propitemcatdao;

	public boolean addPropertyItemsCategory(Category pic) {
		// TODO Auto-generated method stub
		
		Category cat_exist = propitemcatdao.findByUserItemCategoryName(pic.getUserItemCategoryName());
		if(cat_exist == null){
			System.out.println("In Add Items");
			propitemcatdao.save(pic);
			return false;
			
		}
		else{
			System.out.println("Item Category already exist");
			return true;
		}
		
	}

	public List<Category> getAllItems() {
		// TODO Auto-generated method stub
		List<Category> propitemcat = new ArrayList<>();
		propitemcatdao.findAll()
		.forEach(propitemcat::add);
		return propitemcat;
	}

	public Category getItemById(long itemid) {
		// TODO Auto-generated method stub
		return propitemcatdao.findOne(itemid);
	}

	public boolean updateItemById(Category pic, long itemid) {
		// TODO Auto-generated method stub
		
		Category p = propitemcatdao.findOne(itemid);
		if(p == null){
			System.out.println("In save");
			propitemcatdao.save(pic);
			return false;
		}
		else{
			System.out.println("In update");
			p.setUserItemCategoryName(pic.getUserItemCategoryName());
			p.setUserItemCategoryDescription(pic.getUserItemCategoryDescription());
			propitemcatdao.save(p);
			return true;
		}
		
	}

	public boolean deleteItemById(long itemid) {
		// TODO Auto-generated method stub
		
		Category items_cat = propitemcatdao.findOne(itemid);
		if(items_cat == null){
			return false;
		}else{
			propitemcatdao.delete(itemid);
			return true;
		}
		
		
	}

}
