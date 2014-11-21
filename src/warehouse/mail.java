package warehouse;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mail
 */
public class mail extends HttpServlet {
    private Mailer mailer;
    private String to;

    public void init() {
        // Create mailer. You could eventually obtain the settings as
        // web.xml init parameters or from some properties file.
        String hostname = "smtp.example.com";
        int port = 2525;
        String username = "nobody";
        String password = "forgetit";
        this.mailer = new Mailer(hostname, port, username, password);
        this.to = "you@example.com";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        // Do some validations and then send mail:

        try {
            mailer.send(email, to, subject, message);
            request.setAttribute("message", "Mail succesfully sent!");
            request.getRequestDispatcher("/WEB-INF/contact.jsp").forward(request, response);
        } catch (MailException e) {
            throw new ServletException("Mailer failed", e);
        }
    }


}
