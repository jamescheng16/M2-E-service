package com.frostmourne.camp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jamesRMBP on 06/12/14.
 */
@Controller
public class SameController {


    /**
     * Listing all messages for planting the vaccine
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/same")
    public String memberinfo(Model model) {

        return "view/same";
    }



}
