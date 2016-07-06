$("#regist").live("click", function(){
	$.ajax({
		url:"./regist.do",
		type:"POST",
		async:"true",
		data:{
			"user_name": $("#user_name").val(),
			"user_email":$("#user_email").val(),
			"user_password":$("#user_password").val()
		},
		success:function(msg){
			if(msg == "Y"){
				alert("成功！");
			}
		}
	});
});

$("#login").live("click", function(){
	$.ajax({
		url:"./sign.do",
		type:"POST",
		async:"true",
		data:{
			"user_name": $("#login_user_name").val(),
			"user_password":$("#login_user_password").val()
		},
		success:function(msg){
			if(msg == 'Y'){
				 window.location.href = "./main.do";
			}
		}
	});
});