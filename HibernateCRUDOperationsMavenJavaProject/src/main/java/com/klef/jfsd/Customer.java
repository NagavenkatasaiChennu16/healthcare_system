package com.klef.jfsd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="customer_table")
public class Customer 
{
	@Id
	@Column(name="customer_id")
	private int id;
	@Column(name="customer_name",nullable = false,length=100)
	private String name;
	@Column(name="customer_gender",nullable = false)
	private String gender;
	@Column(name="customer_username",nullable = false,unique = true,length=100)
	private String username;
	@Column(name="customer_password",nullable = false,length = 100)
	private String password;
	@Column(name="customer_age",nullable = false)
	private double age;
	@Column(name="customer_salary",nullable = false)
	private double salary;
	@Column(name="customer_location",nullable = false,length=200)
	private String location;
	@Column(name="customer_marriedstatus",nullable = false)
	private boolean marriedstatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public boolean isMarriedstatus() {
		return marriedstatus;
	}
	public void setMarriedstatus(boolean marriedstatus) {
		this.marriedstatus = marriedstatus;
	}
}
