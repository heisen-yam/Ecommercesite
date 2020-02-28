package com.internousdev.ecsite.dto;
//DateTtransferObject DBから取得した情報を格納するためのクラスです DAOはDTOに格納した情報をActionクラスへ渡します
public class BuyItemDTO {
		private int id;
		private String itemName;
		private String itemPrice;

		public String getItemName() {
			return itemName;
		}
		public void setItemName(String itemName) {
			this.itemName=itemName;
		}
		public String getItemPrice() {
			return itemPrice;
		}
		public void setItemPrice(String itemPrice) {
			this.itemPrice=itemPrice;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id=id;
		}

	}

