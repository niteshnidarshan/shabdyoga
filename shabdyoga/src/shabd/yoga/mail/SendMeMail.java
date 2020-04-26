package shabd.yoga.mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
public class SendMeMail {
	
	private JavaMailSenderImpl mailSender;
	public void setMailSender(JavaMailSenderImpl mailSender){
		this.mailSender=mailSender;
	}
	public String sendMail(String name, String email,String subject, String message){
		try{
			SimpleMailMessage smm=new SimpleMailMessage();
			smm.setFrom("shabdyogamail@gmail.com");
			smm.setTo(email);
			smm.setSubject(subject);
			smm.setText(message);
			mailSender.send(smm);
			return "message sent successfully!";
		}catch(Exception e){
			return "message sending fail!";
			
		}
		
	}
	public String sendMailToMe(String name, String email){
		try{
			String message="Hi!\nName : "+name+"\n email : "+email+"\n has downloaded the KVR Dictionary.";
			SimpleMailMessage smm=new SimpleMailMessage();
			smm.setFrom("shabdyogamail@gmail.com");
			smm.setTo("kvrdictionary@gmail.com");
			smm.setSubject(name+" KVR Dictionary");
			smm.setText(message);
			mailSender.send(smm);
			return "message sent successfully!";
		}catch(Exception e){
			return "message sending fail!";
			
		}
		
	}
	public String sendMailToMeAtBrainRemedy(String name, String email){
		try{
			String message="Hi!\nName : "+name+"\n email : "+email+"\n has downloaded the KVR Dictionary.";
			SimpleMailMessage smm=new SimpleMailMessage();
			smm.setFrom("shabdyogamail@gmail.com");
			smm.setTo("kvrdictionary@gmail.com");
			smm.setSubject(name+" downloaded brain remedy");
			smm.setText(message);
			mailSender.send(smm);
			return "message sent successfully!";
		}catch(Exception e){
			return "message sending fail!";
			
		}
		
	}
	public String sendMailToMeToFeedback(String name, String email, String message){
		try{
			String messages="Hi!\nName : "+name+"\n email : "+email+"\n message : "+message;
			SimpleMailMessage smm=new SimpleMailMessage();
			smm.setFrom("shabdyogamail@gmail.com");
			smm.setTo("kvrdictionary@gmail.com");
			smm.setSubject(name+" sent feedback");
			smm.setText(messages);
			mailSender.send(smm);
			return "message sent successfully!";
		}catch(Exception e){
			return "message sending fail!";
			
		}
		
	}
	public String sendMailToFeedback(String name, String email){
		try{
			SimpleMailMessage smm=new SimpleMailMessage();
			String message="Hi "+name+"!\n Thank you for your valuable feedback for shabdyoga.com.\n Regards,\nshabdyoga.com";
			smm.setFrom("shabdyogamail@gmail.com");
			smm.setTo(email);
			smm.setSubject("shabdyoga feedback info");
			smm.setText(message);
			mailSender.send(smm);
			return "message sent successfully!";
		}catch(Exception e){
			return "message sending fail!";
			
		}
		
	}
}
