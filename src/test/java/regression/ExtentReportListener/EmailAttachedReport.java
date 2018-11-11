package regression.ExtentReportListener;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class EmailAttachedReport {
    public static void main(String[] args) throws EmailException {
        // Create the attachment
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("D:\\ideaProjects\\automation_test\\build\\reports\\tests\\test\\emailable-report.html");
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("Report");
        attachment.setName("Report");

        // Create the email message
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.gmail.com");
        email.setStartTLSEnabled(true);
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator("SHARMEEXTCA@GMAIL.COM", "madhu7DADADADA"));
        email.setSSLOnConnect(true);

        email.addTo("sharmeextca@gamil.com");
        email.setFrom("sharmeextca@gmail.com");

        email.setSubject("The picture");
        email.setMsg("Here is the picture you wanted");

        // add the attachment
        email.attach(attachment);

        // send the email
        email.send();
        System.out.println("Done");
    }

}
