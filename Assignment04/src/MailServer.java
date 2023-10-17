import java.util.LinkedList;

public class MailServer {

        // Question
        // msg.sendTo(mailServer)

        // Or
        // mailServer.send(msg)

        private String domain;
        private MailServer other; // the other mail server to which this mail server connected to
        private LinkedList<MailMessage> mailMessages;

        public MailServer(String domain) {
                this.domain = domain;
                mailMessages = new LinkedList<MailMessage>();
        }

        // MailServer noodle = new MailServer(.., jabboo);
        // MailServer jabboo = new MailServer(.., noodle)


        // MailMessage msg1 = ...
        // noodle.sendMail(msg1)
        public void sendMail(MailMessage mail) {
                // System.out.println("sendMail called on " + this.domain);

                // forward mail to other server if recipient is on other domain
                // just approximation, need more logic to decide the domain name
                if (mail.getToAddress().contains(other.domain)) {
                        other.sendMail(mail); // relay
                } else if(mail.getToAddress().contains(this.domain)){
                        mailMessages.add(mail);
                } else {
                        System.out.println("There is an error. No domain for the toAddress!!!");
                }

        }

        // Homework >>> try with constructor
        public void connectWith(MailServer other) {
                this.other = other;
        }

        // not essential
        public int getTotalNoOfMessages() {
                return mailMessages.size();
        }

        public LinkedList<MailMessage> getInboxFor(String mailAddress) {
                LinkedList<MailMessage> inbox = new LinkedList<MailMessage>();
                for (int i = 0; i < mailMessages.size(); i++) {
                        MailMessage msg = mailMessages.get(i);
                        if (msg.getToAddress().equals(mailAddress))
                                inbox.add(msg);
                }
                return inbox;
        }

        public LinkedList<MailMessage> getOutboxFor(String mailAddress) {
                LinkedList<MailMessage> sentMsgs = new LinkedList<MailMessage>();
                for (int i = 0; i < mailMessages.size(); i++) {
                        MailMessage msg = mailMessages.get(i);
                        if (msg.getFromAddress().equals(mailAddress))
                                sentMsgs.add(msg);
                }
                return sentMsgs;
        }
}
