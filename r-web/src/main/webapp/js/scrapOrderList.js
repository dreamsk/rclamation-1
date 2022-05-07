/**
 * ajax业主取消订单
 * @param orderNo
 * @returns 
 */
function editOrder(obj){
	var order_no = $(obj).parent().parent().find("input[name='order_no']").val();
	var amount = $(obj).parent().parent().find("input[name='amount']").val();
	var money = $(obj).parent().parent().find("input[name='money']").val();
	
	$.ajax({
		url:ctx+'/scrapCollector/editOrder',
		type:'post',
		data:{
			'order_no' : order_no,
			'amount' : amount,
			'money' : money,
			'sc_status' : 'sc_1'
		},
		dataType : "json",
		success:function(data){
			if(data == "200"){
				alert("完成回收！");
			}else{
				alert("提交失败，请重新提交！");
			}
		}
	});
}

function accordionCur(obj){
	if($(obj).hasClass('hui-accordion-title-up')){
		$(obj).parent().find('.hui-accordion-content').hide();
		$(obj).removeClass('hui-accordion-title-up');
	}else{
		$('.hui-accordion-title').removeClass('hui-accordion-title-up');
		$('.hui-accordion-content').hide();
		$(obj).parent().find('.hui-accordion-content').show();
		$(obj).addClass('hui-accordion-title-up');
	}
}

function setMoney(obj){
	var amount = $(obj).val();
	var price = $(obj).parent().parent().find("input[name='price']").val();
	
	var money = amount*price;
	$(obj).parent().parent().find("input[name='money']").val(money);
}