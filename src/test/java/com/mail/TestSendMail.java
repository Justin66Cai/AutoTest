package com.mail;

public class TestSendMail {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
	       MailModel mailModel = new MailModel();    
	       mailModel.setMailServerHost("smtp.126.com");    
	       mailModel.setMailServerPort("25");    
	       mailModel.setValidate(true);    
	      // mailModel.setIsText(0);
	       mailModel.setUserName("lrTesting@126.com");    
	       mailModel.setPassword("Pass1234");//您的邮箱密码    
	       mailModel.setFromAddress("lrTesting@126.com");    
	       mailModel.setToAddress("lrTesting@126.com");    
	       mailModel.setSubject("水电费Test");
	       mailModel.setContent("Mail Test Content");     
	       SendMailI ee = new SendEmailImpl();

	       try {
	    	  boolean IfSuccess = 	ee.sendEmail(mailModel);
			} catch (javax.mail.MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	     }  
	}

