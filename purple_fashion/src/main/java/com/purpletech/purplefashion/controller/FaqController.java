package com.purpletech.purplefashion.controller;

import com.purpletech.purplefashion.model.Faq;
import com.purpletech.purplefashion.repository.FaqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FaqController {

    @Autowired
    private FaqRepository faqRepository;

    @GetMapping("/faq/{display}")
    public String displayFaqs(@PathVariable String display,
                              @RequestParam(required = false, defaultValue = "true") boolean general,
                              @RequestParam(required = false, defaultValue = "true") boolean product, Model model) {
        model.addAttribute("faq", true);
        if (display != null && display.equals("all")) {
            model.addAttribute("general", true);
            model.addAttribute("product", true);
        } else if (display != null && display.equals("general")) {
            model.addAttribute("general", true);
            model.addAttribute("product", product);
        } else if (display != null && display.equals("product")) {
            model.addAttribute("general", general);
            model.addAttribute("product", true);
        }
        List<Faq> faqs = faqRepository.retrieveFaqs();
        Faq.Type[] types = Faq.Type.values();
        for(Faq.Type type : types) {
            model.addAttribute(type.toString(), (faqs.stream().filter(faq -> faq.getType().equals(type)).collect(Collectors.toList())));
        }
        return "faq.html";
    }

}
