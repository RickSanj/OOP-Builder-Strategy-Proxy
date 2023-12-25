package main.java.ua.edu.ucu.task2;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;

public class Coupon implements MailSenderStrategy {
    private MailjetClient client;

    public Coupon(String apiKey, String apiSecretKey) {
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
                                .put(Emailv31.Message.SUBJECT, "Special Coupon Inside!")
                                .put(Emailv31.Message.TEXTPART, "Here is a special coupon for you!")
                                .put(Emailv31.Message.HTMLPART, "<h3>Your Exclusive Coupon!</h3><p>Use this coupon to enjoy special discounts.</p>")
                                .put(Emailv31.Message.CUSTOMID, "CouponInfo")));

        MailjetResponse response = client.post(request);
        System.out.println("MailJet Status: " + response.getStatus());
        System.out.println("MailJet Response: " + response.getData());
    }
}
