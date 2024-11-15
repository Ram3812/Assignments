package com.purpletech.purplefashion.controller;

import com.purpletech.purplefashion.model.Faq;
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
        List<Faq> faqs = Arrays.asList(
                new Faq("How do I support your website?", "You can support our Tooplate website by sharing it to your friends or colleagues on the web or social media.", Faq.Type.GENERAL),
                new Faq("What is this Purple Fashion?", "Purple Fashion is free Bootstrap 5 website template for everyone. There are 8 HTML pages included in this template and you can expand more pages as you need. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", Faq.Type.GENERAL),
                new Faq("What is Tooplate website?", "Tooplate is a great website to download free HTML website templates for your business or personal use. Tooplate website has been online for almost 8 years now. Thank you for visiting our website.", Faq.Type.GENERAL),
                new Faq("What is Fashion Design?", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida. Risus commodo viverra maecenas accumsan lacus vel facilisis.", Faq.Type.PRODUCT),
                new Faq("How do I use the product?", "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups.", Faq.Type.PRODUCT)
        );
        Faq.Type[] types = Faq.Type.values();
        for(Faq.Type type : types) {
            model.addAttribute(type.toString(), (faqs.stream().filter(faq -> faq.getType().equals(type)).collect(Collectors.toList())));
        }
        return "faq.html";
    }

}
