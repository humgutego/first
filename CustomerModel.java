package jp.ken.shinsengumi.model;

import java.io.Serializable;


import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


public class CustomerModel implements Serializable{
	

	private String customer_no;

	@NotEmpty(message="名前は必須入力です")
	@Size(min=1,max=29)
	private String name;
	
	@NotEmpty(message="メールアドレスは必須入力です")
	@Email(message="メールアドレスではありません")
	@Size(min=3,max=29)
	private String email;
	
	@NotEmpty(message="住所は必須入力です")
	@Size(min=1,max=99)
	private String address;
	
	@NotEmpty(message="電話番号は必須入力です。固定電話の場合は市外局番から入力してください")
	@Pattern(regexp="^[0-9]{2,4}-[0-9]{2,4}-[0-9]{4}$",message="電話番号の形式ではありません")
	@Size(min=10,max=29)
	private String phone_number;
	
	@NotEmpty(message="プランを必ず1つ選択してください")
	private String plan;
	
	@NotEmpty(message="パスワードは必須入力です")
	@Size(min=8,max=20,message="パスワードは8文字以上20文字以下で設定してください")
	private String password;
	
	public String cModel() {
		return customer_no;
	}
	public String getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(String customer_no) {
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
