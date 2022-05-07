<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/common.jsp"%>
<html>
  <head>
    
    <title>废品回收订单</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/hui.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/hui.js" charset="UTF-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/hui-form.js" charset="utf-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/hui-select-beautify.js" charset="utf-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/reclamationOrder.js"></script>
  </head>
  <script type="text/javascript">
	var ctx = '${pageContext.request.contextPath }';
  </script>
  <body>
<header class="hui-header">
	<div id="hui-back"></div>
	<h1>填写订单</h1>
</header>
<div class="hui-wrap">
	<div style="margin:28px; margin-bottom:15px;" class="hui-form" id="form-owner-add">
		<div class="hui-form-items hui-form-select">
			<input type="text" class="hui-input hui-input-clear" placeholder="姓名" checkType="string" id="owner_name" name="owner_name" readonly="readonly" onclick="showCurSelect('owner');"/>
			<select id="owner_code" name="owner_code" onchange="showCurText('owner');" style="display: none;">
				<option value="">-请选择-</option>
				<c:forEach items="${owners}" var="owner">
   					<option value="${owner.id}" id="${owner.id}" tel="${owner.tel}" address="${owner.address}">${owner.name}</option>
   				</c:forEach>
			</select>
		</div>
		<div class="hui-form-items">
			<input type="text" class="hui-input hui-input-clear" placeholder="手机号" checkType="string" id="tel" name="tel" readonly="readonly"/>
		</div>
		<div class="hui-form-items">
			<input type="text" class="hui-input hui-input-clear" placeholder="详细地址" id="address" name="address" readonly="readonly"/>
		</div>
		<div class="hui-form-items hui-form-select">
			<input type="text" class="hui-input hui-input-clear" placeholder="废品" checkType="string" id="scrap_name" name="scrap_name" readonly="readonly" onclick="showCurSelect('scrap');"/>
			<select id="scrap_code" name="scrap_code" onchange="showCurText('scrap');" style="display: none;">
				<option value="">-请选择-</option>
				<c:forEach items="${scraps}" var="scrap">
   					<option value="${scrap.scrap_code}" unit="${scrap.unit}" price="${scrap.price}分/${scrap.unit}">${scrap.scrap_name}</option>
   				</c:forEach>
			</select>
		</div>
		<div class="hui-form-items">
			<input type="text" class="hui-input hui-input-clear" placeholder="价格" id="price" name="price" readonly="readonly"/>
		</div>
		
		<input type="hidden" id="id" name="id">
		<input type="hidden" id="unit" name="unit">
	</div>
	<div style="padding:28px; padding-top:0px;">
		<button type="button" class="hui-button hui-button-large hui-primary" id="submit">提交订单</button>
	</div>
</div>
  
  
  </body>
</html>
