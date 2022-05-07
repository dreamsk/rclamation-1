$(function() {
	
	
	hui('#submit').click(function(){
		//验证
		var res = huiFormCheck('#form-owner-add');
		//提交
		if(res){
			var address = $("#province_name").val() + "-"
						+ $("#city_name").val() + "-"
						+ $("#housing_estate_name").val() + "-"
						+ $("#address").val();
			$.ajax({
				type : "post",
				url : ctx + "/owner/register",
				data : {
					"name" : $("#name").val(),
					"idCard" : $("#idCard").val(),
					"tel" : $("#tel").val(),
					"housing_estate_code" : $("#housing_estate_code").val(),
					"address" : address,
					"sex" : $("#sex").val()
				},
				dataType : "json",
				success : function(data) {
					if (data == '200') {
						hui.iconToast('注册成功!');
						window.close();
					} else {
						hui.iconToast('注册失败!');
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert(errorThrown);
					return false;
				}
			});
		}
	});
	
	creSelDom("province_code",0);
});

function creSelDom(id,code){
	var url = ctx + "/owner/getAreasByCode";
	
	if(id == 'housing_estate_code'){
		url = ctx + "/owner/getHousingEstateByCityCode";
	}
	
	$.ajax({
		type : "post",
		url : url,
		data : {"code" : code},
		dataType : "json",
		success : function(data) {
			var options = '<option value="">-请选择-</option>';
			if(data && data.length > 0){
				if(id == 'housing_estate_code'){
					for(var i = 0; i < data.length; i++){
						options += '<option value="' + data[i].code + '">' + data[i].address + '</option>';
					}
				}else{
					for(var i = 0; i < data.length; i++){
						options += '<option value="' + data[i].area_code + '">' + data[i].area_name + '</option>';
					}
				}
			}
			$("#"+id).html(options);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(errorThrown);
			return false;
		}
	});
}

/**
 * 校验手机号
 * 
 * @param id
 */
function checkTel(tel) {
	// 手机号码
	if ($.trim(tel) == "") {
		alert("请准确填写您常用手机号码 ！");
		return false;
	} else if (!(/^\d{11}$/.test(tel))) {
		alert("您的手机填写有误，请核实！");
		return false;
	} else if (!(/^1[34578]\d{9}$/.test(tel))) {
		alert("手机号码应以13、14、15、17、18开头！");
		return false;
	}
	return true;
}

/**
 * 校验小区
 * 
 * @param id
 */
function checkHousingEstate(housingEstate) {
	if (housingEstate == '0') {
		alert("请选择小区！");
		return false;
	}
	return true;
}

// ----------------------------------------------------------
// 功能：根据身份证号获得性别
// 参数：身份证号 idCard
// 返回值：
// 性别
// ----------------------------------------------------------
function getsex() {
	var idCard = $("#idCard").val();
	var sexno, sex;
	if (idCard.length == 18) {
		sexno = idCard.substring(16, 17);
	} else if (idCard.length == 15) {
		sexno = idCard.substring(14, 15);
	} else {
		alert("错误的身份证号码，请核对！");
		return false;
	}
	var tempid = sexno % 2;
	if (tempid == 0) {
		sex = 'sex_0';
	} else {
		sex = 'sex_1';
	}
	$("#sex").val(sex);
}

function showCurSelect(idStr){
	$("#"+idStr+"_name").attr("type","hidden");
	$("#"+idStr+"_code").show();
}

function showCurText(idStr){
	if(idStr == 'province'){
		creSelDom("city_code",$("#"+idStr+"_code").val());
	}
	if(idStr == 'city'){
		creSelDom("housing_estate_code",$("#"+idStr+"_code").val());
	}
	$("#"+idStr+"_name").attr("type","text");
	$("#"+idStr+"_name").val($("#"+idStr+"_code").find("option:selected").text());
	$("#"+idStr+"_code").hide();
	
	
}


