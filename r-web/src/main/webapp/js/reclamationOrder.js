$(function(){
	hui('#submit').click(function(){
		subReclamationOrder();
	});
});

/**
 * ajax提交废品回收订单
 * @returns
 */
function subReclamationOrder(){
	var id = $("#id").val();
	var scrap_code = $("#scrap_code").val();
	var unit = $("#unit").val();
	
	
	$.ajax({
		url:ctx+'/owner/addReclamationOrder',
		type:'post',
		data:{
			'owner_id' : id,
			'scrap_code' : scrap_code,
			'unit' : unit
		},
		dataType : "json",
		success:function(data){
			if(data == "200"){
				hui.iconToast("订单已提交，稍后回收员会与您联系！");
			}else{
				hui.iconToast("订单提交失败！");
			}
		}
	});
}

function showCurSelect(idStr){
	$("#"+idStr+"_name").attr("type","hidden");
	$("#"+idStr+"_code").show();
}

function showCurText(idStr){
	if(idStr == 'owner'){
		$("#tel").val($("#"+idStr+"_code").find("option:selected").attr("tel"));
		$("#address").val($("#"+idStr+"_code").find("option:selected").attr("address"));
		$("#id").val($("#"+idStr+"_code").find("option:selected").attr("id"));
	}
	if(idStr == 'scrap'){
		$("#price").val($("#"+idStr+"_code").find("option:selected").attr("price"));
		$("#unit").val($("#"+idStr+"_code").find("option:selected").attr("unit"));
	}
	$("#"+idStr+"_name").attr("type","text");
	$("#"+idStr+"_name").val($("#"+idStr+"_code").find("option:selected").text());
	$("#"+idStr+"_code").hide();
}