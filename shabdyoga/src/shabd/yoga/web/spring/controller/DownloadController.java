package shabd.yoga.web.spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shabd.yoga.mail.SendMeMail;

@Controller
@RequestMapping("kvrDictionary")
public class DownloadController {
	//size of a byte buffer to read/write file
	private static final int BUFFER_SIZE=6000;
	
	//path of the file to be downloaded, relative to application's directory.
	private String filePath="/downloads/KVRdictionary.rar";
	@Autowired
	private SendMeMail sendMeMail;
	//method for handling file download request of clientz
	@RequestMapping(method=RequestMethod.GET)
	public void kvrDictionaries(HttpServletRequest request, HttpServletResponse response)throws IOException{
		String name=request.getParameter("x");
		String email=request.getParameter("xEmail");
		String subject="KVRDictionary Info";
		String message="Hi "+name+"!\n Thank you for downloading KVR Dictionary. This is a Desktop version of shbdyoga.com. It do not requires internet connection.\n If you find any problem to use in your computer, feel free to consult us.\n We will feel happy to here from you on kvrdictionary@gmail.com.\n Thanking and regards,\n shabdyoga.com";
		
		String messageResult=sendMeMail.sendMail(name, email, subject, message);
		String messageResults=sendMeMail.sendMailToMe(name, email);
		
		//get absolute path of the file
		//ServletContext context=request.getServletContext();
		ServletContext context=request.getSession().getServletContext();
		String appPath=context.getRealPath("");
		
		//construct the complete absolute path of the file
		String fullPath=appPath+filePath;
		File downloadFile= new File(fullPath);
		FileInputStream fis=new FileInputStream(downloadFile);
		
		//get MIME type of the file
		String mimeType=context.getMimeType(fullPath);
		if(mimeType==null){
			//set to binary type if MIME mapping not found
			mimeType="application/octet-stream";
		}
		
		//set content attributes for the response
		response.setContentType(mimeType);
		response.setContentLength((int)downloadFile.length());
		
		//set headers for the response
		String headerKey="Content-Disposition";
		String headerValue=String.format("attachment; filename=\"%s\"",downloadFile.getName());
		response.setHeader(headerKey, headerValue);
		
		//get output of the response
		OutputStream os=response.getOutputStream();
		
		byte[] buffer=new byte[BUFFER_SIZE];
		int bytesRead=-1;
		
		//write bytes read from the input stream into the output stream
		while((bytesRead=fis.read(buffer))!=-1){
			os.write(buffer,0, bytesRead);			
		}
		fis.close();
		os.close();
		
		
		
		//return new ModelAndView("WelcomeSpring");
	}
}
