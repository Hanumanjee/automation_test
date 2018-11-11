package regression.ExtentReportListener;

import org.apache.commons.mail.*;

public class SendReportByMail {
    public static void main(String[] args) throws EmailException {
        System.out.println("Start email");

        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("D:\\ideaProjects\\automation_test\\build\\reports\\tests\\test\\emailable-report.html");
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("Hanumanjee Report");
        attachment.setName("Hanumanjee");

        // Create the email message
        MultiPartEmail email = new MultiPartEmail();

//        email.setHostName("smtp.gmail.com");
//        email.setSSLOnConnect(true);
//        email.setSmtpPort(587);
//        email.setStartTLSEnabled(true);



        email.setHostName("smtp.gmail.com");
        email.setStartTLSEnabled(true);
        email.setSmtpPort(587);


        email.setAuthenticator(new DefaultAuthenticator("sharmeextca@gamil.com", "madhu7DADADADA"));
        email.setSSLOnConnect(true);
        email.setFrom("sharmeextca@gmail.com");
        email.setSubject("Email Report");
        email.setMsg("This is a report from Maa");
        email.attach(attachment);
        email.addTo("blmsen@yahoo.com");
        email.send();
        System.out.println("Mail has sent");

    }
}
