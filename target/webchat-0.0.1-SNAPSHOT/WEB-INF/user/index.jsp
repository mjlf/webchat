<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<link href="/webchat/css/style.css" rel='stylesheet' type='text/css' />
<script type="text/javascript" src="/webchat/js/jquery-1.3.2.js"></script>
<script type="text/javascript" src="/webchat/js/index.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfonts-->
<!--//webfonts-->
</head>
<body>
	<div class="main">
		<div class="header">
			<h1>Login or Create a Free Account!</h1>
		</div>
		<p>Lorem iopsum dolor sit amit,consetetur sadipscing eliter,sed
			diam voluptua.At vero eso et accusam et justo duo dolores et ea
			rebum.</p>
		<form>
			<ul class="left-form">
				<h2>New Account:</h2>
				<li><input type="text" placeholder="Username" id="user_name"
					required /> <a href="#" class="icon ticker"> </a>
					<div class="clear"></div></li>
				<li><input type="text" placeholder="Email" id="user_email"
					required /> <a href="#" class="icon ticker"> </a>
					<div class="clear"></div></li>
				<li><input type="password" placeholder="password"
					id="user_password" required /> <a href="#" class="icon into"> </a>
					<div class="clear"></div></li>
				<li><input type="password" placeholder="password"
					id="user_repassword" required /> <a href="#" class="icon into">
				</a>
					<div class="clear"></div></li>
				<label class="checkbox"><input type="checkbox"
					name="checkbox" checked=""><i> </i>Please inform me of
					upcoming w3layouts, Promotions and news</label>
				<input type="submit" value="Create Account" id="regist">
				<div class="clear"></div>
			</ul>
			</from>
			<from>
			<ul class="right-form">
				<h3>Login:</h3>
				<div>
					<li><input type="text" placeholder="Username" required
						id="login_user_name" /></li>
					<li><input type="password" placeholder="Password" required
						id="login_user_password" /></li>
					<h4>I forgot my Password!</h4>
					<input type="submit" value="Login" id="login">
				</div>
				<div class="clear"></div>
			</ul>
			<div class="clear"></div>
		</form>
	</div>
</body>
</html>