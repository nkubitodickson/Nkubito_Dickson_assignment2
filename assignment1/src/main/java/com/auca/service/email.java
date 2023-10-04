package com.auca.service;

import javax.servlet.http.HttpServlet;
import java.io.IOException; 
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sendConfirmationEmail")
public class email extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the recipient's email address and confirmation code from the request parameters
        String recipientEmail = request.getParameter("recipientEmail");
        String confirmationCode = request.getParameter("confirmationCode");

        // Setup mail server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com"); // Gmail SMTP host
        properties.put("mail.smtp.port", "587"); // Gmail SMTP port
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Replace with your actual Gmail email and password or App Password
        final String senderEmail = "nkubitod07@gmail.com";
        final String senderPassword = "nhfz yjji dhkw ynov";

        // Create a session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Create a message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Subject of the Email"); // Replace with your subject
            message.setText("Email sent successfully. Confirmation Code: " + confirmationCode); // Replace with your message

            // Send the message
            Transport.send(message);

            // Handle successful email sending (e.g., display a success message)
            response.getWriter().write("Email sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
            // Handle email sending failure (e.g., display an error message)
            response.getWriter().write("Failed to send email: " + e.getMessage());
        }
    }

	


}
