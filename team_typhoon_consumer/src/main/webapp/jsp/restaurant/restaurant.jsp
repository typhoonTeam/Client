<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--  - author:carrie  -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>restaurant_detail</title>
</head>
<body>

<a href="./showRestaurants">回到首页</a>

<h3>商家详细信息</h3>

<p>
店名： ${restaurant.shopName}<p>
<img src='${restaurant.picture}' width='150'/><p>
开店时间：  ${restaurant.openTime}- ${restaurant.closeTime}<p>
配送范围： ${restaurant.delivery}<p>
配送费：  ${restaurant.deli_fee}<p>
店铺简介：  ${restaurant.slogan}<p>

</body>
</html>