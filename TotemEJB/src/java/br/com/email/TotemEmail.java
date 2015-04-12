/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.email;

import br.com.wrapper.TotemEmailWrapper;
import java.util.Calendar;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Andre
 */
public class TotemEmail {

    private static final Logger log = LogManager.getLogger(TotemEmail.class.getName());
    
//    @EJB
//    private static ITotemService iTotemService;

    private static final String USERNAME = "andrevmdb@gmail.com";   /** Pegar do Parametro**/
    private static final String PASSWORD = "";                      /** Pegar do Parametro**/

    private static final String FROM    = "andrevmdb@gmail.com";    /** Pegar do Parametro**/
    private static final String TO      = "andrevmdb@gmail.com";    /** Pegar do Parametro**/

    public static void main(String[] args) throws Exception {

//        envioTLS(new TotemEmailWrapper("Erro Totem Desktop 1 ", "Erro grave 1", "Pane Sistema 1"));
        
        envioSSL(new TotemEmailWrapper("Erro Totem Desktop 2", "Erro grave 2", "Pane Sistema 2"));
    }
    
    public static void enviaEmail(TotemEmailWrapper wrapper){
        
        log.info("Início: {0}", Calendar.getInstance().getTime());
        
        envioTLS(wrapper);
        
        log.info("Fim: {0}", Calendar.getInstance().getTime());
    }

    private static void envioTLS(TotemEmailWrapper wrapper) {

        /** HTML **/
        
        Properties props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    
                    // iTotemService.recuperaParametroPorNome("EMAIL_USERNAME").getValor()
                    // iTotemService.recuperaParametroPorNome("EMAIL_PASSWORD").getValor()
                    
                    return new PasswordAuthentication(USERNAME, PASSWORD);
                }
            }
        );

        session.setDebug(true);

        try {

            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(FROM));// iTotemService.recuperaParametroPorNome("EMAIL_FROM").getValor()

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(TO)); // iTotemService.recuperaParametroPorNome("EMAIL_PARA").getValor()
//            message.addRecipients(Message.RecipientType.CC, iTotemService.recuperaParametroPorNome("EMAIL_TO").getValor());
            
            /** Titulo **/
            message.setSubject(wrapper.getTitulo());

            StringBuilder builderEmail = new StringBuilder();
            
            /** Corpo Email -> Utilizado HTML para formatação **/
            builderEmail.append("<B>");
            builderEmail.append(wrapper.getCorpo());
            builderEmail.append(" ");
            builderEmail.append(wrapper.getAdicional());
            builderEmail.append("</B>");
            
            message.setContent(builderEmail.toString(), "text/html");

            Transport.send(message);
            
            log.info("Enviado...");

        } catch (MessagingException mex) {
            log.error("Erro capturado.", mex);
        }
    }

    private static void envioSSL(TotemEmailWrapper wrapper) throws Exception {

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USERNAME, PASSWORD);
                }
            }
        );

        session.setDebug(true);

        try {

            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(FROM));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(TO));
//            message.addRecipients(Message.RecipientType.CC, iTotemService.recuperaParametroPorNome("EMAIL_PARA").getValor());
            
            /** Titulo **/
            message.setSubject(wrapper.getTitulo());

            StringBuilder builderEmail = new StringBuilder();
            
            /** Corpo Email -> Utilizado HTML para formatação **/
            builderEmail.append("<B>");
            builderEmail.append(wrapper.getCorpo());
            builderEmail.append(" ");
            builderEmail.append(wrapper.getAdicional());
            builderEmail.append("</B>");
            
            message.setText(builderEmail.toString());

            Transport.send(message);
            
            log.info("Enviado...");

        } catch (MessagingException mex) {
            log.error("Erro capturado.", mex);
        }
    }
}
