<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/common.jsp"%>
<html>
  <head>
    <title>业主废品回收订单列表</title>
    <meta charset="utf-8">
	<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/hui.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/hui.js" charset="UTF-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/hui-accordion.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/reclamationOrderList.js"></script>
  </head>
  <script type="text/javascript">
	var ctx = '${pageContext.request.contextPath }';
	hui.accordion(true, true);
  </script>
  <body>
  <header class="hui-header">
	<div id="hui-back"></div>
	<h1>业主废品回收订单列表</h1>
</header>
<div class="hui-wrap">
  <jsp:useBean id="Timestamp" class="java.util.Date"/> 
  
	<c:forEach items="${reclamationOrders}" var="order">
		<div class="hui-accordion">
			<div class="hui-accordion-title" onclick="accordionCur(this);">
			
				<c:set target="${Timestamp}" property="time" value="${order.create_time}"/> 
				<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${Timestamp}" type="both"/> 
				-回收金额￥${order.money}分
				-${order.sc_status_val}
				<c:if test="${order.sc_status eq 'sc_0'}"> 
				     <a href="javascript:viod(0);" onclick="cancelOrder('${order.order_no}');"><span class="hui-icons hui-icons-clear">取消订单</span></a> 
				</c:if>  
			</div>
			<div class="hui-accordion-content">
				<div class="hui-list">
					<ul>
						<li>订单编号：${order.order_no}</li>
						<li>废品名称：${order.scrap_name}</li>
						<li>业主：${order.owner_name}</li>
						<li>废品回收员姓名：${order.sc_name}</li>
						<li>废品分捡站名称：${order.rd_name}</li>
						<li>回收数量：${order.amount}</li>
						<li>回收单位：${order.unit}</li>
						<li>回收价格（分）：${order.price}</li>
						<li>回收金额（分）：${order.money}</li>
						<li>回收状态：${order.sc_status_val}</li>
						<li>创建时间：<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${Timestamp}" type="both"/></li>
						<li>更新时间：<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${Timestamp}" type="both"/></li>
					</ul>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
  </body>
</html>
