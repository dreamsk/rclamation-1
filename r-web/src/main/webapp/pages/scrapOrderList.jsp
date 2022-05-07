<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/common.jsp"%>
<html>
  <head>
    <title>废品回收订单列表(回收员)</title>
    <meta charset="utf-8">
	<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/hui.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/hui.js" charset="UTF-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/hui-accordion.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/scrapOrderList.js"></script>
  </head>
  <script type="text/javascript">
	var ctx = '${pageContext.request.contextPath }';
	hui.accordion(true, true);
  </script>
  <body>
  <header class="hui-header">
	<div id="hui-back"></div>
	<h1>废品回收订单列表(回收员)</h1>
</header>
<div class="hui-wrap">
  <jsp:useBean id="Timestamp" class="java.util.Date"/> 
  
	<c:forEach items="${scrapOrders}" var="order">
		<div class="hui-accordion">
			<div class="hui-accordion-title" onclick="accordionCur(this);">
			
				<c:set target="${Timestamp}" property="time" value="${order.create_time}"/> 
				<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${Timestamp}" type="both"/> 
				-回收金额￥${order.money}分
				-${order.sc_status_val}
			</div>
			<div class="hui-accordion-content">
				<div style="margin:28px; margin-bottom:15px;" class="hui-form" id="form-owner-add">
					<div class="hui-form-items hui-form-items-flex">
						<div class="hui-form-items-title">订单编号：</div>
						<input type="text" class="hui-input hui-input-clear" placeholder="" checkType="string" name="order_no" value="${order.order_no}" readonly="readonly"/>
					</div>
					<div class="hui-form-items hui-form-items-flex">
						<div class="hui-form-items-title">废品名称：</div>
						<input type="text" class="hui-input hui-input-clear" placeholder="" checkType="string" name="scrap_name" value="${order.scrap_name}" readonly="readonly"/>
					</div>
					<div class="hui-form-items hui-form-items-flex">
						<div class="hui-form-items-title">业主：</div>
						<input type="text" class="hui-input hui-input-clear" placeholder="" checkType="string" name="owner_name" value="${order.owner_name}" readonly="readonly"/>
					</div>
					<div class="hui-form-items hui-form-items-flex">
						<div class="hui-form-items-title">废品回收员姓名：</div>
						<input type="text" class="hui-input hui-input-clear" placeholder="" checkType="string" name="sc_name" value="${order.sc_name}" readonly="readonly"/>
					</div>
					<div class="hui-form-items hui-form-items-flex">
						<div class="hui-form-items-title">回收单位：</div>
						<input type="text" class="hui-input hui-input-clear" placeholder="" checkType="string" name="unit" value="${order.unit}" readonly="readonly"/>
					</div>
					<div class="hui-form-items hui-form-items-flex">
						<div class="hui-form-items-title">回收价格：</div>
						<input type="text" class="hui-input hui-input-clear" placeholder="" checkType="string" name="price" value="${order.price}" readonly="readonly"/>
					</div>
					<div class="hui-form-items hui-form-items-flex">
						<div class="hui-form-items-title">回收数量：</div>
						<c:if test="${not empty order.amount}"> 
							<input type="text" class="hui-input hui-input-clear" placeholder="" checkType="string" name="amount" value="${order.amount}" readonly="readonly"/>
						</c:if>
						<c:if test="${empty order.amount}"> 
							<input type="text" class="hui-input hui-input-clear" placeholder="" checkType="string" name="amount" onblur="setMoney(this);"/>
						</c:if>
					</div>
					<div class="hui-form-items hui-form-items-flex">
						<div class="hui-form-items-title">回收金额（分）：</div>
						<input type="text" class="hui-input hui-input-clear" placeholder="" checkType="string" name="money" value="${order.money}" readonly="readonly"/>
					</div>
					<div class="hui-form-items hui-form-items-flex">
						<div class="hui-form-items-title">回收状态：</div>
						<input type="text" class="hui-input hui-input-clear" placeholder="" checkType="string" id="sc_status_val" name="sc_status_val" value="${order.sc_status_val}" readonly="readonly"/>
					</div>
					<c:if test="${order.sc_status eq 'sc_0'}">
						<div style="padding:28px; padding-top:0px;">
							<button type="button" class="hui-button hui-button-large hui-primary" id="submit" onclick="editOrder(this);">完成回收</button>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
  </body>
</html>
