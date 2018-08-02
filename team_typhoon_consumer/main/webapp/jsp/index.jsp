<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  - author:carrie  -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>推荐商家</h2>
<table>
<c:forEach items="${advertisements}" var="ad">
	<tr>
		<td width="150"><a href="./findDishes?shop_id=${ad.shopId }">${ad.slogan}</a></td>
		<td width="150"><img src='${ad.picture}'  width='130'></td>
	</tr>
</c:forEach>
</table>

<h2>商家列表</h2>
<table>

	<tr>
		<td width="150">店名</td>
		<td width="150">配送范围</td>
		<td width="150">配送费</td>
		<td width="150">简介</td>
	</tr>

<c:forEach items="${restaurants}" var="res">
	<tr>
		<td width="150"><a href="./findDishes?shop_id=${res.shopId }">${res.shopName}</a></td>
		<td width="150">${res.delivery}km</td>
		<td width="150">${res.deli_fee}</td>
		<td width="150">${res.slogan}</td>
	</tr>
</c:forEach>
</table></center>
</body>
</html>