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
<title>新規登録ページ</title>
<style type="text/css">
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
	width:340px;
	color: #FF0000;	
}
.careful{
	text-align:center;	
}
.planDetail{
	text-align:right;
}
.explain{
	margin-bottom:30px;	
}
.submit{
	text-align:center;
}
a:hover{
	opacity:0.5;	
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
            <li><a href="mypage">マイページ</a></li>
            <li><a href="login">ログイン</a></li>
            <li><a href="help">ヘルプ</a></li>
            <li><a href="point">ポイントサービス案内</a></li>
        </ul>
    </div>
</div>

<div class="main">
	<div class="wrappInner">
    <h1>新規登録</h1>
    <hr />
    	<div class="content">
    		<p class="errors">${errorMessage}</p>
        	<form:form modelAttribute="customerModel">
            	<table width="1100px">
                	<tr>
                        <th>名前</th>
                        <td class="boxSize"><form:input type="text" path="name" /></td>
                        <td class="errors"><form:errors  path="name" /></td>
                    </tr>
                    <tr>
                        <th>メールアドレス（ID）</th>
                        <td class="boxSize"><form:input type="text" path="email" /></td>
                        <td class="errors"><form:errors  path="email" /></td>	
                    </tr>
                    <tr>
                        <th>パスワード（8文字以上20文字以下の半角英数字を設定してください）</th>
                        <td class="boxSize"><form:input type="text" path="password" />
                        </td>	
                        <td class="errors"><form:errors  path="password" /></td>
                    </tr>
                    <tr>
                        <th>住所</th>
                        <td class="boxSize"><form:input type="text" path="address" />
                        
                        </td>
                        <td class="errors"><form:errors  path="address" /></td>
                    </tr>
                    <tr>
                        <th>電話番号（※記入例『090-XXXX-XXXX』）<br />固定電話の場合は市外局番から入力してください</th>
                        <td class="boxSize"><form:input type="text" path="phone_number" /></td>
                        <td class="errors"><form:errors  path="phone_number" /></td>
                    </tr>
               </table>
               <input type="hidden" name="plan" value="お試し"/>
               <div class="explain">
                	<p class="careful">新規登録時の諸注意</p>
                	<ul>
                        <li>・新規登録の場合、自動的に「お試しプラン（月額315円・上限レンタル枚数2枚）」となります。</li>
                        <li>・プラン変更はログイン後『マイページ』から可能です。</li>
                        <li class="planDetail">プランの詳しい説明は<a href="point.jsp">こちら</a></li>
                    </ul>
               	</div>
                <div class="submit">
                	<input type="submit" value="上記の内容で確認する" name="checking"/>	<!--送信押したらcheck.jspへ-->
                </div>
            </form:form>
        </div>
    </div>
</div>

<div class="footer">
	<p>Copyright&copy;2020 Music Life Agency All rights reserved.</p>
</div>

</body>
</html>
