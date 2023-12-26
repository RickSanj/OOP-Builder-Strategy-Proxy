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

interface MailSenderStrategy {
    void sendMail(MailInfo mailInfo);
}

class MailJetSender implements MailSenderStrategy {
    private MailjetClient client;

    public MailJetSender(String apiKey, String apiSecretKey) {
        this.client = new MailjetClient(apiKey, apiSecretKey, new ClientOptions("v3.1"));
    }

    @Override
    public void sendMail(MailInfo mailInfo) throws MailjetException, MailjetSocketTimeoutException {
        MailjetRequest request = new MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, new JSONArray()
                        .put(new JSONObject()
                                .put(Emailv31.Message.FROM, new JSONObject()
                                        .put("Email", "annamonastyrska.05@gmail.com")
                                        .put("Name", "Anna"))
                                .put(Emailv31.Message.TO, new JSONArray()
                                        .put(new JSONObject()
                                                .put("Email", mailInfo.getClient().getEmail())  // Assuming Client has getEmail() method
                                                .put("Name", mailInfo.getClient().getName())))
                                .put(Emailv31.Message.SUBJECT, "Subject of the email")
                                .put(Emailv31.Message.TEXTPART, "Text part of the email")
                                .put(Emailv31.Message.HTMLPART, "<h3>HTML part of the email</h3>")
                                .put(Emailv31.Message.CUSTOMID, "CustomId")));

        MailjetResponse response = client.post(request);
        System.out.println("MailJet Status: " + response.getStatus());
        System.out.println("MailJet Response: " + response.getData());
    }
}
