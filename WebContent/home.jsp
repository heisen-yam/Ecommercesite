<!-- <パーセンテージ>で囲むことによりHTML内にjavaを記述することができる -->
<!-- <パーセンテージ＝式　パーセンテージ のタグは変数やjavaメソッドの実行結果を表示します-->
<!-- 実行結果を表示するため、戻り値のないvoidメソッドを指定することはできません -->
<!-- EclipseでJSP,Servletを使ったWebアプリケーションを開発する場合、動的Webプロジェクトとして作成します -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>Home画面</title>
</head>
<body>
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
			<p>Home</p>
		</div>
		<div id="text-center">
			<s:form action="HomeAction">
				<s:submit value="商品購入"/>
			</s:form>
			<s:if test="#session.login_user_id!=null">
				<p>ログアウトする場合は<a href='<s:url action="LogoutAction"/>'>こちら</a></p>
			</s:if>
		</div>
	</div>
	<div id="footer">
	</div>
</body>
</html>