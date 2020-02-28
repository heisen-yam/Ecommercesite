package com.internousdev.ecsite.dto;

public class LoginDTO {
	private String loginId;
	private String loginPassword;
	private String userName;
	private boolean loginFlg=false;
//	デーブルから取得するデータに対応したフィールド変数を宣言します

//	フィールド変数に対応したgetterとsetterを定義します
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId=loginId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword=loginPassword;
	}
//	Actionクラスから呼び出され、nameフィールドの値をActionに渡します
	public String getUserName() {
		return userName;
	}
//	DAOクラスから呼び出され、引数として受け取ったテーブルの値を自信のnameフィールドに格納します
	public void setUserName(String userName) {
		this.userName=userName;
	}
	public boolean getLoginFlg() {
		return loginFlg;
	}
	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg=loginFlg;
	}
}
