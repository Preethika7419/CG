package com.cg.Evehicle.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


import org.hibernate.annotations.CreationTimestamp;



//import javax.validation.constraints.Size;

@Entity
@Table(name = "bookingtable")
public class Book {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(length=5,name="Order_Id")
		private Integer orderId;
		

		@NotNull(message="Enter name")
		//@Size(min=5,message="Enter a valid name")
	 	@Column(length =20,name="uname")
		private String uname;
		
		@NotNull(message="Enter emailId")
		@Email(message="Enter a valid email")
		@Column(length =50,name="email")
		private String email;
		
		@NotNull(message="Enter  mobile number")
		//@Size(min=10,message="Enter a valid mobile number")
		@Column(length =10,name="contact")
		private Long contact;
		
		@NotNull(message="Enter the address")
		@Column(length =120,name="address")
		private String address;
		
		@NotNull(message="Enter quantity")
		@Column(length=3,name="quantity")
		private Integer quantity;
		
		@CreationTimestamp
		@Column(name="Created_DateTime")
		private LocalDateTime CreatedOn;
		@Column(name="deliverystatus")
		private String deliverystatus;
		
//		@OneToOne(fetch=FetchType.LAZY)
//		@PrimaryKeyJoinColumn
//		private Vehicle vehicle;
		
//		@OneToMany
//	    @MapsId
//	    @JoinColumn(name = "Vehicle_id")
//	    private Vehicle vehicle;
		
		
		
		public String getDeliverystatus() {
			return deliverystatus;
		}


		public void setDeliverystatus(String deliverystatus) {
			this.deliverystatus = deliverystatus;
		}


		public LocalDateTime getCreatedOn() {
			return CreatedOn;
		}


		public void setCreatedOn(LocalDateTime createdOn) {
			CreatedOn = createdOn;
		}


		@ManyToOne
		@JoinColumn(name="Vehicle_Id")
		private Vehicle vehicle;
		
		
		public Vehicle getVehicle() {
			return vehicle;
		}


		public void setVehicle(Vehicle vehicle) {
			this.vehicle = vehicle;
		}


//		public Book() {
//			super();
//			}
//
//
//		public Book(Integer orderId,Integer vehicleId, String customerName, String emailId, Long mobileNo,
//				String address, Integer quantity) {
//			super();
//			this.orderId = orderId;
//			this.vehicleId = vehicleId;
//			this.customerName = customerName;
//			this.emailId = emailId;
//			this.mobileNo = mobileNo;
//			this.address = address;
//			this.quantity = quantity;
//		}


		public Integer getOrderId() {
			return orderId;
		}


		public void setOrderId(Integer orderId) {
			this.orderId = orderId;
		}


//		public Integer getVehicleId() {
//			return vehicleId;
//		}
//
//
//		public void setVehicleId(Integer vehicleId) {
//			this.vehicleId = vehicleId;
//		}



		public String getAddress() {
			return address;
		}


		public String getUname() {
			return uname;
		}


		public void setUname(String uname) {
			this.uname = uname;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public Long getContact() {
			return contact;
		}


		public void setContact(Long contact) {
			this.contact = contact;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		public Integer getQuantity() {
			return quantity;
		}


		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		
		
		public String Message()
		{
			return "success";
		}




		


		
		
		
		
		

}
