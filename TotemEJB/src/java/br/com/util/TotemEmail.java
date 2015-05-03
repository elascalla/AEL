/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import br.com.dao.ParametroDao;
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

    public static void main(String[] args) throws Exception {

        TotemEmailWrapper wrapper = new TotemEmailWrapper("Falha Capturada", "Falha Capturada - Ajustar", "Erro GRAVE - PANE");

        wrapper.setUsername("totemsuporte@laulettaepereira.com.br");
        wrapper.setPassword("totem1234");
        wrapper.setFrom("totemsuporte@laulettaepereira.com.br");
        wrapper.setTo("totemsuporte@laulettaepereira.com.br");
        wrapper.setCc("andrevmdb@gmail.com,erick.lascalla@gmail.com,leandrohenrique.negri@gmail.com");
        
        envioTLS(wrapper);
        
//        envioSSL(new TotemEmailWrapper("Erro Totem Desktop 2", "Erro grave 2", "Pane Sistema 2"));
    }
    
    public static void envia(TotemEmailWrapper wrapper){
        
        log.info("Início: {0}", Calendar.getInstance().getTime());
        
        envioTLS(wrapper);
        
        log.info("Fim: {0}", Calendar.getInstance().getTime());
    }

    /**
     * 
     * @param wrapper 
     */
    private static void envioTLS(final TotemEmailWrapper wrapper) {

        /** HTML **/
        
        Properties props = new Properties();

        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.laulettaepereira.com.br");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(wrapper.getUsername(), wrapper.getPassword());
                }
            }
        );

        session.setDebug(true);

        try {

            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(wrapper.getFrom()));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(wrapper.getTo()));
            message.addRecipients(Message.RecipientType.CC, wrapper.getCc());
            
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

    @Deprecated
    private static void envioSSL(final TotemEmailWrapper wrapper) throws Exception {

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.laulettaepereira.com.br");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(wrapper.getUsername(), wrapper.getPassword());
                }
            }
        );

        session.setDebug(true);

        try {

            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(wrapper.getFrom()));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(wrapper.getTo()));
            message.addRecipient(Message.RecipientType.CC, new InternetAddress(wrapper.getCc()));
            
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
