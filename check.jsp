<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="${pageContext.request.contextPath}/resources/common.css" />
<title>登録内容確認ページ</title>
<style type="text/css">
.checkBox{
	margin-bottom:30px;	
}
.submitCheck{
	text-align:center;	
}
</style>
</head>

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
    <h1>新規登録内容確認</h1>
    <hr />
    	<div class="content">
        	<form:form modelAttribute="customerModel">	<!--jspのときはnew.jspの入力情報を引き継げるようにする-->
            	<table class="checkBox">
            	<tr>
                	<td>名前</td>
                    <td>
                    <c:out value="${customerModel.name}"/>
                    <input type="hidden" value="${customerModel.name}" name="name"/>
                    </td>
                    
                </tr>
                <tr>
                	<td>メールアドレス（ID）</td>
                    <td><c:out value="${customerModel.email}"/>
                    <input type="hidden" value="${customerModel.email}" name="email"/>
                    </td>
                </tr>
                <tr>
                	<td>パスワード</td>
                    <td>
                    <c:out value="${customerModel.password}"/>
                    <input type="hidden" value="${customerModel.password}" name="password"/>
                    </td>
                </tr>
                 <tr>
                	<td>住所</td>
                    <td>
                    <c:out value="${customerModel.address}"/>
                    <input type="hidden" value="${customerModel.address}" name="address"/>
                    </td>
                </tr>
                <tr>
                	<td>電話番号</td>
                    <td>
                    <c:out value="${customerModel.phone_number}"/>
                    <input type="hidden" value="${customerModel.phone_number}" name="phone_number"/>
                    </td>
                </tr>  
                <tr>
                	<td>プラン</td>
                    <td>
                    	お試し
                    <input type="hidden" name="plan" value="お試し"/>
                    </td>
                </tr>  
                </table>
                <div class="submitCheck">
                    <input type="submit" value="上記の内容で登録" name="regist"/>	<!--送信押したらcommit.jspへ-->
                    <input type="submit" value="訂正事項があるので戻る" name="back"/>	<!--送信押したらnew.jspへ-->
                </div>
            </form:form>
        </div>
    </div>
</div>

<div class="footer">
	<p>Copyright&copy;2020 Music Life Agency All rights reserved.</p>
</div>

<body>
</body>
</html>
