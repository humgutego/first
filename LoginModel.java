package jp.ken.shinsengumi.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginModel implements Serializable  {	//ログインで入力したもの用モデル
	
	@NotEmpty(message="ログインID（emailアドレス）は必須入力です")
	private String email;
	
	@NotEmpty(message="パスワードは必須入力です")
	private String Password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	

	
	
	
}
