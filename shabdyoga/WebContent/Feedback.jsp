<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page session="false" %>
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
<div style="width:100%; height:768px; margin-top:22px; background-color:transparent; color: darkblue;">
<div style="margin-left:100px;">
	<br>
	<div style="font-family: sans-serif; font-weight:100; font-size: 30px;">
	What do you think about shabdyoga.com,<br> What are the changing do you want here,<br>Please write your valuable feedback to us...<br><br>
	</div>
	<div style="width:50%; margin-left:200px; heigh:600px; border-style: solid; border-width:1px; border-radius:9px; border-color: darkorange;">
		<div style=" margin: 10px;">
		<form action="app.form" method="post">
		<input type="text" name="feedbackName" id="feedbackName" placeholder="Your name" style="width: 250px; height: 30px; ">&nbsp;&nbsp;<span id="feedbackNameSpan" style="color:red;"></span><br><br>
		<input type="text" name="feedbackEmail" id="feedbackEmail" placeholder="Your email" style="width: 250px; height: 30px;">&nbsp;&nbsp;<span id="feedbackEmailSpan" style="color:red;"></span><br><br>
		<span id="feedbackMessageSpan" style="color:red;"></span>
		<textarea name="feedBackMessage" id="feedbackMessage" placeholder="Your message..." rows="5" cols="60"></textarea><br>
		<div id="recaptcha_div"><div id="captchaLoading">Captcha<br><img src="images/loading_white.gif" width="300px" ></div></div>&nbsp;&nbsp;&nbsp;<div id="submitwait" style="text-align:center; display:none;"><img src="images/please_wait.gif" width="300px" ></div><br>
		<div id="feedbackResulting" style="color:red;"></div>
		<div style="text-align:center;"><input type="button" onclick="javascript:feedbackValidate()" value="submit" id="feed" title="submit your feedback"></div>
		</form>
		
		</div>
		
	</div> <br>
	<br><hr style='background-color:orange; height:0.9px; width:80%; margin-left:0px; border:none'>
		<span style='font-size:14px; color: darkgray;'>shabdyoga © 2014</span>
<!-- 		
<center>
		
<form name="form1" method="post" onsubmit="getxmlHttpRequest('app.form', 'form1', 'message', 'please wait...'); return false;">

<TEXTAREA NAME="address" ROWS=3 COLS=40></TEXTAREA><BR>
<label> <br />
<input name="checkbox" type="checkbox" id="checkbox" value="True" /> CheckBox</input><br><br>
<input type="text" name="n2">

</label>
<input type="submit" value="submit"/>
</form>
<div id="message"></div>
<br>
<br>
</center>
-->
</div>
</div>