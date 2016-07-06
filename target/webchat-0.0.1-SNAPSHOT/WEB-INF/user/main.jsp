<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>JS在线聊天对话框网页特效</title>
<link rel="stylesheet" type="text/css" href="/webchat/css/chat.css" />
<script type="text/javascript" src="/webchat/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/webchat/js/chat.js"></script>
<script src="/webchat/js/websocket.js" type="text/javascript"></script>
<script src="/webchat/js/ajaxfileupload.js" type="text/javascript"></script>
<!--[if lt IE 7]>
<script src="/webchat/js/IE7.js" type="text/javascript"></script>
<![endif]-->
<!--[if IE 6]>
<script src="/webchat/js/iepng.js" type="text/javascript"></script>
<script type="text/javascript">
EvPNG.fix('body, div, ul, img, li, input, a, span ,label'); 
</script>
<![endif]-->
</head>
<body class="keBody">
	<h1 class="keTitle">JS在线聊天对话框网页特效</h1>
	<div class="kePublic">
		<!--效果html开始-->
		<div class="content">
			<div class="chatBox">
				<div class="chatLeft">
					<div class="chat01">
						<div class="chat01_title">
							<ul class="talkTo">
								<li><a href="javascript:;" id="toUserName">${myName}</a></li>
							</ul>
							<a class="close_btn" href="javascript:;"></a>
						</div>
						<div class="chat01_content">
							<div class="message_box mes1"></div>
							<div class="message_box mes2"></div>
							<div class="message_box mes3" style="display: block;"></div>
							<div class="message_box mes4"></div>
							<div class="message_box mes5"></div>
							<div class="message_box mes6"></div>
							<div class="message_box mes7"></div>
							<div class="message_box mes8"></div>
							<div class="message_box mes9"></div>
							<div class="message_box mes10"></div>
						</div>
					</div>
					<div class="chat02">
						<div class="chat02_title">
							<a class="chat02_title_btn ctb01" href="javascript:;"></a>
								
								<a href="javascript:;" class="file1 chat02_title_btn ctb03" title="选择文件">
									    <input type="file" name="uploadfile" id="uploadfile">
								</a>
								
								<a href="javascript:;" class="chat02_title_btn ctb04" title="选择文件">
									    <input type="button" name="上传" value="上传" id="upload">
								</a>
							<label class="chat02_title_t"> <a href="chat.htm" target="_blank">聊天记录</a></label>
							<div class="wl_faces_box">
								<div class="wl_faces_content">
									<div class="title">
										<ul>
											<li class="title_name">常用表情</li>
											<li class="wl_faces_close"><span>&nbsp;</span></li>
										</ul>
									</div>
									<div class="wl_faces_main">
										<ul>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_01.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_02.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_03.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_04.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_05.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_06.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_07.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_08.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_09.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_10.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_11.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_12.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_13.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_14.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_15.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_16.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_17.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_18.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_19.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_20.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_21.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_22.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_23.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_24.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_25.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_26.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_27.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_28.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_29.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_30.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_31.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_32.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_33.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_34.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_35.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_36.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_37.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_38.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_39.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_40.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_41.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_42.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_43.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_44.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_45.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_46.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_47.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_48.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_49.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_50.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_51.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_52.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_53.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_54.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_55.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_56.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_57.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_58.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_59.gif" /></a></li>
											<li><a href="javascript:;"> <img
													src="/webchat/img/emo_60.gif" /></a></li>
										</ul>
									</div>
								</div>
								<div class="wlf_icon"></div>
							</div>
						</div>
						<div class="chat02_content">
							<textarea id="textarea"></textarea>
						</div>
						<div class="chat02_bar">
							<ul>
								<li style="left: 20px; top: 10px; padding-left: 30px;">来源：<a
									href="http://www.internetke.com/" target="_blank">科e互联</a></li>
								<li style="right: 5px; top: 5px;" id="send"><a
									href="javascript:;"> <img src="/webchat/img/send_btn.jpg"></a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="chatRight">
					<div class="chat03">
						<div class="chat03_title">
							<label class="chat03_title_t"> 成员列表</label>
						</div>
						<div class="chat03_content">
							<ul>
								<c:forEach var="user" items="${alluser}">
									<li id="user_${user.id }" onclick='changeUser("${user.user_name}","${user.id }","${user.user_icon }");'><label class="online"> </label> <a href="javascript:;">
											<img src="${user.user_icon}">
									</a><a href="javascript:;" class="chat03_name">${user.user_name}</a>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
				<div style="clear: both;"></div>
			</div>
		</div>
		<input type="text" style="display: none" id="loginid" style="display: none" />
		<input type="text" style="display: none" id="touserId" value="${toUserId }"/>
		<input type="text" style="display: none" id="touserName" value="${myName }"/>
		<input type="text" style="display: none" id="touserICON" value="${toUserICON }"/>
		<script type="text/javascript">
			 function _s() {  
		        var f = document.getElementById("image").files;  
		        //上次修改时间  
		        alert(f[0].lastModifiedDate);  
		        //名称  
		        alert(f[0].name);  
		        //大小 字节  
		        alert(f[0].size);  
		        //类型  
		        alert(f[0].type);  
		    }
	</script>
	</div>
</body>
</html>
