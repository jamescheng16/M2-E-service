package com.frostmourne.camp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home page controller, finding all presentation
 * <p/>
 * Created by JIN Benli on 04/12/14.
 */
@Controller
public class HomeController {
    @RequestMapping(value = {"/home", "/"})
    public String home(Model model) {

        model.addAttribute("audioUrl", "http://translate.google.com/translate_tts?tl=en&q=Welcometo%20Camp");

        return "view/home";
    }
}
