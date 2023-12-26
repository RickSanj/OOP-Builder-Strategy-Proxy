package ua.edu.ucu.apps.lab11.task2;

import java.util.ArrayList;
import java.util.List;

class MailBox {
    private List<MailInfo> infos;

    public MailBox() {
        this.infos = new ArrayList<>();
    }

    public void addMailInfo(MailInfo mailInfo) {
        infos.add(mailInfo);
    }

    public void sendAll() {
        for (MailInfo info : infos) {
            MailSenderStrategy mailSenderStrategy = getMailSenderStrategy(info);
            MailSender mailSender = new MailSender(mailSenderStrategy);
            mailSender.sendMail(info);
        }
    }

    private MailSenderStrategy getMailSenderStrategy(MailInfo mailInfo) {
        int mailCode = mailInfo.getMailCode();
        Client client = mailInfo.getClient();

        if (mailCode == 1 && isBirthday(client)) {
            return new Coupon();
        } else if (mailCode == 2 && isFemale(client)) {
            return new Sale();
        } else {
            throw new IllegalArgumentException("Invalid mail code");
        }
    }

    private boolean isBirthday(Client client) {
        return client.getAge() % 10 == 0;
    }

    private boolean isFemale(Client client) {
        return client.getSex() == Gender.FEMALE;
    }
}