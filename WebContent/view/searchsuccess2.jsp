<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="jp.co.aforce.bean.MemberBean" %>
<%
MemberBean member = (MemberBean)request.getAttribute("member");
if (member != null){
	String id = member.getMember_id();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>退会</h1>

<p>退会し、下記の会員情報を削除します</p>

<p>会員ID：${member.member_id} </p>

<p>氏名：${member.last_name}　${member.first_name}</p>
<p>性別：${member.sex}</p>
<p>生年月日：${member.birth_year}年${member.birth_month}月${member.birth_day}日</p>
<p>職業：${member.job}</p>
<p>電話番号：${member.phone_number}</p>
<p>メールアドレス：${member.mail_address}</p>

<p><form action="delete3" method="post">
<% 
MemberBean memberid = (MemberBean)request.getAttribute("member");
if(memberid != null){
String id = memberid.getMember_id();

out.println("<input type=\"hidden\" name=\"member_id\" value=" + id + ">");
}
%>
<input type="submit" value="退会">
</form>
</p>
<p><form action="gomenue" method="post">
<input type="submit" value="トップページへ">
</form>
</p>


</body>
</html>