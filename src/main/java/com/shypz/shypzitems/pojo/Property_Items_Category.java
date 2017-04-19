package com.shypz.shypzitems.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="User_Property_Items_Category",uniqueConstraints = {
		@UniqueConstraint(columnNames = "User_Item_Category_Id"),
		@UniqueConstraint(columnNames = "User_Item_Category_Name")})
public class Property_Items_Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "User_Item_Category_Id")
	private long userItemCategoryId;
	@Column(name="User_Item_Category_Name",unique=true,nullable=false,length=255)
	private String userItemCategoryName;
	@Column(name="User_Item_Category_Description",unique=false,nullable=false,length=500)
	private String userItemCategoryDescription;
	@OneToMany
	private List<Property_Items_SubCategory> propertyItemsSubCategory;
	
	
	
	
	
	public Property_Items_Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Property_Items_Category(long userItemCategoryId, String userItemCategoryName,
			String userItemCategoryDescription) {
		super();
		this.userItemCategoryId = userItemCategoryId;
		this.userItemCategoryName = userItemCategoryName;
		this.userItemCategoryDescription = userItemCategoryDescription;
	}
	
	public long getUserItemCategoryId() {
		return userItemCategoryId;
	}
	public void setUserItemCategoryId(long userItemCategoryId) {
		this.userItemCategoryId = userItemCategoryId;
	}
	public String getUserItemCategoryName() {
		return userItemCategoryName;
	}
	public void setUserItemCategoryName(String userItemCategoryName) {
		this.userItemCategoryName = userItemCategoryName;
	}
	public String getUserItemCategoryDescription() {
		return userItemCategoryDescription;
	}
	public void setUserItemCategoryDescription(String userItemCategoryDescription) {
		this.userItemCategoryDescription = userItemCategoryDescription;
	}

	public List<Property_Items_SubCategory> getPropertyItemsSubCategory() {
		return propertyItemsSubCategory;
	}

	public void setPropertyItemsSubCategory(List<Property_Items_SubCategory> propertyItemsSubCategory) {
		this.propertyItemsSubCategory = propertyItemsSubCategory;
	}
	
	
	
	
	
	
	
	
	

}
