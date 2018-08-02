<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--  - author:carrie  -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>foodList</title>
</head>
<body>

<a href="./showRestaurantDetail">查看商家信息</a>
&nbsp;&nbsp;&nbsp;
<a href="./showRestaurants">回到首页</a>

<h2>菜品列表</h2>
<table>
	<tr>
		<td width="150">菜名</td>
		<td width="150">图片</td>
		<td width="150">价格</td>
		<td width="150">介绍</td>
	</tr>
<c:forEach items="${foods}" var="food">
	<tr height="200">
		<td width="150"><a href="./showDishDetail?food_id=${food.id }">${food.foodName }</a></td>
		<td width="150"><img src='${food.picture }' width='130'></td>
		<td width="150">${food.price }</td>
		<td width="100">${food.info}</td>
	</tr>
</c:forEach>
</table>

</body>
</html>