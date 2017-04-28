package com.shypz.shypzitems.controllers;

import java.util.ArrayList;
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
public class PropertyItemsCategoryController {
	
	public static final Logger log = LoggerFactory.getLogger(PropertyItemsCategoryController.class);
	
	
	@Autowired
	private PropertyItemsCategoryService propertyItemsCategoryService;
	
	@Autowired
	private PropertyItemsSubCategoryService propertyItemsSubCategoryService;
	
	@RequestMapping("/items")
	public List<Category> getAllItems(){
		//List<Subcategory> subcat = new ArrayList<>();
		List<Category> cat = new ArrayList<>();
		cat = propertyItemsCategoryService.getAllItems();
		//subcat = propertyItemsSubCategoryService.getAllItemsSubCat();
		for(int j=0 ; j<cat.size();j++){
			
			List<Subcategory> s = new ArrayList<>();
			long catid = cat.get(j).getuserItemCategoryId();
			/*for(int i=0;i<subcat.size();i++){
				
				long id = subcat.get(i).getcategory().getuserItemCategoryId();
				if(catid == id){
					s.add(subcat.get(i));
				}
				
				
				
			}*/
			s = propertyItemsSubCategoryService.getAllItemsSubCat(catid);
			
			cat.get(j).setPropertyItemsSubCategory(s);
		}
		return cat;
	}
	
	@RequestMapping("/items/id/{itemid}")
	public Category getItemById(@PathVariable long itemid){
		
		Category pic = propertyItemsCategoryService.getItemById(itemid);
		List<Subcategory> subcat = new ArrayList<>();
		subcat = propertyItemsSubCategoryService.getAllItemsSubCat(itemid);
		pic.setPropertyItemsSubCategory(subcat);
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
