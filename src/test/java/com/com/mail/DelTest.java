package com.com.mail;

import javax.mail.MessagingException;

public class DelTest {
    public static void main(String[] args) throws MessagingException {
        String pop3Server = "pop3.163.com";
        String protocol = "pop3";
        String user = "shaszb@163.com";
        String pwd = "amkor999!";
        Delect del = new Delect();
        del.delMail(pop3Server, protocol, user, pwd);
    }

}
