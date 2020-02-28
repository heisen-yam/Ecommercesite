package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;

	public String execute() {
		String result="login";
		if(session.containsKey("login_user_id")){
//			ログイン済み判定を行います。一度ログインしている場合はログイン
//			認証画面に移動させることなく、商品画面へ遷移させます。
				BuyItemDAO buyItemDAO=new BuyItemDAO();
				BuyItemDTO buyItemDTO=buyItemDAO.getBuyItemInfo();
				session.put("id", buyItemDTO.getId());
				session.put("buyItem_name", buyItemDTO.getItemName());
				session.put("buyItem_price", buyItemDTO.getItemPrice());
//				DBから取得した商品情報をセッションに格納しています
				result=SUCCESS;
		}
		//executeメソッドの戻り値としてログイン状態の場合はSUCCESS,loginいていない場合はloginを返す
		return result;
	}
	public Map<String,Object> getSession(){
		return this.session;
	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}

}
