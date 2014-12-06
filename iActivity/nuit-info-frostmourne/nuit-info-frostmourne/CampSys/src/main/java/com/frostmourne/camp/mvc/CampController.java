package com.frostmourne.camp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Camp controller for camp page, here we have considered to develop with finding the closet camp
 * Searching all activities like making friends in camps, activity hold by camps etc
 * Created by JIN Benli on 04/12/14.
 */
@Controller
public class CampController {
    /**
     * Static page showing finding a camp according the user's location
     *
     * @return
     */
    @RequestMapping(value = "/camp")
    public String home() {
        return "view/camp";
    }
}
