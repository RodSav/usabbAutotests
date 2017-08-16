package com.usabb.utils;

import com.usabb.locators.SiteData;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.activation.DataHandler;
import javax.mail.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class EmailUtils {

    private static final Logger logger = LoggerFactory.getLogger(EmailUtils.class);

    private static final String USER_NAME = SiteData.TEST_USER_EMAIL;
    private static final String USER_PASSWORD = SiteData.TEST_USER_PASSWORD;
    private static final String FOLDER = "Inbox";
    private static final String HOST = "pop.gmail.com";

    private static Message getLastMessageBySubject(String subject) {
        List<Message> filteredMessages = getMessagesBySubject(subject);
        return filteredMessages.get(filteredMessages.size() - 1);
    }

    private static List<Message> getMessagesBySubject(String subject) {
        List<Message> inboxMessages = getInboxMessages(HOST, FOLDER, USER_NAME, USER_PASSWORD);
        List<Message> filteredMessages = new ArrayList<>();
        for (Message message : inboxMessages) {
            try {
                if (message.getSubject().equalsIgnoreCase(subject)) filteredMessages.add(message);
            } catch (MessagingException e) {
                logger.info("Cannot read mail {}", e.toString());
            }
        }
        return filteredMessages;
    }

    public static String getLastMessageHtmlContentBySubject(String subject) {
        Message message = getLastMessageBySubject(subject);
        String content = "";
        try {
            if (message.getContent().toString().contains("Multipart")) content = getMultipartContent(message);
            else content = message.getContent().toString();
        } catch (IOException | MessagingException e) {
            logger.info("Cannot get content {}", e.toString());
        }
        return content;
    }

    public static String getLastMessageContentBySubject(String subject) {
        return Jsoup.parse(getLastMessageHtmlContentBySubject(subject)).text();
    }

    public static Date getLastMessageDateBySubject(String subject) {
        Message message = getLastMessageBySubject(subject);
        Date date = new Date();
        try {
            date = message.getSentDate();
        } catch (MessagingException e) {
            logger.info("Cannot get send date of email {}", e.toString());
        }
        return date;
    }

    private static List<Message> getInboxMessages(final String host, final String folder, final String user,
                                                  final String password) {
        try {
            Properties properties = new Properties();
            properties.put("mail.pop3.host", host);
            properties.put("mail.pop3.port", "995");
            properties.put("mail.pop3.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);
            Store store = emailSession.getStore("pop3s");
            store.connect(host, user, password);
            logger.info("Connected to an email box");
            Folder emailFolder = store.getFolder(folder);
            emailFolder.open(Folder.READ_ONLY);
            List<Message> messages = new ArrayList<>();
            Message[] emailFolderMessages = emailFolder.getMessages();
            for (Message message : emailFolderMessages) {
                messages.add(message);
            }
            return messages;
        } catch (MessagingException e) {
            logger.info("Cannot get mail {}", e.toString());
        }
        return new ArrayList<>();
    }

    private static String getMultipartContent(Message message) {
        String content = new String();
        try {
            Multipart multipart = (Multipart) message.getContent();
            for (int j = 0; j < multipart.getCount(); j++) {
                BodyPart bodyPart = multipart.getBodyPart(j);
                String disposition = bodyPart.getDisposition();
                if (disposition != null && (disposition.equalsIgnoreCase("ATTACHMENT"))) {
                    logger.debug("Mail have some attachment");
                    DataHandler handler = bodyPart.getDataHandler();
                    logger.debug("file name : " + handler.getName());
                } else {
                    logger.debug("Body: " + bodyPart.getContent());
                    content = bodyPart.getContent().toString();
                }
            }
        } catch (IOException | MessagingException e) {
            logger.info("Cannot read mail {}", e.toString());
        }
        return content;
    }
}
