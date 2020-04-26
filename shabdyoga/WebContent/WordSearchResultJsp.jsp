<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.Map" %>
<%@page import="java.util.Set" %>
<%
	response.setContentType("text/html;charset=UTF-8");
 	Object o=request.getAttribute("result");
	Map<String,String> resultMap=(Map)o;
	//out.println("<div style='margin-top:100px;'>");
	//out.println(resultMap);
	//<hr style='background-color:orange; height:0.9px; border:none'>
	String showPronun=resultMap.get("pronunKey");
 	String showBigHindi=resultMap.get("bigHindiKey");
 	String showUrdu=resultMap.get("urduKey");
 	String showEnglish=resultMap.get("englishKey");
 	String showSimilar=resultMap.get("similarKey");
 	String words=resultMap.get("word");
 	Set<String> set=new java.util.TreeSet<String>();
 	Object object=session.getAttribute("wordHistory");
 	set=(Set)object;
 	set.add(words);
 	session.setAttribute("wordHistory", set);
 	String word=Character.toUpperCase(words.trim().charAt(0))+words.trim().substring(1);
 	out.println("<div style='margin-left:27%; margin-top:28px; font-size:18px; color:black;'>");
 	out.println("<div id='words' style='width:80%; background-color:lightpink; color:white;'>"+word+" -in Hindi meaning</div>");
 	 	
 	if(!showBigHindi.equals("not found!")){
 	CharSequence first="#@#";
 	CharSequence second="##";
 	CharSequence third="@@";
 	String firstSeperator[];
 	String secondSeperator[];
 	String thirdSeperator[];
 	String resultString="";
 	if(showBigHindi.contains(first)){
 		firstSeperator=showBigHindi.split("#@#");
 		String resultString2="";
 		for(int i=0;i<firstSeperator.length;i++){
 			//if(firstSeperator[i].contains(second)){
 				secondSeperator=firstSeperator[i].split("##	-");
 				resultString2=resultString2+"<i><font color='darkblue' size='2'><u>"+secondSeperator[0]+".</u></font></i> ";
 				thirdSeperator=secondSeperator[1].split("@@");
 				String main="";
 				for(int j=0;j<thirdSeperator.length;j++){
 					main=main+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+thirdSeperator[j]+"<br>";
 				}
 				//main=main;
 				resultString2=resultString2+main;
 			}
 			resultString=resultString+resultString2;
 		}
 		
 		else{
 		secondSeperator=showBigHindi.split("##	-");
 				resultString=resultString+"<i><font color='darkblue' size='2'><u>"+secondSeperator[0]+".</u></font></i>  ";
 				thirdSeperator=secondSeperator[1].split("@@");
 				String main="";
 				for(int j=0;j<thirdSeperator.length;j++){
 					main=main+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+thirdSeperator[j]+"<br>";
 				}
 				//main=main;
 				resultString=resultString+main;
 		}
 	
 	out.println("<div style='width:700px; margin-bottom:18px; font-size:16px; font-family:hindi;'>"+resultString+"</div>");
 	}
 	else{
 		out.println("<div style='width:700px; margin-bottom:24px; margin-top:24px; font-size:16px;'>not found!</div>");
 	}
 	out.println("<div id='words' style='width:80%; background-color:lightpink; color:white;'>"+word+" -in Urdu meaning</div>");
 	if(!showUrdu.equals("not found!")){
 		CharSequence sc="@@";
 		CharSequence sct="##";
 		String results="";
 		if(showUrdu.contains(sc)){
 			String firstSeperate[]=showUrdu.split("@@");
 			for(int i=0;i<firstSeperate.length;i++){
 				if(firstSeperate[i].contains(sct)){
 					String secondSeperate[]=firstSeperate[i].split("##");
 					String st=secondSeperate[0].toLowerCase().trim();
 					String speech=Character.toUpperCase(st.trim().charAt(0))+st.trim().substring(1);
 					results=results+"<i><font color='darkblue' size='2'><u>"+speech+"</u></font></i> &nbsp;&nbsp;&nbsp;"+secondSeperate[1]+"<br>";
 					
 				}
 			}
 			
 		}
 		else{
 			if(showUrdu.contains(sct)){
 					String seperate[]=showUrdu.split("##");
 					String st=seperate[0].toLowerCase().trim();
 					String speech=Character.toUpperCase(st.trim().charAt(0))+st.trim().substring(1);
 					results=results+"<i><font color='darkblue' size='2'><u>"+speech+"</u></font></i> &nbsp;&nbsp;&nbsp;"+seperate[1];
 					
 				}
 				else{
 					results=results+showUrdu;
 				}
 		}
 	
 	out.println("<div style='width:700px;margin-top:22px; margin-bottom:22px; font-size:16px;'>"+results+"</div>");
 	}
 	else{
 		out.println("<div style='width:700px; margin-bottom:24px; margin-top:24px; font-size:16px;'>not found!</div>");
 	}
 	out.println("<div id='words' style='width:80%; background-color:lightpink; color:white;'>"+word+" -in English meaning</div>");
 	if(!showPronun.equals("not found!")){
 	out.println("<br><span style='color:darkblue;font-family:phon;'><b>/"+showPronun+"/</b></span>");
 	} 	
 	if(!showEnglish.equals("not found!")){
 		CharSequence cst="<br>";
 		String results="";
 		String showEnglishs=Character.toUpperCase(showEnglish.trim().charAt(0))+showEnglish.trim().substring(1);
 		if(showEnglish.contains(cst)){
 			String strings[]=showEnglishs.split("<br>");
 			for(int i=0;i<strings.length;i++){
 				if(!strings[i].trim().equals(".")){
 				strings[i]=strings[i].toUpperCase();
 				strings[i]=(strings[i].substring(0,1)).toUpperCase()+(strings[i].substring(1,strings[i].length())).toLowerCase();
 				results=results+strings[i]+"<br>";
 				}
 			}
 		}else{
 			out.println("<div style='width:700px; margin-top:18px; font-size:16px;'>"+showEnglishs+"</div>");
 		}
 		 		
 		out.println("<div style='width:700px; margin-top:18px; font-size:16px;'>"+results+"</div>");
 	}
 	else{
 		out.println("<div style='width:700px; margin-bottom:24px; margin-top:24px; font-size:16px;'>not found!</div>");
 	}
		 	
 	if(!showSimilar.equals("not found!")){
 		CharSequence cs=",";
 		String result="";
 		if(showSimilar.contains(cs)){
 			String stringSeperated[]=showSimilar.split(",");
 			for(int i=0;i<stringSeperated.length;i++){
 				String str=stringSeperated[i].trim().toLowerCase();
 				result=result+"<a href='javascript:generated("+i+")' style='text-decoration:none;'><span id=spany"+i+">"+str+"</span></a> <span style='color:purple'>|</span> ";
 				if(i==53)
 					break;
 			}
 		}
 		out.println("<div id='wordw' style='width:80%; background-color:lightpink; margin-top:18px; color:white;'>"+word+" -related words...</div><div id='wordas' style='width:700px; margin-top:18px; font-size:14px; color:blue; '>"+result+"</div>");
 	}
 	
 	out.println("<br><hr style='background-color:orange; height:0.9px; width:80%; margin-left:0px; border:none'>");
 	out.println("<span style='font-size:14px; color: darkgray;'>shabdyoga © 2014</span>"); 	
 	out.println("</div>");
 	
%>
