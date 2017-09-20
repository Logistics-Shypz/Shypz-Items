package com.shypz.shypzitems.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Path;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shypz.shypzitems.pojo.Category;
import com.shypz.shypzitems.pojo.Subcategory;
import com.shypz.shypzitems.services.PropertyItemsCategoryService;
import com.shypz.shypzitems.services.PropertyItemsSubCategoryService;

@CrossOrigin(origins="*")
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
	public ResponseEntity<JSONObject> getItemById(@PathVariable long itemid){
		
		log.info("List of items : " + itemid);
		Category pic = propertyItemsCategoryService.getItemById(itemid);
		List<Subcategory> subcat = new ArrayList<>();
		subcat = propertyItemsSubCategoryService.getAllItemsSubCat(itemid);
		
		JSONObject iobj = new JSONObject();
		
		if(pic == null){
			iobj.put("code", 0);
			String msg = "Items with id " + itemid + "Not found";
			iobj.put("message", msg);
			iobj.put("Items", pic);
			return new ResponseEntity<JSONObject>(iobj,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else{
			pic.setPropertyItemsSubCategory(subcat);
			iobj.put("code", 1);
			iobj.put("message", "Items found");
			iobj.put("Items", pic);
			return new ResponseEntity<JSONObject>(iobj,HttpStatus.OK);
		}
		
		
		
		
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/items")
	public ResponseEntity<JSONObject> addPropertyItemsCategory(@RequestBody Category  pic){
		
		log.info(pic.getUserItemCategoryName() + " " + pic.getUserItemCategoryDescription());
		
		
		JSONObject iobj = new JSONObject();
		
		
		if(pic != null){
			boolean b = propertyItemsCategoryService.addPropertyItemsCategory(pic);
			if(!b){
				iobj.put("success_code", 1);
				iobj.put("message", "Items Category Added Successfully");
				return new ResponseEntity<JSONObject>(iobj,HttpStatus.OK);
			}else{
				iobj.put("success_code", 2);
				iobj.put("message", "Items Category Already Exisits in Database");
				return new ResponseEntity<JSONObject>(iobj,HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			
			
		}else{
			iobj.put("success_code", 0);
			iobj.put("message", "Unable to add item category successfully");
			return new ResponseEntity<JSONObject>(iobj,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/items/id/{itemid}")
	public ResponseEntity<JSONObject> updatePropertyItemsCategory(@RequestBody Category pic, @PathVariable long itemid){
		log.info(pic.getUserItemCategoryDescription() + " " + pic.getUserItemCategoryName());
		boolean item_cat_update_res = propertyItemsCategoryService.updateItemById(pic, itemid);
		 JSONObject iobj = new JSONObject();
		 if(!item_cat_update_res){
			 iobj.put("success_code", 1);
			 iobj.put("message", "Items Category Added as it didn't existed");
			 return new ResponseEntity<JSONObject>(iobj,HttpStatus.OK);
		 }else{
			 iobj.put("success_code", 2);
			 iobj.put("message", "Items Category Updated Successfully");
			 return new ResponseEntity<JSONObject>(iobj,HttpStatus.OK);
		 }
		
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/items/id/{itemid}")
	public ResponseEntity<JSONObject> deletePropertyItemsCategory(@PathVariable long itemid){
		
		boolean item_cat_delete_res = propertyItemsCategoryService.deleteItemById(itemid);
		JSONObject iobj = new JSONObject();
		if(item_cat_delete_res){
			 iobj.put("success_code", 1);
			 iobj.put("message", "Items Category Deleted Successfully");
			 return new ResponseEntity<JSONObject>(iobj,HttpStatus.OK);
		}else{
			iobj.put("success_code", 0);
			iobj.put("message", "Unable to delete item category as it doesn't exist");
			return new ResponseEntity<JSONObject>(iobj,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
