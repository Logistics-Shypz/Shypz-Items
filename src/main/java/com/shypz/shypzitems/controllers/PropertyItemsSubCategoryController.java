package com.shypz.shypzitems.controllers;

import java.util.List;

import javax.ws.rs.Path;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<JSONObject> addPropertyItemsSubcat(@RequestBody Subcategory pisc,@PathVariable long category_id){
		
		Category pic = propertyItemsCategoryService.getItemById(category_id);
		
		JSONObject items_sub_cat_obj = new JSONObject();
		
		if(pic == null){
			
			items_sub_cat_obj.put("success_code", 0);
			items_sub_cat_obj.put("message", "Unable to add subcategory item as category doesn't exist");
			return new ResponseEntity<JSONObject>(items_sub_cat_obj,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}else{
			
			if(pisc != null){
				pisc.setcategory(pic);
				
				boolean b = propertyItemsSubCategoryService.addPropertyItemsSubcat(pisc);
				if(!b){
					items_sub_cat_obj.put("success_code", 1);
					items_sub_cat_obj.put("message", "Sub Category Item Added Successfully");
					return new ResponseEntity<JSONObject>(items_sub_cat_obj,HttpStatus.OK);
				}else{
					items_sub_cat_obj.put("success_code", 2);
					items_sub_cat_obj.put("message", "Sub Category Item Already exists in Database");
					return new ResponseEntity<JSONObject>(items_sub_cat_obj,HttpStatus.INTERNAL_SERVER_ERROR);
				}
				
				
				
			}else{
				items_sub_cat_obj.put("success_code", 3);
				items_sub_cat_obj.put("message", "Unable to add item category successfully");
				return new ResponseEntity<JSONObject>(items_sub_cat_obj,HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
		
		
		
		
		
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/items/catid/{category_id}/subcat/{subcategory_id}")
	public ResponseEntity<JSONObject> updatePropertyItemsSubcat(@RequestBody Subcategory pisc,@PathVariable long category_id,@PathVariable long subcategory_id){
		
		Category cat = propertyItemsCategoryService.getItemById(category_id);
		
		JSONObject items_sub_cat_obj = new JSONObject();
		
		if(cat == null){
			
			items_sub_cat_obj.put("success_code", 0);
			items_sub_cat_obj.put("message", "Unable to update subcategory item as category doesn't exist");
			return new ResponseEntity<JSONObject>(items_sub_cat_obj,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}else{
			
			if(pisc != null){
				pisc.setcategory(cat);
				
				boolean b = propertyItemsSubCategoryService.updatePropertyItemsSubcat(pisc,subcategory_id);
				if(!b){
					items_sub_cat_obj.put("success_code", 1);
					items_sub_cat_obj.put("message", "Sub Category Item Added Successfully as it didn't existed");
					return new ResponseEntity<JSONObject>(items_sub_cat_obj,HttpStatus.OK);
				}else{
					items_sub_cat_obj.put("success_code", 2);
					items_sub_cat_obj.put("message", "Updated Subcategory Item as it existed");
					return new ResponseEntity<JSONObject>(items_sub_cat_obj,HttpStatus.INTERNAL_SERVER_ERROR);
				}
				
				
				
			}else{
				items_sub_cat_obj.put("success_code", 3);
				items_sub_cat_obj.put("message", "Unable to update sub category successfully");
				return new ResponseEntity<JSONObject>(items_sub_cat_obj,HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
		
	}
	
}
