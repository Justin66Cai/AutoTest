package com.com.mail;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.*;
import javax.mail.search.AndTerm;
import javax.mail.search.FromStringTerm;
import javax.mail.search.SearchTerm;
import javax.mail.search.SubjectTerm;
public class Delect {
    public  void   delMail(String pop3Server,String protocol,String user,String pwd ) throws MessagingException,NoSuchProviderException {
        Random random;
        // 创建一个有具体连接信息的Properties对象
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", protocol);
        props.setProperty("mail.pop3.host", pop3Server);

        // 使用Properties对象获得Session对象
        Session session = Session.getInstance(props);
        session.setDebug(true);

        // 利用Session对象获得Store对象，并连接pop3服务器
        Store store = session.getStore();
        store.connect(pop3Server, user, pwd);

        // 获得邮箱内的邮件夹Folder对象，以"读-写"打开
        Folder folder = store.getFolder("inbox");
        folder.open(Folder.READ_WRITE);
        //获取邮件总数
        Message[] messages = folder.getMessages();
        int mailCounts = messages.length;
        if(mailCounts ==0){
            System.out.println("没有邮件可以删除");
        }else {
            System.out.println("一共" + mailCounts + "封邮件");
            //获取初始化initnum,邮件数大于10封时,重新定义
            int initNum = 0;
            int maxNum = mailCounts;
            if (mailCounts > 10) {
                initNum = mailCounts - 9;
                System.out.println("initNum," + initNum);
            }
            random = new Random();
            //随机删除前10个
            int rand = random.nextInt(maxNum) + initNum;
            messages[rand].setFlag(Flags.Flag.DELETED, true);
            System.out.println("rand=" + rand);
            System.out.println("mailCounts=" + mailCounts);
            System.out.println("成功设置了删除标记！");

            folder.close(true);
            store.close();
        }
    }

}
