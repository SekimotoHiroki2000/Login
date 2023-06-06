<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>会員情報編集</h1>
<form action="update2" method="post">
<p>会員ID：
<input type="text" name="member_id" required="required"　c:out value="${member.member_id}">
<input type="submit" value="検索">
</form>
※ID：${member.member_id}は見つかりませんでした。再度入力してください。
</p>
<p><form action="gomenue" method="post">
<input type="submit" value="戻る">
</form>
</p>
</body>
</html>