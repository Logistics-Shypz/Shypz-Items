package com.shypz.shypzitems.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shypz.shypzitems.pojo.Property_Items_Category;
import com.shypz.shypzitems.services.PropertyItemsCategoryService;


@RestController
public class PropertyItemsCategoryController {
	
	public static final Logger log = LoggerFactory.getLogger(PropertyItemsCategoryController.class);
	
	
	@Autowired
	private PropertyItemsCategoryService propertyItemsCategoryService;
	
	
	public List<Property_Items_Category> getAllItems(){
		
		return null;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/propitemcat")
	public void addPropertyItemsCategory(@RequestBody Property_Items_Category  pic){
		
		propertyItemsCategoryService.addPropertyItemsCategory(pic);
		
	}
	
	public void updatePropertyItemsCategory(){
		
	}
	
	
	public void deletePropertyItemsCategory(){
		
	}

}
