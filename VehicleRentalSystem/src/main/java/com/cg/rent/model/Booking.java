package com.cg.rent.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * Booking class is POJO class having all booking details.
 * @author 15BW089AX
 *
 */
@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bId;
	@OneToOne
	@JoinColumn(name = "UId_FK")
	private User user;				
	@OneToOne
	@JoinColumn(name = "VId_FK")
	private Vehicle vehicle;
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date toDate;
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date fromDate;
	private int status;
	
	
	public Booking() {
		super();
	}
	public Booking(int bId, User user, Vehicle vehicle, Date toDate, Date fromDate, int status) {
		super();
		this.bId = bId;
		this.user = user;
		this.vehicle = vehicle;
		this.toDate = toDate;
		this.fromDate = fromDate;
		this.status = status;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public int getBId() {
		return bId;
	}
	public void setBId(int bId) {
		this.bId = bId;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public String toString()
	{
		return bId+"\t"+vehicle.getVbrand()+"\t"+vehicle.getVNumber()+"\t"+fromDate+"\t"+toDate;
	}
}
