package com.internousdev.ecsite.dao;

	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;
//DAOの流れについては基本的に決まっています。DAOはDEConnectorからインスタンス化して、getConnectionを呼び出してmysqlにログインする
//そのあとはSQL文を書いてPreparedStatementの中にデータを入れて、executeQueryもしくはupdateQueryで実行してcon.closeをして接続を切る
//SQL文   メソッド       戻り値
//select executeQuery ResultSet
//Insert executeUpdate   int   Delete,Updateも同様
	public class LoginDAO {
//		LoginDTO型を最後に呼び出し元に戻すので、LoginDTO型を戻り値にしたメソッドを作ります、Actionクラスの値を引数として受け取ります
		public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword) {
		 //DBへの接続の準備、DBと会話するためのコードと覚える。これでmysqlにログインできる
			DBConnector db=new DBConnector();
			Connection con=db.getConnection();

			LoginDTO loginDTO=new LoginDTO();
			String sql="select * from login_user_transaction where login_id=? and login_pass=?";
			//test_tableに入ってるデータuser_name=?,password=?に入る2つの条件を満たしたデータがsqlに代入されます。
			//?はプレースホルダーと言ってその都度違うデータを入れていきたい時に使用します。例えばuser_name="taro" and
			//password="123"とした場合は太郎と123しかデータを抽出することができなくなります

			try {
				//PreparedStatementとはDBまで運んでくれる箱です
				PreparedStatement ps=con.prepareStatement(sql);

				ps.setString(1, loginUserId);
				ps.setString(2, loginPassword);
//		定義したSQl文の1番目の?にActionから送られたname,passoword(2)にそれぞれ入る

				ResultSet rs=ps.executeQuery();
			//executeQuery();は実行メソッドで必ずResultSetが帰ってきます
//			select文のSQL文を実行するメソッドで戻り値はResultSetになります

			//下に一行ずらすこと、データが存在していれば戻り値をtrueで返す、存在しなければfalseで返す
				if(rs.next()) {
					loginDTO.setLoginId(rs.getString("login_id"));
					loginDTO.setLoginPassword(rs.getString("login_pass"));
					loginDTO.setUserName(rs.getString("user_name"));
//		select文でDBから取得した情報をString型に変換してDTOクラスに格納します。
//			LoginDTOクラスのsetName,setPassword(setter)を利用します

					if(rs.getString("login_id")!=null) {
						loginDTO.setLoginFlg(true);
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
//		処理中にSQL関連のエラーが発生した際に実行する処理です
			}finally {
				try {
					con.close();
//					これをしないとデータベースを接続したまま次の作業が実行されてしまい、
					//メモリに負担がかかりますのでDB接続を終了する際には必ず記載するメソッド
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
			return loginDTO;
//			dtoに入った値を呼び出し元であるActionクラスに渡す
		}

	}

