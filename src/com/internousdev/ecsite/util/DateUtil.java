package com.internousdev.ecsite.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public String getDate() {
		Date date=new Date();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		return simpleDateFormat.format(date);
	}

}

//Stringは数あるClassの中でも特殊な特徴があり、プリミティブ型のように値を代入できましたが、
//自作のClassを含む通常Classはnewというキーワードを使って初期化します
//
//参照型変数の初期化例：例えばDate型で変数todayを初期化する場合以下のように記述します
//Date today=new Date();