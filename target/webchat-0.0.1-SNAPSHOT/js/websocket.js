var Chat = {};
Chat.socket = null;

Chat.connect = (function(host) {
	if ('WebSocket' in window) {
		Chat.socket = new WebSocket(host);
	} else if ('MozWebSocket' in window) {
		Chat.socket = new MozWebSocket(host);
	} else {
		return;
	}

	Chat.socket.onopen = function() {
		$.ajax({
			type: "GET",
			async:'true',
			url: "./finduserlogined.do",
			success:function(msg){
				$("#loginid").val(msg);
				msg=$.parseJSON(msg);
				Chat.socket.send("!!<<id>>!!:"+msg.id);
			}
		});
		
		$("#send").live('click', function(){
			_s();
			var user = $.parseJSON($("#loginid").val());
			var toUser = $("#touserId").val();
			var e=new Date,f="";
			f+=e.getFullYear()+"-",f+=e.getMonth()+1+"-",f+=e.getDate()+"  ",f+=e.getHours()+":",f+=e.getMinutes()+":",f+=e.getSeconds();
			var info = "";
			var from = "<###>"+user.id+"<###>";
			var to = "<!!!>"+toUser+"<!!!>";
			var data = "<|||>"+$("#textarea").val()+"<|||>";
			var time = "<***>"+f+"<***>";
			info = from + to + time + data;
			
			$.ajax({
			type: "POST",
				async:'true',
				url: "./savemessage.do",
				data:{
					"fromid":user.id,
					"toid":toUser,
					"time":f,
					"data":$("#textarea").val()
				},
				success:function(msg){
					if(msg == 'Y')
					Chat.socket.send(info);
					$("#textarea").val("");
				}
			});
			
		});
	};

	Chat.socket.onclose = function() {
		alert("close");
	};
	
	Chat.socket.onerror = function() {
		alert("onerror");
	};
	
	Chat.socket.onmessage = function(message) {
		var messageData = message.data;
		var startIndex = 5;
		var endIndex = messageData.lastIndexOf("<###>");
		var from = messageData.substring(startIndex, endIndex);
		
		startIndex = messageData.indexOf("<!!!>")+5;
		endIndex = messageData.lastIndexOf("<!!!>");
		var to = messageData.substring(startIndex, endIndex);
		
		startIndex = messageData.indexOf("<***>")+5;
		endIndex = messageData.lastIndexOf("<***>");
		var time = messageData.substring(startIndex, endIndex);
		
		startIndex = messageData.indexOf("<|||>")+5;
		endIndex = messageData.lastIndexOf("<|||>");
		var data = messageData.substring(startIndex, endIndex);
		
		var user = $.parseJSON($("#loginid").val());
		var toUser = $("#touserId").val();
		
		if(data.indexOf("*#")>=0){
			startIndex = data.indexOf("*#")+2;
			endIndex = data.indexOf("#*");
			var re = data.substring(startIndex-2, endIndex+2);
			var info = data.substring(startIndex, endIndex);
			data = data.replace(re,'<img src="/webchat/img/'+info+'.gif">');
		}
		
		if(to == user.id && from == toUser){
			var i="<div class='message clearfix'><div class='user-logo'><img src='"+$("#touserICON").val()+"'/>"+"</div>"+"<div class='wrap-text'>"+"<h5 class='clearfix'>"+$("#touserName").val()+"</h5>"+"<div>"+data+"</div>"+"</div>"+"<div class='wrap-ri'>"+"<div clsss='clearfix'><span>"+time+"</span></div>"+"</div>"+"<div style='clear:both;'></div>"+"</div><div style='clear:both;'></div>";
			$(".chat01_content").append(i);
		}
	};
});


Chat.initialize = function() {
	if (window.location.protocol == 'http:') {
		Chat.connect('ws://' + window.location.host + '/webchat/user/websocket.do');
	} else {
		Chat.connect('wss://' + window.location.host + '/webchat//websocket.do');
	}
};


Chat.initialize();