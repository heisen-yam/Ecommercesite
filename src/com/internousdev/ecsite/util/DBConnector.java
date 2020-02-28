package com.internousdev.ecsite.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	//JDBCドライバーの名前を変数に代入しています。ちなみにドライバーとはjavaとデータベースを繋げる工具箱のようなものです
	private static String driverName="com.mysql.jdbc.Driver";
	//今回はmysqlを使っていますのでmysql用のURLの指定の仕方になります データベースURL
	//localhost(自分の使っているPC)でtestdb（データベース名）を使います。？以降は(escite?autoReconnect=true&useSSL=false";オプションなので必要なし
	private static String url="jdbc:mysql://localhost/ecsite";
	//データベース接続ユーザ名
	private static String user="root";
	//上で指定したrootアカウントに対するパスワードをmysqlに指定しています
	private static String password="mysql";
	//mysqlにログインするための値の準備をしています

	public Connection getConnection() {
	//接続状態にする
		Connection con=null;
		//一度状態を初期化しています。この2つは接続しかしないクラス。公式として覚えておく

	//まずtry＝catchはjavaの例外処理のための構文です tryの中にはエラーが発生しそうな処理を書きます
	//tryの中でエラーが発生した場合に、catchが受け取り,printStackTraceでエラーに至る履歴を表示してくれます
	//間違った際の赤い文字(catch)です。今回だと2つのエラーが表示されます
	try {
		//ここでは簡単にいうとドライバーがロードされ使えるような状態にしています。覚える
		Class.forName(driverName);
	//設定した情報を使って自分のパソコンにインストールされているMySQLサーバーへ接続するための記述です
		con=(Connection)DriverManager.getConnection(url,user,password);
	//クラスが見つからない場合の例外とSQLExceptionデータベースに関する例外です
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return con; //MySQLサーバに接続した結果をメソッドの呼び出しもとに渡します
	}

}
