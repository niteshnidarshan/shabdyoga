<%@page import="org.json.simple.JSONArray" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%
	response.setContentType("application/json");
	Object object= request.getAttribute("result");
	List list=(List)object;
	JSONArray jsons=new JSONArray();
	
	for(int i=0;i<list.size();i++){
		jsons.add(list.get(i));
	}

	out.println(jsons);
	/*String stt=(String)object;
	JSONArray js=new JSONArray();
	for(int i=1;i<19;i++){
		String s="A"+i;
		js.add(s);
	}
	out.println(js);
	*/
%>