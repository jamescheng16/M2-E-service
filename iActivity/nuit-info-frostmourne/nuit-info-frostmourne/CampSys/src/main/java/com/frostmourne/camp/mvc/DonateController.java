package com.frostmourne.camp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Here should control the page donation, where we could make a donation online,
 * or we can trace our donation(Advanced Function)
 * <p/>
 * Created by jamesRMBP on 05/12/14.
 */
@Controller
public class DonateController {
    @RequestMapping(value = "/donate")
    public String home() {
        return "view/donate";
    }
}
