<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="jp.co.aforce.bean.MemberBean" %>
<%
MemberBean member = (MemberBean)request.getAttribute("member");
if (member != null){
	int year = member.getBirth_year();
	int month = member.getBirth_month();
	int day = member.getBirth_day();
}
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>会員情報編集</h1>
<p>会員ID：${member.member_id}</p>

<form action="update3" method="post">
<% 
MemberBean memberid = (MemberBean)request.getAttribute("member");
if(memberid != null){
String id = memberid.getMember_id();

out.println("<input type=\"hidden\" name=\"member_id\" value=" + id + ">");
}
%>	
<p>■性別</p>
<p>性
<input type="text" name="first_name" required="required" c:out value="${member.last_name}">
名
<input type="text" name="last_name" required="required" c:out value="${member.first_name}">
</p>
<p><label>性別</label></p>
<% 
MemberBean members = (MemberBean)request.getAttribute("member");
if (member != null){
	String sex = members.getSex();
if(sex.equals("男")){
	out.println("<label for=\"r_male\"><input id=\"r_male\" type=\"radio\" name=\"sex\" value=\"男\" required checked >	男</label>");
}else{
	out.println("<label for=\"r_male\"><input id=\"r_male\" type=\"radio\" name=\"sex\" value=\"男\" required >男</label>");
}
if(sex.equals("女")){	
	out.println("<label for=\"r_female\"><input id=\"r_female\" type=\"radio\" name=\"sex\" value=\"女\" checked >女</label>");
}else{
	out.println("<label for=\"r_female\"><input id=\"r_female\" type=\"radio\" name=\"sex\" value=\"女\" >女</label>");
}
}
%>
<p>■生年月日</p>
<p>
<select name = "birth_year" required="required">
<%
MemberBean membery = (MemberBean)request.getAttribute("member");
if (member != null){
	int year = membery.getBirth_year();
for(int i = 2023; i > 1919; i--){
	if(i == year){
		out.print("<option value=\"" + i + "\" selected>" + i + "</option>");	
	}else{
	    out.print("<option value=\"" + i + "\">" + i + "</option>");
	}
}
}
%>
</select>
年
<select name = "birth_month" required="required">
<%
MemberBean memberm = (MemberBean)request.getAttribute("member");
if (member != null){
	int month = memberm.getBirth_month();
for(int i = 1; i < 13; i++){
	if(i == month){
		out.print("<option value=\"" + i + "\" selected>" + i + "</option>");
	}else{
	    out.print("<option value=\"" + i + "\">" + i + "</option>");
	}
  }
}
%>
</select>
月
<select name = "birth_day" required="required">
<%
MemberBean memberd = (MemberBean)request.getAttribute("member");
if (member != null){
	int day = memberd.getBirth_day();
for(int i = 1; i < 31; i++){
	if(i == day){
		out.print("<option value=\"" + i + "\" selected>" + i + "</option>");
	}else{
	    out.print("<option value=\"" + i + "\">" + i + "</option>");
	}
}
}
%>
</select>
日
</p>

<p>■電話番号</p>
<input type="text" name="phone_number" required="required" c:out value="${member.phone_number}">

<p>■メールアドレス</p>
<input type="text" name="mail_address" required="required" c:out value="${member.mail_address}">

<p>■職業</p>

<select name="job" required="required">
<% 
MemberBean memberj = (MemberBean)request.getAttribute("member");
if (member != null){
	String job = memberj.getJob();
if(job.equals("会社員")){
	out.println("<option value=\"会社員\" selected>会社員</option>");	
}else{
    out.println("<option value=\"会社員\">会社員</option>");
}
if(job.equals("自営業")){
	out.println("<option value=\"自営業\" selected>自営業</option>");	
}else{
    out.println("<option value=\"自営業\">自営業</option>");
}
if(job.equals("学生")){
	out.println("<option value=\"学生\" selected>学生</option>");	
}else{
    out.println("<option value=\"学生\">学生</option>");
}
if(job.equals("その他")){
	out.println("<option value=\"その他\" selected>その他</option>");	
}else{
    out.println("<option value=\"その他\">その他</option>");
}

}
%>
</select>

<p><input type="submit" value="更新"></p>
</form>
<p><form action="gomenue" method="post">
<input type="submit" value="トップページへ">
</form>
</p>


</body>
</html>