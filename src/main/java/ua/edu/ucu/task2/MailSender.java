class MailSender {
    private MailSenderStrategy mailSenderStrategy;

    public MailSender(MailSenderStrategy mailSenderStrategy) {
        this.mailSenderStrategy = mailSenderStrategy;
    }

    public void sendMail(MailInfo mailInfo) throws MailjetException, MailjetSocketTimeoutException {
        mailSenderStrategy.sendMail(mailInfo);
    }
}