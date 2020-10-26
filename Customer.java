package jp.ken.shinsengumi.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="customer")
@SuppressWarnings("serial")
public class Customer implements Serializable{
	
	@Id											//主キー
	@Column(name="customer_no")						//関連列名
	@GeneratedValue(strategy=GenerationType.AUTO)	//自動採番されている為。
	private int customer_no;

	
	private String name;
	
		
	@Column(name="email",unique=true)						//関連列名
	private String email;
	

	private String address;
	
	
	private String phone_number;
	
	private String plan;

	@Column(name="password")						//関連列名
	private String password;
	
	public int getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
