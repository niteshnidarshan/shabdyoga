package shabd.yoga.web.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AboutController {
	@RequestMapping(value="about", method=RequestMethod.POST)
	public ModelAndView getAbout(HttpServletRequest req,HttpServletResponse response){
		
		return new ModelAndView("AboutJsp");
	}
	@RequestMapping(value="help", method=RequestMethod.POST)
	public ModelAndView getHelp(HttpServletRequest req,HttpServletResponse response){
		
		return new ModelAndView("HelpJsp");
	}
	@RequestMapping(value="careers", method=RequestMethod.POST)
	public ModelAndView getCareers(HttpServletRequest req,HttpServletResponse response){
		
		return new ModelAndView("CareersJsp");
	}
	@RequestMapping(value="terms", method=RequestMethod.POST)
	public ModelAndView getTerms(HttpServletRequest req,HttpServletResponse response){
		
		return new ModelAndView("TermsJsp");
	}
}
