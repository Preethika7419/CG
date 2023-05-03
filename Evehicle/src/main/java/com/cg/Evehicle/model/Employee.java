package com.cg.Evehicle.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;

@Entity

//defining class name as Table name
@Table(name="Employee")
@SQLDelete(sql = "UPDATE Employee SET deleted=true WHERE employee_id=?")
//@Where(clause = "deleted = false")
@FilterDef(
        name = "deletedEmployeeFilter",
        parameters = @ParamDef(name = "isDeleted", type = "boolean")
)
@Filter(
        name = "deletedEmployeeFilter",
        condition = "deleted = :isDeleted"
)
public class Employee {
 
 	// Defining employee id as primary key
 	@Id
 	@GeneratedValue
 	@Column(name="employee_id")
 	private long employee_id;
 	
 	@NotNull
 	@Size(min=2, message="First Name should have atleast 2 characters")
	@Column(name="first_name")
 	private String first_name;
 	
 	@NotNull
 	@Size(min=2, message="Last Name should have atleast 2 characters")
	@Column(name="last_name")
 	private String last_name;
 	
 	@Email(message = "Email should be valid")
	@Column(name="email_id")
 	private String email_id;
 	
 	//@NotBlank(message="Please enter your Mobile number")
	//@Size(max=10, message="Mobile Number should have maximum 10 number")
	@Column(name="mobile_no")
 	private long mobile_no;
	
 	private Boolean deleted;
 	
 	
 	@CreationTimestamp
	@Column(name="Created_DateTime")
	private LocalDateTime CreatedOn;
 	
 	public LocalDateTime getCreatedOn() {
		return CreatedOn;
	}


	public void setCreatedOn(LocalDateTime createdOn) {
		CreatedOn = createdOn;
	}
	@UpdateTimestamp
	@Column(name="Updated_DateTime")
	private LocalDateTime UpdatedOn;
	

	public LocalDateTime getUpdatedOn() {
		return UpdatedOn;
	}


	public void setUpdatedOn(LocalDateTime updatedOn) {
		UpdatedOn = updatedOn;
	}


	public Employee() {

 	}
 	
	public long getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(long employee_id) {
		this.employee_id=employee_id;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	
	public long getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(long mobile_no) {
		this.mobile_no = mobile_no;
	}
	
	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

}