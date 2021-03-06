package shisp.demo1;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 发送邮件测试：可用
 * 
 * Created by shisp on 2017年11月22日.
 */
public class SendMailDemo2 {

    public static void main(String[] args) {
//        test(); //测试：新注册账号发送信息过滤较严格，554错误：信息被拦截
        
        // 1.创建一个程序与邮件服务器会话对象 Session
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "SMTP");
        props.setProperty("mail.smtp.host", "smtp.163.com");
        props.setProperty("mail.smtp.port", "25");
        // 指定验证为true
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.timeout", "1000");
        // 验证账号及密码，密码需要是第三方授权码
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("shispo@163.com", "shi88889999");
            };
        };
        Session session = Session.getInstance(props, auth);

        // 2.创建一个Message，它相当于是邮件内容
        Message message = new MimeMessage(session);
        try {
            // 设置发送者
            message.setFrom(new InternetAddress("shispo@163.com"));
            // 设置发送方式与接收者
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("shispo@163.com"));
            // 设置主题
            message.setSubject("关于java的mail说明");
            // 设置内容
            message.setContent("关于java的mail说明", "text/html;charset=utf-8");

            // 3.创建 Transport用于将邮件发送
            Transport.send(message);
            
            System.out.println("发送完成");
        } catch (AddressException e) {
            e.printStackTrace();
            System.out.println("发送失败");
        } catch (MessagingException e) {
            System.out.println("发送失败");
            e.printStackTrace();
        }
    }
    
    public static void test(){
     // 1.创建一个程序与邮件服务器会话对象 Session
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "SMTP");
        props.setProperty("mail.smtp.host", "smtp.163.com");
        props.setProperty("mail.smtp.port", "25");
        // 指定验证为true
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.timeout", "1000");
        // 验证账号及密码，密码需要是第三方授权码
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("shispo@163.com", "shi88889999");
            };
        };
        Session session = Session.getInstance(props, auth);

        // 2.创建一个Message，它相当于是邮件内容
        Message message = new MimeMessage(session);
        try {
            // 设置发送者
            message.setFrom(new InternetAddress("shispo@163.com"));
            // 设置发送方式与接收者
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("soogbo@163.com"));
            // 设置主题
            message.setSubject("关于发布《车辆管理制度》的通知");
            // 设置内容
            message.setContent("通知：参阅稍后邮件,", "text/html;charset=utf-8");
//            InternetAddress internetAddress = new InternetAddress("soogbo@163.com");
//            Address[] addressArr= {new InternetAddress("soogbo@163.com")};
            // 3.创建 Transport用于将邮件发送
//            Transport transport = session.getTransport();
            Transport.send(message);
            
//            transport.sendMessage(message, addressArr);
            
            System.out.println("发送完成");
        } catch (AddressException e) {
            e.printStackTrace();
            System.out.println("发送失败");
        } catch (MessagingException e) {
            System.out.println("发送失败");
            e.printStackTrace();
        }
    };
    

}
