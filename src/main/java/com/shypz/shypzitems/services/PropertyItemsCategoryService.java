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

	public void addPropertyItemsCategory(Category pic) {
		// TODO Auto-generated method stub
		propitemcatdao.save(pic);
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

	public void updateItemById(Category pic, long itemid) {
		// TODO Auto-generated method stub
		
		Category p = propitemcatdao.findOne(itemid);
		if(p == null){
			System.out.println("In save");
			propitemcatdao.save(pic);
		}
		else{
			System.out.println("In update");
			p.setUserItemCategoryName(pic.getUserItemCategoryName());
			p.setUserItemCategoryDescription(pic.getUserItemCategoryDescription());
			propitemcatdao.save(p);
		}
		
	}

	public void deleteItemById(long itemid) {
		// TODO Auto-generated method stub
		
		propitemcatdao.delete(itemid);
		
	}

}
