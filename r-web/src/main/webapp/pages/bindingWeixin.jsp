<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/common.jsp"%>
<html>
  <head>
    
    <title>回收员微信绑定</title>
	<meta charset="utf-8">
	<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/hui.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/hui.js" charset="UTF-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/hui-form.js" charset="utf-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/hui-select-beautify.js" charset="utf-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/bindingWeixin.js"></script>
  </head>
  <script type="text/javascript">
	var ctx = '${pageContext.request.contextPath }';
	hui('#province_code').selectBeautify(showVal);
	hui('#city_code').selectBeautify(showVal);
	function showVal(val){
		hui.toast('选项值 : ' + val);
	}
  </script>
  <body>
<header class="hui-header">
	<div id="hui-back"></div>
	<h1>回收员微信绑定</h1>
</header>
<div class="hui-wrap">
	<div style="margin:28px; margin-bottom:15px;" class="hui-form" id="form-owner-add">
		<div class="hui-form-items">
			<input type="text" class="hui-input hui-input-clear" placeholder="手机号" checkType="string" id="tel" name="tel" checkData="11" checkMsg="手机号输入错误"  />
		</div>
	</div>
	<div style="padding:28px; padding-top:0px;">
		<button type="button" class="hui-button hui-button-large hui-primary" id="submit">绑定</button>
	</div>
</div>


 </body>
</html>
