package com.purpletech.purplefashion.service;

import com.purpletech.purplefashion.constants.PurpleFashionConstants;
import com.purpletech.purplefashion.model.Contact;
import com.purpletech.purplefashion.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequestScope
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = false;
        contact.setStatus(PurpleFashionConstants.OPEN);
        contact.setCreatedBy(PurpleFashionConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());
        int result = contactRepository.saveContactMsg(contact);
        if(result > 0)
            isSaved = true;
        return isSaved;
    }

    public List<Contact> getAllOpenMsgs() {
        List<Contact> contactMsgs = contactRepository.getMsgsWithStatus(PurpleFashionConstants.OPEN);
        return contactMsgs;
    }
}
