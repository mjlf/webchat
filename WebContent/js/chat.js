$(document).ready(function(){
	function e(){function h(){
		-1!=g.indexOf("*#emo_")&&(g=g.replace("*#","<img src='/webchat/img/").replace("#*",".gif'/>"),h())
		}
	var e=new Date,f="";
	f+=e.getFullYear()+"-",f+=e.getMonth()+1+"-",f+=e.getDate()+"  ",f+=e.getHours()+":",f+=e.getMinutes()+":",f+=e.getSeconds();
	var g=$("#textarea").val();
	h();
	var user = $.parseJSON($("#loginid").val());
	var i="<div class='message clearfix'><div class='user-logo'><img src='"+user.user_icon+"'/>"+"</div>"+"<div class='wrap-text'>"+"<h5 class='clearfix'>"+user.user_name+"</h5>"+"<div>"+g+"</div>"+"</div>"+"<div class='wrap-ri'>"+"<div clsss='clearfix'><span>"+f+"</span></div>"+"</div>"+"<div style='clear:both;'></div>"+"</div><div style='clear:both;'></div>";
	null!=g&&""!=g?($(".chat01_content").append(i),
			$(".chat01_content").scrollTop($(".mes"+a).height()),message()):alert("\u8bf7\u8f93\u5165\u804a\u5929\u5185\u5bb9!")
			}
	var a=3,b="img/head/2024.jpg",c="img/head/2015.jpg",d="\u738b\u65ed";
	$(".close_btn").click(function(){$(".chatBox").hide()}),$(".chat03_content li").mouseover(function(){$(this).addClass("hover").siblings().removeClass("hover")}).mouseout(function(){$(this).removeClass("hover").siblings().removeClass("hover")}),$(".chat03_content li").dblclick(function(){var b=$(this).index()+1;
	a=b,c="/webchat/img/head/20"+(12+a)+".jpg",d=$(this).find(".chat03_name").text(),$(".chat01_content").scrollTop(0),$(this).addClass("choosed").siblings().removeClass("choosed"),$(".talkTo a").text($(this).children(".chat03_name").text()),$(".mes"+b).show().siblings().hide()}),$(".ctb01").mouseover(function(){
		$(".wl_faces_box").show()}).mouseout(function(){
			$(".wl_faces_box").hide()}),
			$(".wl_faces_box").mouseover(function(){
				$(".wl_faces_box").show()}).mouseout(function(){
					$(".wl_faces_box").hide()}),$(".wl_faces_close").click(function(){
						$(".wl_faces_box").hide()}),$(".wl_faces_main img").click(function(){
							var a=$(this).attr("src");
							$("#textarea").val($("#textarea").val()+"*#"+a.substr(a.indexOf("img/")+4,6)+"#*"),
							$("#textarea").focusEnd(),$(".wl_faces_box").hide()}),
							$(".chat02_bar img").click(function(){e()}),
							document.onkeydown=function(a){
								var b=document.all?window.event:a;
								return 13==b.keyCode?(e(),!1):void 0},
								$.fn.setCursorPosition=function(a){
									return 0==this.lengh?this:$(this).setSelection(a,a)},
									$.fn.setSelection=function(a,b){
										if(0==this.lengh)
											return this;
										if(input=this[0],input.createTextRange){
											var c=input.createTextRange();
											c.collapse(!0),c.moveEnd("character",b),
											c.moveStart("character",a),
											c.select()}else input.setSelectionRange&&(input.focus(),
													input.setSelectionRange(a,b));
										return this
										},
										$.fn.focusEnd=function(){
											this.setCursorPosition(this.val().length)
											}
										}),
										function(a){a.extend({
												blinkTitle:{show:function(){
													var a=0,b=document.title;
													if(-1==document.title.indexOf("\u3010"))
														var c=setInterval(function(){
															a++,3==a&&(a=1),1==a&&(document.title="\u3010\u3000\u3000\u3000\u3011"+b),
															2==a&&(document.title="\u3010\u65b0\u6d88\u606f\u3011"+b)},500);
	return[c,b]},
	clear:function(a){
		a&&(clearInterval(a[0]),document.title=a[1])
		}
	}})}(jQuery);
	
var changeUser = function(user_name,user_id,user_icon){
	$("#toUserName").text(user_name);
	$("#touserName").val(user_name);
	$("#touserId").val(user_id);
	$("#touserICON").val(user_icon);
	$(".chat01_content").empty().append('<div class="message_box mes1"></div>'+
							'<div class="message_box mes2"></div>'+
							'<div class="message_box mes3" style="display: block;"></div>'+
							'<div class="message_box mes4"></div>'+
							'<div class="message_box mes5"></div>'+
							'<div class="message_box mes6"></div>'+
							'<div class="message_box mes7"></div>'+
							'<div class="message_box mes8"></div>'+
							'<div class="message_box mes9"></div>'+
							'<div class="message_box mes10"></div>')
}

$("#upload").live('click', function(){
	$.ajaxFileUpload({
		url : './upload.do',
		fileElementId:'uploadfile',
		dataType: 'JSON',
		secureuri:false,
		success : function(data, status, msg) {
			var startIndex = data.indexOf(">")+1;
			var endIndex = data.lastIndexOf("</pre>");
			var address = data.substring(startIndex, endIndex);
			address = $.parseJSON(address);
			var name = address.fileName;
			address = address.url;
			var e=new Date,f="";
			f+=e.getFullYear()+"-",f+=e.getMonth()+1+"-",f+=e.getDate()+"  ",f+=e.getHours()+":",f+=e.getMinutes()+":",f+=e.getSeconds();
			
			$.ajax({
				url:"./savefile.do",
				type:"POST",
				async:"true",
				data:{
					"user_id": $.parseJSON($("#loginid").val()).id,
					"url":address,
					"fileName":name,
					"time":f
				},
				success:function(msg){
					if(msg == "Y"){
						alert("文件上传成功！");
					}
				}
			});
		},
		error:function(data, status, e){
			alert(e);
		}
	});
});

$("#count").live('click',function(){
	
	$.ajax({
		url:"./findMessage.do",
		type:"POST",
		async:"true",
		data:{
			"fromid":$.parseJSON($("#loginid").val()).id,
			"toid":$("#touserId").val()
		},
		success:function(msg){
			msg = $.parseJSON(msg);
			$(".chat01_content").empty();
			for(var i = 0; i < msg.length; i++){
				var icon = "";
				var name = "";
				var time = msg[i].chatTime;
				var data = msg[i].chatData;
				var from1 = $.parseJSON($("#loginid").val());
				var from2id = $("#touserId").val();
				var from2Name = $("#touserName").val();
				var from2icon = $("#touserICON").val();
				if(msg[i].fromid == from1.id){
					icon = from1.user_icon;
					name = from1.user_name;
				}else{
					name = from2Name;
					icon = from2icon;
				}
				var html="<div class='message clearfix'><div class='user-logo'><img src='"+icon+"'/>"+"</div>"+"<div class='wrap-text'>"+"<h5 class='clearfix'>"+name+"</h5>"+"<div>"+data+"</div>"+"</div>"+"<div class='wrap-ri'>"+"<div clsss='clearfix'><span>"+time+"</span></div>"+"</div>"+"<div style='clear:both;'></div>"+"</div><div style='clear:both;'></div>";
				$(".chat01_content").append(html);
			}
		}
	});
});

$("#check").live('click', function(){
	$.ajax({
		url:"./findFile.do",
		type:"POST",
		async:"true",
		data:{
			"fileName": $("#checkname").val()
		},
		success:function(msg){
			msg = $.parseJSON(msg);
			$(".chat01_content").empty();
			for(var i = 0; i < msg.length; i++){
				var html="<div class='message clearfix'><a href='"+msg[i].url+"'>"+msg[i].fileName+"</a><div class='user-logo'></div>";
				$(".chat01_content").append(html);
			}
		}
	});
});