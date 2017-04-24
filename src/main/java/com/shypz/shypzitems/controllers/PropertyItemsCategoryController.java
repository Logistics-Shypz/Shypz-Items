package com.shypz.shypzitems.controllers;

import java.util.List;

import javax.ws.rs.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shypz.shypzitems.pojo.Category;
import com.shypz.shypzitems.services.PropertyItemsCategoryService;


@RestController
public class PropertyItemsCategoryController {
	
	public static final Logger log = LoggerFactory.getLogger(PropertyItemsCategoryController.class);
	
	
	@Autowired
	private PropertyItemsCategoryService propertyItemsCategoryService;
	
	@RequestMapping("/items")
	public List<Category> getAllItems(){
		
		return propertyItemsCategoryService.getAllItems();
	}
	
	@RequestMapping("/items/id/{itemid}")
	public Category getItemById(@PathVariable long itemid){
		
		Category pic = propertyItemsCategoryService.getItemById(itemid);
		return pic;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/items")
	public void addPropertyItemsCategory(@RequestBody Category  pic){
		
		log.info(pic.getUserItemCategoryName() + " " + pic.getUserItemCategoryDescription());
		propertyItemsCategoryService.addPropertyItemsCategory(pic);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/items/id/{itemid}")
	public void updatePropertyItemsCategory(@RequestBody Category pic, @PathVariable long itemid){
		log.info(pic.getUserItemCategoryDescription() + " " + pic.getUserItemCategoryName());
		propertyItemsCategoryService.updateItemById(pic,itemid);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/items/id/{itemid}")
	public void deletePropertyItemsCategory(@PathVariable long itemid){
		
		propertyItemsCategoryService.deleteItemById(itemid);
		
	}

}
