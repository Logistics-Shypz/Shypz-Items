package com.shypz.shypzitems.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="User_Property_Items_Subcategory",uniqueConstraints = {
		@UniqueConstraint(columnNames = "User_Item_SubCategory_Id"),
		@UniqueConstraint(columnNames = "User_Item_SubCategory_Name")})
public class Property_Items_SubCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="User_Item_Subcategory_Id")
	private long userItemSubCategoryId;
	
	@Column(name="User_Item_Subcategory_Name",unique=true,nullable=false,length=255)
	private String userItemSubCategoryName;
	
	@Column(name="User_Item_Subcategory_Quantity",unique=false,nullable=false,length=10)
	private int userItemSubCategoryQuantity;
	
	@ManyToOne
	private Property_Items_Category items_category;
	

	public Property_Items_SubCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Property_Items_SubCategory(long userItemSubCategoryId, String userItemSubCategoryName,
			int userItemSubCategoryQuantity, Property_Items_Category items_category) {
		super();
		this.userItemSubCategoryId = userItemSubCategoryId;
		this.userItemSubCategoryName = userItemSubCategoryName;
		this.userItemSubCategoryQuantity = userItemSubCategoryQuantity;
		this.items_category = items_category;
	}

	public long getUserItemSubCategoryId() {
		return userItemSubCategoryId;
	}

	public void setUserItemSubCategoryId(long userItemSubCategoryId) {
		this.userItemSubCategoryId = userItemSubCategoryId;
	}

	public String getUserItemSubCategoryName() {
		return userItemSubCategoryName;
	}

	public void setUserItemSubCategoryName(String userItemSubCategoryName) {
		this.userItemSubCategoryName = userItemSubCategoryName;
	}

	public int getUserItemSubCategoryQuantity() {
		return userItemSubCategoryQuantity;
	}

	public void setUserItemSubCategoryQuantity(int userItemSubCategoryQuantity) {
		this.userItemSubCategoryQuantity = userItemSubCategoryQuantity;
	}

	public Property_Items_Category getItems_category() {
		return items_category;
	}

	public void setItems_category(Property_Items_Category items_category) {
		this.items_category = items_category;
	}
	
	

}
