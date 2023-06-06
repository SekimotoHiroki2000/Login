<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>会員情報更新完了</h1>

<p>会員ID：${member.member_id}</p>

<p>下記の内容へ変更しました</p>
<p>氏名：${member.last_name}　${member.first_name}</p>
<p>性別：${member.sex}</p>
<p>生年月日：${member.birth_year}年${member.birth_month}月${member.birth_day}日</p>
<p>職業：${member.job}</p>
<p>電話番号：${member.phone_number}</p>
<p>メールアドレス：${member.mail_address}</p>　

<form action="gomenue" method="post">
<input type="submit" value="トップページへ">
</body>
</html>