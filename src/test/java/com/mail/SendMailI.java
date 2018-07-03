package com.mail;

import javax.mail.MessagingException;

public interface SendMailI {
	/**
	 * Send Mail 
	 * @return
	 * @throws MessagingException
	 */
	public boolean sendEmail(MailModel em) throws MessagingException;
	/**
	 * Setup MailModel
	 * @param emailModel
	 */
	public void setMailModel(MailModel emailModel);
	
}
