package ua.edu.ucu.apps.lab11.task2;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.ClientOptions;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        try {
            MailSenderStrategy mailJetSender = new MailJetSender("06edc171157519c49ef09bc9d2abd1b0", "ee453376afcdcc0000984377abd85686");
            MailSender mailSender = new MailSender(mailJetSender);

            Client client = Client.builder()
                    .name("Anna")
                    .age(25)
                    .sex("f")
                    .email("annamonastyrska.05@gmail.com")
                    .build();
            
            MailInfo mailInfo = new MailInfo(client, 1); 
            mailSender.sendMail(mailInfo);

        } catch (MailjetException | MailjetSocketTimeoutException e) {
            e.printStackTrace();
        }
    }
}