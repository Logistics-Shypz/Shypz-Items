package com.shypz.shypzitems.services;

import org.springframework.stereotype.Service;

import com.shypz.shypzitems.DAO.PropertyItemsCategoryDAO;
import com.shypz.shypzitems.pojo.Property_Items_Category;

@Service
public class PropertyItemsCategoryService {
	
	
	private PropertyItemsCategoryDAO propitemcatdao;

	public void addPropertyItemsCategory(Property_Items_Category pic) {
		// TODO Auto-generated method stub
		propitemcatdao.save(pic);
	}

}
