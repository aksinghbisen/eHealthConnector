package org.mycarenet;

import be.ehealth.technicalconnector.session.SessionManager;
import be.ehealth.technicalconnector.session.Session;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SessionHandler {

    public void setupSession() {
        String hokPassword = "yourHolderOfKeyPassword";
        String personalPassword = "yourPersonalCertificatePassword";
        try {
            SessionManager sessionManager = Session.getInstance();
            if (!sessionManager.hasValidSession()) {
                log.info("Creating a new session...");
                sessionManager.createSession(hokPassword, personalPassword);
                log.info("Session created successfully.");
            } else {
                log.info("Session already exists.");
            }
        } catch (Exception e) {
            log.error("error inside setupSession due to ", e);
        }
    }

    public void unloadSession() {
        try {
            SessionManager sessionManager = Session.getInstance();
            if (sessionManager.hasValidSession()) {
                sessionManager.unloadSession();
                log.info("Session unloaded successfully.");
            } else {
                log.info("No session to unload.");
            }
        } catch (Exception e) {
            log.error("error inside due to ", e);
        }
    }
}