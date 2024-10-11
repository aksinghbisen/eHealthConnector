package org.mycarenet;

import be.ehealth.technicalconnector.session.SessionManager;
import be.ehealth.technicalconnector.session.Session;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EHealthApiInvoker {

    public void invokeService() {
        try {
            SessionManager sessionManager = Session.getInstance();
            if (sessionManager.hasValidSession()) {
                // Replace this block with actual business service logic
                log.info("Invoking business service...");
                // Call service method here, e.g. hubService.getHCPartyConsent();
                log.info("Service invoked successfully.");
            } else {
                log.info("No valid session found. Please create a session first.");
            }
        } catch (Exception e) {
            log.error("error inside invokeService due to ", e);
        }
    }
}