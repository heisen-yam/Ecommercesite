package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

//Struts2が持つActionSupportというクラスを継承します
public class LoginAction extends ActionSupport implements SessionAware{

//	フィールド変数　JPSから受け取る値(*必ずJSPでの定義と同じ名前にします)
	private String loginUserId;
	private String loginPassword;
	private Map<String,Object> session;
	private LoginDAO loginDAO=new LoginDAO();
	private LoginDTO loginDTO=new LoginDTO();
	private BuyItemDAO buyItemDAO=new BuyItemDAO();

//	メソッド名はexecuteにします
	public String execute() {
		String result=ERROR;
		loginDTO=loginDAO.getLoginUserInfo(loginUserId,loginPassword);
		session.put("loginUser", loginDTO);

		if(((LoginDTO) session.get("loginUser")).getLoginFlg()) {
			result=SUCCESS;
			BuyItemDTO buyItemDTO=buyItemDAO.getBuyItemInfo();

			session.put("login_user_id", loginDTO.getLoginId());
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());
//			入力値からユーザー情報の検索を行います
//			ログイン認証が成功した場合、次の画面で
//			商品情報が必要なため商品情報を取得します
			return result;
		}
		return result;
	}
	public String getLoginUserId() {
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId) {
		this.loginUserId=loginUserId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword=loginPassword;
	}
	public Map<String,Object> getSession(){
		return this.session;
	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}

}
