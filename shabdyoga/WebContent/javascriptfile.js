    var xhr;
		try{
				xhr=new ActiveXObject("Msxml2.XMLHTTP");
			}catch(e){
				xhr=new XMLHttpRequest();
			}
		//recaptcha		
         function showRecaptcha(element) {
           Recaptcha.create("6Lf-evsSAAAAAG4BVLPC0sINLFL1QaCm9rXzecrP", element, {
             theme: "orange",
             callback: Recaptcha.focus_response_field});
         }   
         function feedbackValidate(){
         	var feedbackName=document.getElementById("feedbackName").value;
         	
         	var feedbackEmail=document.getElementById('feedbackEmail').value;
         	
         	var feedbackMessage=document.getElementById('feedbackMessage').value;
         	
         	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
         	if(feedbackName==""){
         		alert("Enter Name!");
         		document.getElementById("feedbackNameSpan").innerHTML="Enter Name!";
         	}else if(feedbackEmail==""){
         		alert("Enter your email!");
         		document.getElementById("feedbackEmailSpan").innerHTML="Enter your email!";
         		document.getElementById("feedbackNameSpan").innerHTML="";
         	}else if(!feedbackEmail.match(mailformat)){
         		alert("Wrong email! Enter your correct email!");
         		document.getElementById("feedbackEmailSpan").innerHTML="Wrong email! Enter your correct email!";
         		document.getElementById("feedbackNameSpan").innerHTML="";
         	}else if(feedbackMessage==""){
         		alert("Please write your feedback message!");
         		document.getElementById("feedbackMessageSpan").innerHTML="Please write your feedback message!";
         		document.getElementById("feedbackEmailSpan").innerHTML="";
         		document.getElementById("feedbackNameSpan").innerHTML="";
         	}else{
         		document.getElementById("feedbackMessageSpan").innerHTML="";
         		document.getElementById("feedbackEmailSpan").innerHTML="";
         		document.getElementById("feedbackNameSpan").innerHTML="";
         		feedbackRequest(feedbackName, feedbackEmail, feedbackMessage);
         	}
         }
         function feedbackRequest(feedbackName, feedbackEmail, feedbackMessage){
         	var recaptcha_response_field=document.getElementsByName('recaptcha_response_field')[0].value;	
         	var recaptcha_challenge_field=document.getElementsByName('recaptcha_challenge_field')[0].value;        	
         	xhr.open("POST","submitFeedback.form?recaptcha_challenge_field="+recaptcha_challenge_field+"&recaptcha_response_field="+recaptcha_response_field+"&feedbackName="+feedbackName+"&feedbackEmail="+feedbackEmail+"&feedbackMessage="+feedbackMessage,true);
         	document.getElementById("waits").style.display='block';
         	document.getElementById("submitwait").style.display='block';
         	xhr.onreadystatechange=feedbackResponsi;
         	xhr.send();
         }
         function feedbackResponsi(){                  
         	if(xhr.readyState==4){
         		if(xhr.status==200){
         			var returned=xhr.responseText;
         			document.getElementById("waiting").style.display='none';
         			document.getElementById("waits").style.display='none';
         			document.getElementById("submitwait").style.display='none';
         			if(returned=="Error"){
         				alert("error : wrong captcha entered!\n resubmit feedback. ");
         				document.getElementById("feedbackResulting").innerHTML="error : wrong captcha entered!\n resubmit feedback. ";
         				showRecaptcha('recaptcha_div');
         				document.getElementById("feedbackResulting").innerHTML="";
         			}
         			else{
         				alert("Thank you for your feedback!");
         				document.getElementById("feedbackResulting").innerHTML="Thank you for your feedback!";
         				document.getElementById("feedbackName").value="";
         				document.getElementById("feedbackEmail").value="";
         				document.getElementById("feedbackMessage").value="";
         				showRecaptcha('recaptcha_div');
         				document.getElementById("feedbackResulting").innerHTML="";
         			}
         			
         		}
         	}
         }
		function toggle(xr) {
			if(xr=="x"){
				var ele = document.getElementById("toggleText");
				var text = document.getElementById("displayText");
				if(ele.style.display == "block") {
    			ele.style.display = "none";
  				}
				else {
					ele.style.display = "block";
					document.getElementById("toggleText").innerHTML="<p>Operating System: Windows/ Linux/ MAC.<br>RAM: minimum 512MB.<br>Display resolution: 1366 X 768 pixel.<br>Environment: JAVA.<br>Note: If java is not installed in your machine, try the following link to install JAVA.<br><a href='https://java.com/en/download/index.jsp' target='_new'>https://java.com/en/download/index.jsp</a><br></p><br>";
				}
			}
			else if(xr=="y"){
				var ele = document.getElementById("toggleText");
				var text = document.getElementById("displayText");
				if(ele.style.display == "block") {
    			ele.style.display = "none";
  				}
				else {
					ele.style.display = "block";
					document.getElementById("toggleText").innerHTML="<p style='color:darkorange;'>To download KVR Dictionary, please enter the following information. It will help us to send you updates...<p><div style='width:98%; border-style:solid; border-color:pink; border-width:thin; '><table border='0' width='100%'><tr><td><table><tr><td>Enter name<font color='red'>*</font> : </td><td><input type='text' id='kvrName' width='200px'></td></tr><tr><td>Enter e-mail id<font color='red'>*</font> : </td><td><input type='text' id='kvrEmail' width='200px'></td></tr><tr><td></td><td><input type='submit' id='downloads' value='Download KVR Dictionary' onclick='javascript:downloadRequest(1);'></td></tr></table></td><td><span id='kvrSpan' style='width:500px; text-align:center; background-color:yellow;'></span></td></tr></table></div><br>";
				}
			}
			if(xr=="z"){
				var ele = document.getElementById("toggleText1");
				var text = document.getElementById("displayText1");
				if(ele.style.display == "block") {
    			ele.style.display = "none";				
  				}
				else {
					ele.style.display = "block";
					document.getElementById("toggleText1").innerHTML="<p>Operating System: Windows/ Linux/ MAC.<br>RAM: minimum 128 MB.<br>Display resolution: 1366 X 768 pixel.<br>Environment: JAVA.<br>Note: If java is not installed in your machine, try the following link to install JAVA.<br><a href='https://java.com/en/download/index.jsp' target='_new'>https://java.com/en/download/index.jsp</a><br></p><br>";
				}
			}
			else if(xr=="r"){
				var ele = document.getElementById("toggleText1");
				var text = document.getElementById("displayText1");
				if(ele.style.display == "block") {
    			ele.style.display = "none";
  				}
				else {
					ele.style.display = "block";
					document.getElementById("toggleText1").innerHTML="<p style='color:darkorange;'>To download Brain Remedy game, please enter the following information. It will help us to send you updates...<p><div style='width:98%; border-style:solid; border-color:pink; border-width:thin; '><table border='0' width='100%'><tr><td><table><tr><td>Enter name<font color='red'>*</font> : </td><td><input type='text' id='brName' width='200px'></td></tr><tr><td>Enter e-mail id<font color='red'>*</font> : </td><td><input type='text' id='brEmail' width='200px'></td></tr><tr><td></td><td><input type='submit' id='downloads' value='Download Brain Remedy' onclick='javascript:downloadRequest(2);'></td></tr></table></td><td><span id='brainRemedySpan' style='width:500px; text-align:center; background-color:yellow;'></span></td></tr></table></div><br>";
				}
			}
		}	
		function downloadRequest(x){	
			if(x==1){
				var name=document.getElementById("kvrName").value;
				var email=document.getElementById("kvrEmail").value;
				var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
				if(name==""){
					document.getElementById("kvrSpan").innerHTML="Enter name";
				}
				else if(email==""){
					document.getElementById("kvrSpan").innerHTML="Enter email id";
				}
				else if(!email.match(mailformat)){
					document.getElementById("kvrSpan").innerHTML="wrong email! enter email again.";
				}
				else{
					document.getElementById("hdKvrName").value=name;
					document.getElementById("hdKvrEmail").value=email;
					var xx=document.getElementById("kvrDownload");
					
					xx.submit(this);
					document.getElementById("kvrSpan").innerHTML="Thank you for downloading KVR Dictionary.";
				}
			}
			else{
				var name=document.getElementById("brName").value;
				var email=document.getElementById("brEmail").value;
				var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
				if(name==""){
					document.getElementById("brainRemedySpan").innerHTML="Enter name";
				}
				else if(email==""){
					document.getElementById("brainRemedySpan").innerHTML="Enter email id";
				}
				else if(!email.match(mailformat)){
					document.getElementById("brainRemedySpan").innerHTML="wrong email! enter email again.";
				}
				else{
					document.getElementById("brainName").value=name;
					document.getElementById("brainEmail").value=email;
					
					var xx=document.getElementById("brainRemedyDownload");
					xx.submit(this);
					document.getElementById("brainRemedySpan").innerHTML="Thank you for downloading Brain Remedy!";
				}
			}
		}
		function kvrRequest(){			
			xhr.open("GET","kvrDictionary.form",true);
			document.getElementById("waits").style.display='block';
			xhr.onreadystatechange=kvrResponse;
			xhr.send();
		}
		function kvrResponse(){
			if(xhr.readyState==4){			
				if(xhr.status==200){			
					document.getElementById("kvrSpan").innerHTML=xhr.responseText;
					document.getElementById("waiting").style.display='none';
					document.getElementById("waits").style.display='none';
				}
			}
		}
		function feedback(){
			xhr.open("POST","feedback.form",true);
			document.getElementById("waits").style.display='block';
			xhr.onreadystatechange=feedbackResponse;
			xhr.send();			
		}
		function feedbackResponse(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					document.getElementById("mainDiv").innerHTML=xhr.responseText;
					showRecaptcha('recaptcha_div');
					document.getElementById("waiting").style.display='none';
					document.getElementById("waits").style.display='none';
				}
			}
		}
		function aboutRequest(){
			xhr.open("POST","about.form",true);
			xhr.onreadystatechange=aboutResponse;
			xhr.send();
		}
		function aboutResponse(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					document.getElementById("mainDiv").innerHTML=xhr.responseText;
				}
			}
		}
		function helpRequest(){
			xhr.open("POST","help.form",true);
			xhr.onreadystatechange=helpResponse;
			xhr.send();
		}
		function helpResponse(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					document.getElementById("mainDiv").innerHTML=xhr.responseText;
				}
			}
		}
		function careersRequest(){
			xhr.open("POST","careers.form",true);
			xhr.onreadystatechange=careersResponse;
			xhr.send();
		}
		function careersResponse(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					document.getElementById("mainDiv").innerHTML=xhr.responseText;
				}
			}
		}
		function termsRequest(){
			xhr.open("POST","terms.form",true);
			xhr.onreadystatechange=termsResponse;
			xhr.send();
		}
		function termsResponse(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					document.getElementById("mainDiv").innerHTML=xhr.responseText;
				}
			}
		}
		function developers(){
			xhr.open("POST","developers.form",true);
			document.getElementById("waits").style.display='block';
			xhr.onreadystatechange=developersResponse;
			xhr.send();
		}
		function developersResponse(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					document.getElementById("mainDiv").innerHTML=xhr.responseText;
					document.getElementById("waiting").style.display='none';
					document.getElementById("waits").style.display='none';
				}
			}
		}
		function createRequest(){			
			xhr.open("POST","one.form",true);
			document.getElementById("waits").style.display='block';
			xhr.onreadystatechange=processResponse;
			xhr.send();
		}
		function processResponse(){
			if(xhr.readyState==4){			
				if(xhr.status==200){			
					document.getElementById("mainDiv").innerHTML=xhr.responseText;
					document.getElementById("waiting").style.display='none';
					document.getElementById("waits").style.display='none';
				}
			}
		}
		function desktopRequest(){
			xhr.open("POST","desktopapp.form",true);
			document.getElementById("waits").style.display='block';
			xhr.onreadystatechange=desktopResponse;
			xhr.send();
		}
		function desktopResponse(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					document.getElementById("mainDiv").innerHTML=xhr.responseText;
					document.getElementById("waiting").style.display='none';
					document.getElementById("waits").style.display='none';
				}
			}
		}
		function getSession(vary){
			//document.getElementById("loadImage").innerHTML="loading...!";
			xhr.open("POST","mywords.form?value="+vary,true);
			document.getElementById("waits").style.display='block';
			xhr.onreadystatechange=sessionResponse;
			xhr.send();
		}
		function sessionResponse(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					document.getElementById("mainDiv").innerHTML=xhr.responseText;
					document.getElementById("waiting").style.display='none';
						document.getElementById("waits").style.display='none';
				}
			}
		}
		function dropDown(ets){				
			xhr.open("POST","main.form?searchString="+ets,true);
			document.getElementById("waits").style.display='block';
			xhr.onreadystatechange=dropDownResponse;
			xhr.send();
		}
		function dropDownResponse(){
			if(xhr.readyState==4){					
					if(xhr.status==200){					
						var sets=xhr.responseText;
						document.getElementById("mainDiv").innerHTML=sets;
						document.getElementById("waiting").style.display='none';
						document.getElementById("waits").style.display='none';
					}
			}
		}
		function listFunction(values){
				var url="lister.form?val="+values;
				document.getElementById("waiting").style.display='block';
				xhr.open("POST",url,true);		
				xhr.onreadystatechange=listCall;
				xhr.send();
		}
		function listCall(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					var jsonObj=JSON.parse(xhr.responseText);
					if(jsonObj.length<=18){
						var lengths=18-jsonObj.length;
						for(var lo=1;lo<lengths;lo++){
							document.getElementById('span'+lo).innerHTML=null;
						}
					}
					for(var i=0;i<jsonObj.length;i++){
						var x=i+1;
						document.getElementById('span'+x).innerHTML=jsonObj[i];	
					}
					document.getElementById("waiting").style.display='none';
				}
			}
		}
		function dropDowns(ets){	
			xhr.open("POST","main.form?searchString="+ets,true);
			document.getElementById("waits").style.display='block';
			xhr.onreadystatechange=dropDownResponses;				
			xhr.send();
		}
		function dropDownResponses(){
			if(xhr.readyState==4){								
					if(xhr.status==200){					
					var sets=xhr.responseText;
						document.getElementById("sessionDiv").innerHTML=sets;						
						document.getElementById("wordas").innerHTML="...";
						document.getElementById("wordw").innerHTML="...";
						document.getElementById("waits").style.display='none';
						document.getElementById("waiting").style.display='none';
					}
			}
		}
		
function listing(){
	var vs=document.getElementById('textclass1').value.trim();
	var vst=document.getElementById('textclass1').value.trim().length;
	if(vst>=1){
		listFunction(vs);
	}
	else{
					for(var i=0;i<18;i++){
						var x=i+1;
						document.getElementById('span'+x).innerHTML="";
					}
	}
}	
function doPostBack(eventTarget, eventArgument) {
	var v=document.getElementById('textclass1').value;	
	btnClicking(v);
}
function keyCheck(iKeyCode, sFunc, e)
{
	listing();
	if (e == null){
		e = window.event;		
	}
	if (e.keyCode == iKeyCode)
	{	
		eval(unescape(sFunc));
		return false;
	}
}
function btnClicking(variable){
	if(variable.trim()!=""){
		dropDown(variable);
	}
	else{
		alert("enter word!");
	}
}
function enters(){
	var searcher=document.getElementById('textclass1').value.trim();
	if(searcher!="")
	{
		btnClicking(searcher);
	}
	else{
		alert("enter word!");
	}
}
function generate(spans){
	var variables=document.getElementById(spans).innerHTML;
	if(variables!=""){
		document.getElementById('textclass1').value=variables;
		dropDown(variables);
	}
	else{
		alert("enter word...");
	}
}
function generated(z){
	var sx=document.getElementById('spany'+z).innerHTML;
	document.getElementById('textclass1').value=sx;
	btnClicking(sx);
}
function generateds(z){	
	var sx=document.getElementById('spany'+z).innerHTML;
	document.getElementById('textclass1').value=sx;
	dropDowns(sx);
}
function showMe(){
		var pos=document.getElementById("myself");
		if(pos.style.display=="none")
			document.getElementById("myself").style.display='block';
		else
			document.getElementById("myself").style.display='none';
	}