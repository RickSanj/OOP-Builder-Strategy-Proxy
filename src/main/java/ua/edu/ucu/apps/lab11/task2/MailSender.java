package ua.edu.ucu.apps.lab11.task2;

class MailSender {
    private MailSenderStrategy mailSenderStrategy;

    public MailSender(MailSenderStrategy mailSenderStrategy) {
        this.mailSenderStrategy = mailSenderStrategy;
    }

    public void sendMail(MailInfo mailInfo) {
        mailSenderStrategy.sendMail(mailInfo);
    }
}