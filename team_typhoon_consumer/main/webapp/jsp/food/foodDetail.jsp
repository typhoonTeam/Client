<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--  - author:carrie  -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>foodDetail</title>
</head>
<body>

<a href="./showRestaurants">回到首页</a>

<h3>菜品详细信息</h3>

<p>

菜品名： ${food.foodName }<p>
<img src='${food.picture}' width='150'><p>
价格: ${food.price }<p>
介绍：  ${food.info}

</body>
</html>