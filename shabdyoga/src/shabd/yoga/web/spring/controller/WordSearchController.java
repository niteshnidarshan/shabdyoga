package shabd.yoga.web.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shabd.yoga.beans.DropDownBean;

@Controller
public class WordSearchController {
	Set dropDownSet=null;
	
	List<String> sessionList;
	@RequestMapping(value="main", method=RequestMethod.POST)
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response){
		HttpSession session=request.getSession(true);
		ServletContext context=session.getServletContext();
		String s=request.getParameter("searchString").trim().toLowerCase();
		Set<String> wordSet=new TreeSet<String>();
		
		//this will check in session that 'wordHistory' attribute is there or not
		//If there then get the set object from session and add new searched word
		//else 'wordHistory' exists already.
		if(session.getAttribute("wordHistory")==null){
			
			session.setAttribute("wordHistory", wordSet);
			
		}
		
			
		
		//sessionList=new ArrayList();
		//if(!s.equals(null))
			//session.setAttribute(s, s);
			//session.setAttribute("session", "session");
			//List list=(List)session.getAttribute("myWords");
			//List listing=(List)session.getAttribute("myWords",);
			//listing.add(s);
			
			//session.setAttribute("myWords",listing);
			
			
			
			Map<String, String> pronunMap=(Map)context.getAttribute("pronunContext");
			String pronun=pronunMap.get(s);
			Map<String, String> bigHindiMap=(Map)context.getAttribute("bigHindiContext");
			String bigHindi=bigHindiMap.get(s);
			Map<String, String> urduMap=(Map)context.getAttribute("urduContext");
			String urdu=urduMap.get(s);
			Map<String,String> englishMap=(Map)context.getAttribute("englishContext");
			String english=englishMap.get(s);
			Map<String,String> similarMap=(Map)context.getAttribute("similarContext");
			String similar=similarMap.get(s);
			Map<String, String> resultResponse=new TreeMap<String, String>();
		
		
		if(!s.equals(null))
			resultResponse.put("word", s);
		else
			resultResponse.put("word", "enter word!");
		
		if(pronun!=null)
			resultResponse.put("pronunKey", pronun);
		else
			resultResponse.put("pronunKey", "not found!");
		
		if(bigHindi!=null)
			resultResponse.put("bigHindiKey", bigHindi);
		else
			resultResponse.put("bigHindiKey", "not found!");
		
		if(urdu!=null)
			resultResponse.put("urduKey", urdu);
		else
			resultResponse.put("urduKey", "not found!");
		
		if(english!=null)
			resultResponse.put("englishKey",english);
		else
			resultResponse.put("englishKey", "not found!");
			
		if(similar!=null)
			resultResponse.put("similarKey", similar);
		else
			resultResponse.put("similarKey", "not found!");
		
		
		return new ModelAndView("WordSearchResultJsp","result",resultResponse);
	}
	@RequestMapping(value="one", method=RequestMethod.POST)
	public ModelAndView welcoming(HttpServletRequest request,HttpServletResponse response){
		return new ModelAndView("mobileapp");
	}
	@RequestMapping(value="desktopapp", method=RequestMethod.POST)
	public ModelAndView welcomes(HttpServletRequest request,HttpServletResponse response){
		//System.out.println("called!");
		return new ModelAndView("desktopApplication");
	}
	
	@RequestMapping(value="lister", method=RequestMethod.POST)
	public ModelAndView generateDropDown(HttpServletRequest request, HttpServletResponse response){
		String string=request.getParameter("val");
		//String stc="s";
		if(dropDownSet==null){
			HttpSession session=request.getSession();
			ServletContext context=session.getServletContext();
			Map<String,String> pronun=(Map)context.getAttribute("bigHindiContext");
			dropDownSet=pronun.keySet();
		}
		DropDownBean dropDownBean=new DropDownBean();
	
		List<String> lists=dropDownBean.getDropDownList(string, dropDownSet);
		return new ModelAndView("DropDown","result",lists);
	}
	@RequestMapping(value="mywords", method=RequestMethod.POST)
	public ModelAndView myWords(HttpServletRequest request,HttpServletResponse response){
		//value contains "sessions": This value comes from browser by which it can be considered that to show the searched words or erase all.
		String value=request.getParameter("value");
		
		HttpSession session=request.getSession(true);
		
		//List list=(List)session.getAttribute("myWords");
		/*Enumeration<String> en=session.getAttributeNames();
		List<String> list=null;
		if(value.equals("sessions")){
			list=new ArrayList<String>();
			while(en.hasMoreElements()){
				list.add(en.nextElement());
			}
		}
		else{
			session.invalidate();
			list=new ArrayList<String>();
			list.add("No words...");
			while(en.hasMoreElements()){
				list.add(en.nextElement());
			}
			
		}*/
		
		List<String> list=null;
		Set<String> set=null;
		if(session.getAttribute("wordHistory")!=null){
			Object object=session.getAttribute("wordHistory");
			set=new TreeSet();
			set=(Set)object;
		}
		if(value.equals("sessions"))
		{
			if(set!=null && set.size()>0){
				list=new ArrayList();
				for(String s:set)
					list.add(s);
				
			}
			else{
				list=new ArrayList<String>();
				list.add("No words...");
			}
				
		}
		else{
			//Object object1=session.getAttribute("wordHistory");
			//set=(Set)object1;
			if(set!=null && set.size()>0)
				set.clear();
			
			list=new ArrayList<String>();
			list.add("No words...");
		}
			
		//String list=(String)session.getAttribute("myWords");
		
		return new ModelAndView("mysessionwords","result",list);
	}


}
