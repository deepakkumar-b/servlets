public class mailclass {
    public static void main(String... args) throws Exception {
        // Create mailer.
        String hostname = "smtp.example.com";
        int port = 2525;
        String username = "nobody";
        String password = "idonttellyou";
        Mailer mailer = new Mailer(hostname, port, username, password);

        // Send mail.
        String from = "john.doe@example.com";
        String to = "jane.doe@example.com";
        String subject = "Interesting news";
        String message = "I've got JavaMail to work!";
        mailer.send(from, to, subject, message);
    }
}