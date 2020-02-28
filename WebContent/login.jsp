<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>Login画面</title>
</head>
<body>
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
			<p>Login</p>
		</div>
		<div>
			<h3>商品を購入する際にはログインお願いします</h3>
<!-- 			formタグ内のnameとpasswordをLoginActionにsubmitします -->
			<s:form action="LoginAction">
<!-- 			formで囲まれたタグに入力された情報がaction=""で指定したActioinクラスへ渡されます -->
				<s:textfield name="loginUserId"/>
<!-- 			name=""で指定した名前と同名のActionクラスのフィールドに情報を渡します -->
<!-- 				情報が渡される前提として、Actionクラスで当該フィールドのsetter定義が必要です -->
				<s:password name="loginPassword"/>
				<s:submit value="ログイン"/>
			</s:form>
<!-- ユーザーが入力したユーザーネームとパスワードを値にそれぞれnameとpasswordという名前をつけて送信します -->

			<br>
			<div id="text-link">
				<p>新規ユーザーが登録は<a href='<s:url action="UserCreateAction"/>'>こちら</a><p>
				<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a><p>
			</div>
		</div>
	</div>

	<div id="footer">
	</div>
</body>
</html>