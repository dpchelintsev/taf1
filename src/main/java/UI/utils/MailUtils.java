package UI.utils;

import javax.mail.*;
import java.util.Properties;

public class MailUtils {
    static String link = "";
    public static String check(String host, String user,
                               String password) {
        try {
            //create properties field
            Properties properties = new Properties();

            properties.put("mail.pop3.host", host);
            properties.put("mail.pop3.port", "995");
            properties.put("mail.pop3.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            //create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore("pop3s");
            store.connect(host, user, password);
            //create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it
            /**
             * This part of code doesn't work because I'm not able to get email from gmail
             * I receive cucumber.runtime.CucumberException: java.lang.NoSuchMethodError: com.sun.mail.util.TraceInputStream.<init>(Ljava/io/InputStream;Lcom/sun/mail/util/MailLogger;)
             */
            Message[] messages = emailFolder.getMessages();

            String[] s = messages[messages.length - 1].getContent().toString().split("code");
            String[] s2 = s[1].split("Do");

            link = s2[0];
            //close the store and folder objects
            emailFolder.close(false);
            store.close();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return link;
    }
}
