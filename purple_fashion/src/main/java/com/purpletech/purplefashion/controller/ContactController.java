package com.purpletech.purplefashion.controller;

import com.purpletech.purplefashion.model.Contact;
import com.purpletech.purplefashion.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Slf4j
@Controller
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping("/contact")
    public String displayContactPage(Model model) {
        model.addAttribute("isContact", true);
        model.addAttribute("contact", new Contact());
        return "contact.html";
    }

    @PostMapping("/saveMsg") //@RequestMapping(value = "/saveMsg", method = POST)
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact,
                              Errors errors /*, @RequestParam String nickName*/) {
//        log.info("Nick Name : " + nickName);
        if (errors.hasErrors()) {
            log.error("Validation of the Contact form failed : " + errors.toString());
            return "contact.html"; // this will display the contact page with error messages
        }
        contactService.saveMessageDetails(contact);
        return "redirect:/contact"; // this will reload the contact page.
    }

    @RequestMapping("/displayMessages")
    public ModelAndView displayMessages() {
        List<Contact> contactMsgs = contactService.getAllOpenMsgs();
        ModelAndView modelAndView = new ModelAndView("messages.html");
        modelAndView.addObject("message", true);
        modelAndView.addObject("contactMsgs", contactMsgs);
        return modelAndView;
    }
}
