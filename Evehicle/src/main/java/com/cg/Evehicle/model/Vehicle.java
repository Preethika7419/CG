package com.cg.Evehicle.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;





@Entity
@Table(name = "Vehicle")
@SQLDelete(sql = "UPDATE Vehicle SET Flag=true WHERE vehicle_id=?")
//@Where(clause = "deleted = false")
@FilterDef(
		name = "deletedEmployeeFilter",
		parameters = @ParamDef(name = "isFlag", type = "boolean")
		)
@Filter(
		name = "deletedEmployeeFilter",
		condition = "Flag = :isFlag"
		)
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(length=50,name="Vehicle_Id")
	private Integer vehicleId;
	@Column(length=50,name="category")
	private String category;
	@Column(length =20,name="Dealer_Name")
	private String dealerName;
	
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="dealerName")
//	private Employee dealerName;
	
	@Column(length =50,name="Vehicle_Name")
	private String vehicleName;
	@Column(length =50,name="Model_Name")
	private String modelName;
	@Column(length =4,name="YearOfManu")
	private Integer yearOfManu;
	@Column(length =20,name="Color")
	private String color;
	@Column(length=10,name="Warranty")
	private Integer warranty;
	@Column(length =20,name="Price")
	private Integer price;
	@Column(length =15,name="Quantity")
	private Integer quantity;
//	@Column(length =1,name="Flag")
//	private String flag;
	private boolean Flag;
	@Column(name="image")
	private String image;
	
	
	public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}
	
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy ="vehicle")
//	private Book book;
//	@OneToOne(mappedBy="vehicle",cascade = CascadeType.ALL)
//	@PrimaryKeyJoinColumn
//	private Book book;
	
//	public Vehicle() {
//		super();
//		
//	}
//
//
//	public Vehicle(Integer vehicleId, String category, String dealerName, String vehicleName, String modelName,
//			 Integer yearOfManu,String color, Integer warranty, Integer price, Integer quantity,String flag) {
//		super();
//		this.vehicleId = vehicleId;
//		this.category = category;
//		this.dealerName = dealerName;
//		this.vehicleName = vehicleName;
//		this.modelName = modelName;
//		this.yearOfManu = yearOfManu;
//		this.color = color;
//		this.warranty = warranty;
//		this.price = price;
//		this.quantity = quantity;
//		this.flag=flag;
//	}

	public boolean isFlag() {
		return Flag;
	}

	public void setFlag(boolean flag) {
		Flag = flag;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

//	public String getDealer() {
//		return dealerName;
//	}
//
//	public void setDealer(String dealerName) {
//		this.dealerName = dealerName;
//	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public Integer getYearOfManu() {
		return yearOfManu;
	}


	public void setYearOfManu(Integer yearOfManu) {
		this.yearOfManu = yearOfManu;
	}

	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getWarranty() {
		return warranty;
	}

	public void setWarranty(Integer warranty) {
		this.warranty = warranty;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
//	public String getFlag() {
//		return flag;
//	}
//
//
//	public void setFlag(String flag) {
//		this.flag = flag;
//	}


//	public Vehicle get() {
//		// TODO Auto-generated method stub
//		return null;
//	}


//	public Vehicle get() {
//		// TODO Auto-generated method stub
//		return null;
//	}


	
	

}