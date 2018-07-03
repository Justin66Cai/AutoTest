package com.mail;

import java.util.Date;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class SendEmailImpl implements SendMailI {

	private MailModel emailModel = null;
	private Session session = null;;
	private Message message = null;
	private Multipart multipart = null;

	public SendEmailImpl() {

	}

	/**
	 * 
	 * @param emailModel
	 */
	public SendEmailImpl(MailModel emailModel) {
		this.emailModel = emailModel;
	}

	/**
	 * 
	 * @return
	 * @throws MessagingException
	 */
	public boolean sendEmail(MailModel em) throws MessagingException {

		try {
			if (null == this.emailModel) {
				this.setMailModel(em);
			}
			/**
			 * 获得SESSION
			 */
			getSession();
			/**
			 * 设置发送信息
			 */
			setMessage();
			/**
			 * 发送消息
			 */
			sending();

		} catch (MessagingException me) {
			me.printStackTrace();
			throw new MessagingException("邮件发送失败，请确认用户名，密码，服务器的设置是否正确<br>详细信息如下:<br>" + me.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;

	}

	/**
	 * 
	 * @throws Exception
	 */
	/**
	 * 私有方法可以抛出Exception
	 */
	private void setMessage() throws MessagingException, Exception {

		message = new MimeMessage(session);
		multipart = new MimeMultipart();
		/**
		 * 设置地址
		 */
		setAddress();
		/**
		 * 设置日期
		 */
		setDate();
		/**
		 * 设置标题
		 * 
		 */
		setSubject();

		/**
		 * 设置内容
		 */
		setContent();

	}

	/**
	 * 发送
	 */
	private void sending() throws MessagingException {

		Transport tranSport = session.getTransport("smtp");
		try {
			tranSport.connect(emailModel.getMailServerHost().trim(), emailModel.getUserName().trim(),
					emailModel.getPassword().trim());
			message.saveChanges();
			tranSport.sendMessage(message, message.getAllRecipients());
		} catch (Exception e) {
			e.printStackTrace();
		}
		tranSport.close();
		session = null;
	}

	/**
	 * 设置文件内容 有以下格式 'text' / 'text/html'
	 * 
	 * @throws MessagingException
	 */
	private void setContent() throws MessagingException {
		message.setText(emailModel.getContent());
		BodyPart mdp = new MimeBodyPart();
		mdp.setContent(emailModel.getContent(), "text/html;charset=GBK");
		multipart.addBodyPart(mdp);
		message.setContent(multipart);
	}

	/**
	 * 设置发送时间
	 * 
	 * @throws MessagingException
	 */
	private void setDate() throws MessagingException {
		if (message != null) {
			// message.setHeader("X-Mailer","Microsoft Outlook Express
			// 6.00.2900.2096");
			message.setSentDate(new Date());
		}
	}

	/**
	 * 设置标题
	 * 
	 * @throws MessagingException
	 */
	private void setSubject() throws MessagingException, Exception {
		if (message != null) {
			if (emailModel.getSubject() != null) {
				String subject = MimeUtility.encodeText(new String(emailModel.getSubject().getBytes(), "GBK"), "GBK",
						"B");
				message.setSubject(subject);
			} else {
				message.setSubject("No Subject!");
			}
		}
	}

	/**
	 * 
	 * @throws MessagingException
	 */

	private void setAddress() throws MessagingException {
		/**
		 * 发送邮件的地址通过配置信息查询获得
		 */
		InternetAddress address = new InternetAddress(emailModel.getFromAddress().trim());
		message.setFrom(address);
		InternetAddress toAddress = new InternetAddress(emailModel.getToAddress().trim());
		message.addRecipient(Message.RecipientType.TO, toAddress);

	}

	/**
	 * 
	 * @return
	 */
	private void getSession() {

		Properties props = new Properties();
		props.put("mail.smtp.host", emailModel.getMailServerHost().trim());
		props.put("mail.smtp.auth", "true");
		if (emailModel.getMailServerPort() != null) {
			props.put("mail.smtp.port", emailModel.getMailServerPort());
		}

		SmtpAuth auth = new SmtpAuth();
		auth.setUserinfo(emailModel.getUserName().trim(), emailModel.getPassword().trim());
		session = Session.getDefaultInstance(props, auth);
		// System.out.println("get the session successful");

	}

	/**
	 * @return emailModel
	 */
	public MailModel getMailModel() {
		return emailModel;
	}

	/**
	 * @param emailModel
	 */
	public void setMailModel(MailModel emailModel) {
		this.emailModel = emailModel;
	}

	public class SmtpAuth extends javax.mail.Authenticator {
		private String user, password;

		public PasswordAuthentication setUserinfo(String getuser, String getpassword) {
			user = getuser;
			password = getpassword;
			return getPasswordAuthentication();
		}

		protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
			return new javax.mail.PasswordAuthentication(user, password);
		}
	}

}
