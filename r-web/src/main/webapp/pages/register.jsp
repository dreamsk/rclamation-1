<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../common/common.jsp"%>
<html>
  <head>
    
    <title>业主注册</title>
	<meta charset="utf-8">
	<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<link rel="stylesheet" type="text/css" href="../css/hui.css" />
	
	<script type="text/javascript" src="../js/hui.js" charset="UTF-8"></script>
	<script type="text/javascript" src="../js/hui-form.js" charset="utf-8"></script>
	<script type="text/javascript" src="../js/hui-select-beautify.js" charset="utf-8"></script>
	<script type="text/javascript" src="../js/register.js"></script>
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
	<h1>注册成为新用户</h1>
</header>
<div class="hui-wrap">
	<div style="margin:28px; margin-bottom:15px;" class="hui-form" id="form-owner-add">
		<div class="hui-form-items">
			<input type="text" class="hui-input hui-input-clear" placeholder="姓名" checkType="string" id="name" name="name" checkData="2,20" checkMsg="用户名应为2-20个字符" />
		</div>
		<div class="hui-form-items">
			<input type="text" class="hui-input hui-input-clear" placeholder="身份证号码" checkType="string" id="idCard" name="idCard" checkData="18" checkMsg="请填写18位身份证号码" onblur="getsex();"/>
		</div>
		<div class="hui-form-items">
			<input type="text" class="hui-input hui-input-clear" placeholder="手机号" checkType="string" id="tel" name="tel" checkData="11" checkMsg="手机号输入错误"  />
		</div>
		<div class="hui-form-items hui-form-select" >
			<input type="text" class="hui-input hui-input-clear" placeholder="请选择省份" id="province_name" readonly="readonly" onclick="showCurSelect('province');"/>
			<select id="province_code" name="province_code" onchange="showCurText('province');" style="display: none;">
				
			</select>
		</div>
		<div class="hui-form-items hui-form-select" >
			<input type="text" class="hui-input hui-input-clear" placeholder="请选择城市" id="city_name" readonly="readonly" onclick="showCurSelect('city');"/>
			<select id="city_code" name="city_code" onchange="showCurText('city');" style="display: none;">
				
			</select>
		</div>
		<div class="hui-form-items hui-form-select">
			<input type="text" class="hui-input hui-input-clear" placeholder="请选择小区" id="housing_estate_name" readonly="readonly" onclick="showCurSelect('housing_estate');"/>
			<select id="housing_estate_code" name="housing_estate_code" onchange="showCurText('housing_estate');" style="display: none;">
				
			</select>
		</div>
		<div class="hui-form-items">
			<input type="text" class="hui-input hui-input-clear" placeholder="详细地址" checkType="string" id="address" name="address"/>
		</div>
		<input type="hidden" id="sex" name="sex">
	</div>
	<div style="padding:28px; padding-top:0px;">
		<button type="button" class="hui-button hui-button-large hui-primary" id="submit">立即注册</button>
	</div>
</div>


 </body>
</html>
