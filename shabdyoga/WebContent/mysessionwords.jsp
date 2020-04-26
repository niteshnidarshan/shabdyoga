<%@page import="java.util.List" %>
<%
	Object object=request.getAttribute("result");
	List<String> list=(List)object;
	int clears=1;
	out.println("<div style='margin-left:27%; margin-top:28px; font-size:18px; color:black;'>");
 	out.println("<div id='wordss' style='width:80%; background-color:lightpink; color:white;'><table style='width:100%'><tr><td>My searched history...</td><td  style='text-align:right; color:darkblue;'><a href='javascript:getSession(1)' style='text-decoration:none;' title='Click here to remove all the history'>Clear history</a></td></tr></table></div>");
 	String result="";
 	if(list.size()==0){
 		out.println("<div style='width:700px; margin-top:18px; font-size:14px; color:blue; '>No words...</div>");
 	}
 	else if(list.get(0).equals("No words...")){
 		out.println("<div style='width:700px; margin-top:18px; font-size:14px; color:blue; '>No words...</div>");
 	}
 	else{
	 	for(int i=0;i<list.size();i++){
	 		String str=list.get(i).toLowerCase().trim();
	 		result=result+"<a href='javascript:generateds("+i+")' style='text-decoration:none;'><span id=spany"+i+">"+str+"</span></a> <span style='color:purple'>|</span> ";
	 	}
	 	out.println("<div style='width:700px; margin-top:18px; font-size:14px; color:blue; '>"+result+"</div>");
	 }
 	out.println("<br><hr style='background-color:orange; height:0.9px; width:80%; margin-top:11px; margin-left:0px; border:none'>");
 	out.println("</div>");
 	out.println("<div id='sessionDiv' style='margin-left:0px;'></div>");
 	
%>