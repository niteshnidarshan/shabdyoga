package shabd.yoga.web.spring.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tanesha.recaptcha.ReCaptcha;
import net.tanesha.recaptcha.ReCaptchaResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shabd.yoga.mail.SendMeMail;

@Controller
public class FeedbackController {
	static {
		System.setProperty("java.net.useSystemProxies", "true");
	}
	@Autowired
	private ReCaptcha reCaptcha = null;
	@Autowired
	private SendMeMail sendMeMail;
	@RequestMapping(value="feedback", method=RequestMethod.POST)
	public ModelAndView getFeedback(HttpServletRequest request,HttpServletResponse response){
		return new ModelAndView("Feedback");
	}
	
	@RequestMapping(value="submitFeedback", method=RequestMethod.POST)
	public ModelAndView submitForm(@RequestParam("recaptcha_challenge_field") String challangeField, @RequestParam("recaptcha_response_field") String responseField, ServletRequest servletRequest) {
		String remoteAddress = servletRequest.getRemoteAddr();
		String name=servletRequest.getParameter("feedbackName");
		String email=servletRequest.getParameter("feedbackEmail");
		String message=servletRequest.getParameter("feedbackMessage");	
		try{
			ReCaptchaResponse reCaptchaResponse = this.reCaptcha.checkAnswer(remoteAddress, challangeField, responseField);
		
		if(reCaptchaResponse.isValid()) {
			String messageResult=sendMeMail.sendMailToFeedback(name, email);
			String messageResults=sendMeMail.sendMailToMeToFeedback(name, email, message);
			if((messageResult.equals("message sent successfully!")) && (messageResults.equals("message sent successfully!")))
				return new ModelAndView("CaptchaResponse");
			else
				return new ModelAndView("CaptchError");
			
		} else {
			return new ModelAndView("CaptchaError");
		}
		}catch(Exception e){
			return new ModelAndView("CaptchaError");
			
		}
	}

}
