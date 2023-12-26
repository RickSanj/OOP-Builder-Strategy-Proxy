package ua.edu.ucu.apps.lab11.task2;

public class MailInfo {
    private Client client;
    private int mailCode;

    public MailInfo(Client client, int mailCode) {
        this.client = client;
        this.mailCode = mailCode;
    }

    public Client getClient() {
        return client;
    }

    public int getMailCode() {
        return mailCode;
    }
}
