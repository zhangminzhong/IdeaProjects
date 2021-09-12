package 邮件发送;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.Date;
import java.util.Properties;

/**
 * Created by zhang_minzhong on 2017/7/4.
 */
public class 保存到本地 {
    public static void main(String[] args) throws IOException, MessagingException {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("1065639989@qq.com","发送者","UTF-8"));
        message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress("1834407713@qq.com","接收者","UTF-8"));
        message.setSubject("测试","UTF-8");
        message.setContent("这是正文。。。","text/html;charset=UTF-8");
        message.setSentDate(new Date());
        message.saveChanges();
        OutputStream os = new FileOutputStream("MyEmail.eml");
        message.writeTo(os);
        os.flush();
        os.close();
    }
}
