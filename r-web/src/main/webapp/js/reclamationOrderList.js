/**
 * ajax业主取消订单
 * @param orderNo
 * @returns 
 */
function cancelOrder(order_no){
	
	
	$.ajax({
		url:ctx+'/owner/cancelOrder',
		type:'post',
		data:{
			'order_no' : order_no,
			'sc_status' : 'del'
		},
		success:function(data){
			if(data == "200"){
				alert("订单已取消！");
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