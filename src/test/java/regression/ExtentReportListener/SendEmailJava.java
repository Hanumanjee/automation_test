package regression.ExtentReportListener;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendEmailJava {
    public static void main(String[] args) throws EmailException {
        System.out.println("Test Email Start");
        sendReportmail();
        System.out.println("End of mail ");
    }

    public static void sendReportmail() throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setStartTLSEnabled(true);
        email.setSmtpPort(587);
        //email.setSslSmtpPort("587");
        email.setAuthenticator(new DefaultAuthenticator("SHARMEEXTCA@GMAIL.COM", "madhu7DADADADA"));
        email.setSSLOnConnect(true);
        email.setFrom("sharmeextca@gmail.com");
        email.setSubject("TestMail");
        email.setMsg("This is a test mail ... :-)");
        email.addTo("sharmeextca@gamil.com");
        email.send();
        System.out.println("End sending mail");
    }
}
