package com.purpletech.purplefashion.service;

import com.purpletech.purplefashion.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Slf4j
@Service
@RequestScope
public class ContactService {

    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = true;
        // TO-DO save the info received to the DB
        log.info(contact.toString());
        return isSaved;
    }

}
