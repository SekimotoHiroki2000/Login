<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>会員情報登録</h2>
<form action="register2" method="post">
<p>■名前</p>
<p>性
<input type="text" name="first_name" required="required">
名
<input type="text" name="last_name" required="required">
</p>
<p><label>■性別</label></p>
	<label for="r_male"><input id="r_male" type="radio" name="sex" value="男" required>男</label>
	<label for="r_female"><input id="r_female" type="radio" name="sex" value="女">女</label>
<p>■生年月日</p>
<p>
<select name = "birth_year" required="required">
<%
for(int i = 2023; i > 1919; i--){
	out.print("<option value=\"" + i + "\">" + i + "</option>");
}
%>
</select>
年
<select name = "birth_month" required="required">
<%
for(int i = 1; i < 13; i++){
	out.print("<option value=\"" + i + "\">" + i + "</option>");
}
%>
</select>
月
<select name = "birth_day" required="required">
<%
for(int i = 1; i < 31; i++){
	out.print("<option value=\"" + i + "\">" + i + "</option>");
}
%>
</select>
日
</p>


<p>■電話番号</p>
<input type="text" name="phone_number" required="required">

<p>■メールアドレス</p>
<input type="text" name="mail_address" required="required">

<p>■職業</p>
<select name="job" required="required">
<option value="会社員">会社員</option>
<option value="自営業">自営業</option>
<option value="学生">学生</option>
<option value="その他">その他</option>
</select>

<p><input type="submit" value="登録">
</form>
</p>

<p><form action="reset" method="post">
<input type="submit" value="リセット">
</form>
</p>

<p><form action="gomenue" method="post">
<input type="submit" value="戻る">
</form>
</p>

</body>
</html>