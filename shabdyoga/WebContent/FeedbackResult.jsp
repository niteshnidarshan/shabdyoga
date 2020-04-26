
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page session="false" %>
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>

<%/*
<div style="width:100%; height:768px; margin-top:22px; background-color:transparent; color: darkblue;">
<div style="margin-left:100px;">
	<br>
	<div style="font-family: sans-serif; font-weight:100; font-size: 30px;">
	What do you think about shabdyoga.com,<br> What are the changing do you want here,<br>Please write your valuable feedback to us...<br><br>
	</div>
	<div style="width:50%; margin-left:200px; heigh:600px; border-style: solid; border-width:1px; border-radius:9px; border-color: darkorange;">
		<div style=" margin: 10px;">
		<form name="form1" method="post" onsubmit="getxmlHttpRequest('app.form', 'form1', 'message', 'please wait...'); return false;">
		<input type="text" name="name" placeholder="Your name" style="width: 250px; height: 30px; "><br><br>
		<input type="text" name="email" placeholder="Your email" style="width: 250px; height: 30px;"><br><br>
		<input type="text" name="codes" placeholder="verification code" style="width: 250px; height: 30px;"><br><br>
		<tags:captcha privateKey="6LfE1foSAAAAAEF3NMHB-z8ekmF8Wx_Pd3FYh7Kk" publicKey="6LfE1foSAAAAAACotLgN3kFl9zADnE8Beb2yqDDa"></tags:captcha>
		<textarea placeholder="Your message..." name="feedbackMessage" rows="5" cols="60"></textarea><br><br>
		<div style="text-align:center;"><input type="submit" value="submit" id="feed" title="submit your feedback"></div>
		</form>
		</div>
		<div id="message"></div>
	</div> <br>
	<br><hr style='background-color:orange; height:0.9px; width:80%; margin-left:0px; border:none'>
		<span style='font-size:14px; color: darkgray;'>shabdyoga © 2014</span>
</div>
</div>*/

%>
<div style="width:100%; height:768px; margin-top:22px; background-color:transparent; color: darkblue;">
<div style="margin-left:100px;">
	<br>
	<div style="font-family: sans-serif; font-weight:100; font-size: 30px;">
	What do you think about shabdyoga.com,<br> What are the changing do you want here,<br>Please write your valuable feedback to us...<br><br>
	</div>
	<div style="width:50%; margin-left:200px; heigh:600px; border-style: solid; border-width:1px; border-radius:9px; border-color: darkorange;">
		<div style=" margin: 10px;">
		<form name="form1" method="post" onsubmit="getxmlHttpRequest('app.form', 'form1', 'message', 'please wait...'); return false;">
		<input type="text" name="name" placeholder="Your name" style="width: 250px; height: 30px; "><br><br>
		<input type="text" name="email" placeholder="Your email" style="width: 250px; height: 30px;"><br><br>
		<input type="text" name="codes" placeholder="verification code" style="width: 250px; height: 30px;"><br><br>
		<div id="recaptcha_div"></div>
		<%
			//ReCaptcha cp = ReCaptchaFactory.newReCaptcha("6LfW1_oSAAAAAJZX5-CV0GyvxLUHlpL0Z0vnpE2K", "6LfW1_oSAAAAAC0woETswaALkY9XqNHJeYRF9AF4", false);
			//cp.createRecaptchaHtml(null, null);
		%>
		<textarea placeholder="Your message..." name="feedbackMessage" rows="5" cols="60"></textarea><br><br>
		<div style="text-align:center;"><input type="submit" value="submit" id="feed" title="submit your feedback"></div>
		</form>
		</div>
		<div id="message"></div>
	</div> <br>
	<br><hr style='background-color:orange; height:0.9px; width:80%; margin-left:0px; border:none'>
		<span style='font-size:14px; color: darkgray;'>shabdyoga © 2014</span>
</div>
</div>