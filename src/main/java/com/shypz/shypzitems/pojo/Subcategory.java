package com.shypz.shypzitems.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="User_Property_Items_Subcategory",uniqueConstraints = {
		@UniqueConstraint(columnNames = "User_Item_SubCategory_Id"),
		@UniqueConstraint(columnNames = "User_Item_SubCategory_Name")})
public class Subcategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="User_Item_Subcategory_Id")
	private long userItemSubCategoryId;
	
	@Column(name="User_Item_Subcategory_Name",unique=true,nullable=false,length=255)
	private String userItemSubCategoryName;
	
	@Column(name="User_Item_Subcategory_Quantity",unique=false,nullable=false,length=10)
	private int userItemSubCategoryQuantity;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private Category category;
	

	public Subcategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subcategory(long userItemSubCategoryId, String userItemSubCategoryName,
			int userItemSubCategoryQuantity, Category category) {
		super();
		this.userItemSubCategoryId = userItemSubCategoryId;
		this.userItemSubCategoryName = userItemSubCategoryName;
		this.userItemSubCategoryQuantity = userItemSubCategoryQuantity;
		this.category = category;
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

	public Category getcategory() {
		return category;
	}

	public void setcategory(Category category) {
		this.category = category;
	}
	
	

}
