<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%--静态包含--%>
	<%@include file="/pages/common/head.jsp"%>
</head>
<body>
	<script>
		$(function () {
			//给删除绑定鼠标单击事件
			$(".delete").click(function () {
				let name = $(this).parent().parent().find("td:first").text();
				return confirm("你却定要删除【" + name + "】吗");
			});
			//清空购物车
			$("#clear").click(function () {
				return confirm("你却额定要删除清空购物车吗");
			});
			//修改商品数量  使用change()
			$(".update").change(function () {
				let bookId = $(this).attr("bookId");
				let name = $(this).parent().parent().find("td:first").text();
				let count = $(this).val();
				if(confirm("你确定要修改【"+ name +"】数量为【"+ count +"】吗")){
					location.href = "${basePath}carServlet?action=updateCount&id="+bookId+"&count="+count;
				}else {
					this.values = this.defaultValue;
				}
			});
		});
	</script>
	
	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif" >
		<span class="wel_word">购物车</span>
		<%@include file="/pages/common/welcome_nav.jsp"%>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<%--循环遍历商品--%>
			<c:forEach items="${sessionScope.car.items}" var="items">
				<tr>
					<td>${items.value.name}</td>
					<td>
						<input class="update" bookId="${items.value.id}" type="text" value="${items.value.count}" style="width: 60px;">
					</td>
					<td>${items.value.price}</td>
					<td>${items.value.totalPrice}</td>
					<td><a class="delete" href="carServlet?action=delete&id=${items.value.id}">删除</a></td>
				</tr>
			</c:forEach>
			<%--购物车为空时显示跳转连接--%>
			<c:if test="${empty sessionScope.car.items}">
				<tr>
					<td colspan="5"	><a href="index.jsp">购物车为空，去浏览商品</a></td>
				</tr>
			</c:if>
		</table>
		<div class="cart_info">
			<%--购物车非空时显示购物车信息--%>
			<c:if test="${not empty sessionScope.car.items}">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.car.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.car.totalPrice}</span>元</span>
				<span class="cart_span"><a id="clear" href="carServlet?action=clear">清空购物车</a></span>
				<span class="cart_span" style="margin-right: 100px"><a href="pages/cart/checkout.jsp">去结账</a></span>
			</c:if>
		</div>
	</div>
	<%--静态包含 ，引入页脚--%>
	<%@include file="/pages/common/foot.jsp"%>
</body>
</html>