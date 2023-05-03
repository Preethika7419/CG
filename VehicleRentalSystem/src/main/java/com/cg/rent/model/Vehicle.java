package com.cg.rent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Vehicle class is POJO class.
 * @author 15BW089AX
 *
 */

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int vId;
	private String vNumber;
	private String vBrand;
	private String vType;
	private String image;
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getVId() {
		return vId;
	}
	public void setVId(int vId) {
		this.vId = vId;
	}
	public String getVNumber() {
		return vNumber;
	}
	public void setVNumber(String vNumber) {
		this.vNumber = vNumber;
	}
	public String getVbrand() {
		return vBrand;
	}
	public void setVbrand(String vbrand) {
		vBrand = vbrand;
	}
	public String getVType() {
		return vType;
	}
	public void setVType(String vType) {
		this.vType = vType;
	}
	
	public String toString()
	{
		return vId+"\t"+vNumber+"\t"+vBrand+"\t"+vType;
		
	}

}
