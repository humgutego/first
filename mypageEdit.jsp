<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="<c:url value=" ${pageContext.request.contextPath}/resources/common.css" />" rel="stylesheet" type="text/css"/>
<title>マイページ</title>
<style type="text/css">
.content{
	clear:both;	
}
a:hover{
	opacity:0.5;	
}
table{
	margin:30px;	
}
th{
	width:350px;
	padding:10px;
	text-align:left;
	background-color:#d7eeff;	
}
td{
	padding-left:5px;	
}
.boxSize input{
	width:350px;	
}
.errors{
	width:220px;
	color: #FF0000;		
}
.planDetail{
	text-align:right;
}
.submit{
	text-align:center;
}
.changePlanTop{
	margin-bottom:50px;	
}
.changePlanMiddle{
	margin:50px 30px;
}
.changePlanBottom{
	margin:50px 30px;	
}
.escape{
	float:right;
	margin-bottom:30px;
}
</style>
</head>
<body>
<div id="header">
	<div class="headerInner">
        <div class="logoArea">
            <a href="top"><img src="resources/itemImg/logo.png" width="200" height="100" alt="Music Life Agency" class="logo" /></a>
        </div>
        <div class="headerMiddleArea">
            <p>&lt;&nbsp;お取り扱い&nbsp;&gt;</p>
            <p>CD・DVD・Blue-ray・本</p>
        </div>
        <div class="headerMiddleAreaSub">
            <p>※&nbsp;店頭でのレンタル・販売等は一切行っておりません。</p>
        </div>
        <div class="headerRightArea">
            <div class="timeArea">
                <p>【営業時間】&nbsp;24時間</p>
            </div>
            <div class="telArea">
                <p><a href="#">TEL：123-4564-7891</a></p>
            </div>
        </div>
    </div>
    <div class="navArea">
        <ul>
            <li><a href="searchIndex">検索</a></li>
            <li><a href="login">ログイン</a></li>
            <li><a href="point">ポイントサービス案内</a></li>
            <li><a href="help">ヘルプ</a></li>
        </ul>
    </div>
</div>
<div class="main">
	<div class="wrappInner">
    <h1>マイページ</h1>
    <hr />
    	<div class="content">
    	<p class="errors">${errorMessage}</p>
        	<div class="changePlanTop">
        	<h2>登録内容変更入力</h2>
                <form:form modelAttribute="customerModel">
                <table>
                    <tr>
                        <th>お客様番号</th>
                        <td class="boxSize">
                        <c:out value="${customerModel.customer_no}"/>
                        <input type="hidden" value="${customerModel.customer_no}" name="customer_no"/>
                        </td>
                        <td>&nbsp;</td>
                    </tr>                              
                    <tr>
                        <th>お名前</th>
                        <td class="boxSize"><form:input path="name" name="name" /></td>
                        <td class="errors"><form:errors path="name"/></td> 
                    </tr>
                    <tr>
                        <th>メールアドレス（ID）</th>
                        <td class="boxSize"><form:input path="email" name="email" /></td>
                        <td class="errors"><form:errors path="name"/></td> 
                    </tr>
                    <tr>
                        <th>パスワード</th>
                        <td class="boxSize"> <form:input path="password" name="password" /></td> 
                        <td class="errors"><form:errors path="password"/></td>
                    </tr>
                    <tr>
                        <th>住所</th>
                        <td class="boxSize"> <form:input path="address" name="address" /></td>
                        <td class="errors"><form:errors path="address"/></td> 
                    </tr>
                    <tr>
                        <th>電話番号（※記入例『090-XXXX-XXXX』）<br />固定電話の場合は市外局番から入力してください</th>
                        <td class="boxSize"><form:input path="phone_number" name="phone_number" /></td>
                        <td class="errors"><form:errors path="phone_number"/></td>  
                    </tr>
                    <tr>
                        <th>プラン</th>
                        <td>
                        	<form:radiobutton  path="plan" name="plan" value="お試し" />お試しプラン
                            <form:radiobutton  path="plan" name="plan" value="bronze" />Bronzeプラン
                            <form:radiobutton  path="plan" name="plan" value="silver" />Silverプラン
                            <form:radiobutton  path="plan" name="plan" value="gold" />Goldプラン
                        </td>
                        <td class="errors"><form:errors path="plan"/></td>
                    </tr>
                    </table>
                     
                    <p class="planDetail">プランの詳しい説明は<a href="point.jsp">こちら</a></p>	<!--point.jspへのリンクにしたい-->
                    <div class="submit">
                        <input type="submit" value="上記の内容で変更する" name="editing"/>
                    </div>
                    </form:form>
                </div>


       </div>
    </div>
</div>

<div class="footer">
	<p>Copyright&copy;2020 Music Life Agency All rights reserved.</p>
</div>
</body>
</html>
