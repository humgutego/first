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
<title>ログインページ</title>
<style type="text/css">
.content a:hover{
	opacity:0.3;
}
.contentInner{
	text	
}
form{
	text-align: center;
	margin: 30px;	
}
.buttonNew{
	margin:30px;
	text-align:center;
}
.errors{
	color: #ff0000;
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
    	<h1>ログイン</h1>
		<hr />
		<div class="content">
    		<h2>会員の方はこちら</h2>
            <div class="contentInner">
                <div class="block">
                <form:form modelAttribute="loginModel">
                 <p class="errors">${errorMessage}</p>
                    
                   
                        <p>ログインID：<form:input path="email"/></p>
                        
                        <p>パスワード：<form:password path="password"/></p>
                        
                        <input type="submit" value="送信" name="logins" />
                    </form:form>
                </div>
                <hr />
                <div class="buttonNew">
                    <a href="new"><img src="resources/images/button_new.gif.gif" width="300" alt="新規会員はこちら" /></a>
                </div>
            </div>
    	</div>
	</div>
	</div>

<div class="footer">
	<p>Copyright&copy;2020 Music Life Agency All rights reserved.</p>
</div>

</body>
</html>
