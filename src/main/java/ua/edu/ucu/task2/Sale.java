package main.java.ua.edu.ucu.task2;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;

public class Sale implements MailSenderStrategy {
    private MailjetClient client;

    public Sale(String apiKey, String apiSecretKey) {
        this.client = new MailjetClient(apiKey, apiSecretKey, new ClientOptions("v3.1"));
    }

    @Override
    public void sendMail(MailInfo mailInfo) throws MailjetException, MailjetSocketTimeoutException {
        MailjetRequest request = new MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, new JSONArray()
                        .put(new JSONObject()
                                .put(Emailv31.Message.FROM, new JSONObject()
                                        .put("Email", "annamonastyrska.05@gmail.com")
                                        .put("Name", "Anna Monastyrska"))
                                .put(Emailv31.Message.TO, new JSONArray()
                                        .put(new JSONObject()
                                                .put("Email", mailInfo.getClient().getEmail())
                                                .put("Name", mailInfo.getClient().getName())))
                                .put(Emailv31.Message.SUBJECT, "Special Sale Offer!")
                                .put(Emailv31.Message.TEXTPART, "Check out our special sale offer!")
                                .put(Emailv31.Message.HTMLPART, "<h3>Exclusive Sale!</h3><p>Don't miss out on our special sale offer.</p>")
                                .put(Emailv31.Message.CUSTOMID, "SaleInfo")));

        MailjetResponse response = client.post(request);
        System.out.println("MailJet Status: " + response.getStatus());
        System.out.println("MailJet Response: " + response.getData());
    }
}
