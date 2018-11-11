package regression.ExtentReportListener;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class EmailTestReport {
    public static void execute(String reportFileName) throws Exception {

        final String username = "sharmeextca@gmail.com";
        final String password = "madhu7DADADADA";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sharmeextca@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("sharmeextca@gmail.com"));
            message.setSubject("Reports Availalbe!");
            message.setText("Dear Mail Crawler,"
                    + "\n\n No spam to my email, please!");

            MimeBodyPart messageBodyPart = new MimeBodyPart();

            Multipart multipart = new MimeMultipart();

            messageBodyPart = new MimeBodyPart();
            String file = "D:\\ideaProjects\\automation_test\\build\\reports\\tests\\test\\emailable-report.html";
            String fileName = reportFileName;
            DataSource source = new FileDataSource(file + fileName);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);
            System.out.println("Sending");
            Transport.send(message);
            System.out.println("Done");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

public static void main(String args[]) throws Exception{
    EmailTestReport etr=new EmailTestReport();
    etr.execute("emailable-report.html");
}
}



