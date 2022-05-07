$(function() {
	hui('#submit').click(function(){
		$.ajax({
			type : "post",
			url : ctx + "/scrapCollector/bindingWeixin",
			data : {
				"tel" : $("#tel").val()
			},
			dataType : "json",
			success : function(data) {
				if (data == '200') {
					hui.iconToast('绑定成功!');
					window.close();
				} else {
					hui.iconToast('绑定失败!');
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(errorThrown);
				return false;
			}
		});
	});
	
});


