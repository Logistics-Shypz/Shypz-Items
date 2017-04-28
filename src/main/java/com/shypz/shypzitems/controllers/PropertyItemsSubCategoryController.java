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
import com.shypz.shypzitems.pojo.Subcategory;
import com.shypz.shypzitems.services.PropertyItemsCategoryService;
import com.shypz.shypzitems.services.PropertyItemsSubCategoryService;

@RestController
public class PropertyItemsSubCategoryController {
	
	public static final Logger log = LoggerFactory.getLogger(PropertyItemsSubCategoryController.class);
	
	@Autowired
	private PropertyItemsSubCategoryService propertyItemsSubCategoryService;
	
	@Autowired
	private PropertyItemsCategoryService propertyItemsCategoryService;

	@RequestMapping("/items/subcat")
	public List<Subcategory> getAllItemsSubCat(){
		
		return propertyItemsSubCategoryService.getAllItemsSubCat();
		
	}
	
	
	@RequestMapping("/items/catid/{category_id}/subcat")
	public List<Subcategory> getAllItemsSubCat(@PathVariable long category_id){
		log.info("In categor id controller");
		return propertyItemsSubCategoryService.getAllItemsSubCat(category_id);
		
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/items/catid/{category_id}/subcat")
	public void addPropertyItemsSubcat(@RequestBody Subcategory pisc,@PathVariable long category_id){
		
		Category pic = propertyItemsCategoryService.getItemById(category_id);
		
		pisc.setcategory(pic);
		propertyItemsSubCategoryService.addPropertyItemsSubcat(pisc);
		
		
		
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/items/catid/{category_id}/subcat/{subcategory_id}")
	public void updatePropertyItemsSubcat(@RequestBody Subcategory pisc,@PathVariable long category_id,@PathVariable long subcategory_id){
		
		Category cat = propertyItemsCategoryService.getItemById(category_id);
		pisc.setcategory(cat);
		
		propertyItemsSubCategoryService.updatePropertyItemsSubcat(pisc,subcategory_id);
		
	}
	
}
