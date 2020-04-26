package shabd.yoga.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import shabd.yoga.beans.FileReadPronun;

public class MainFilter implements Filter {
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		arg2.doFilter(req, response);
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		ServletContext context=arg0.getServletContext();
		String path=context.getRealPath("");
		//System.out.println(path);
		//FileReadPronun fp=new FileReadPronun();
		Map<String,String> pronunMap=FileReadPronun.getPronunMap(path);
		context.setAttribute("pronunContext", pronunMap);
		Map<String,String> bigHindiMap=FileReadPronun.getbigHindiMap(path);
		context.setAttribute("bigHindiContext", bigHindiMap);
		Map<String,String> urduMap=FileReadPronun.getUrduMap(path);
		context.setAttribute("urduContext", urduMap);
		Map<String,String> englishMap=FileReadPronun.getEnglishMap(path);
		context.setAttribute("englishContext", englishMap);
		Map<String,String> similarMap=FileReadPronun.getSimilarMap(path);
		context.setAttribute("similarContext", similarMap);
		//System.out.println(englishMap);
		//System.out.println("file loaded!!!");
		
	}


}
