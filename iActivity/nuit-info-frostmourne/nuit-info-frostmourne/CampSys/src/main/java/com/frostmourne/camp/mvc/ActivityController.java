package com.frostmourne.camp.mvc;

import com.frostmourne.camp.Application;
import com.frostmourne.camp.domain.CampSys.HelpRequest;
import com.frostmourne.camp.domain.CampSys.HelpRequestType;
import com.frostmourne.camp.domain.CampSys.User;
import com.frostmourne.camp.domain.activity.Activity;
import com.frostmourne.camp.mvc.CampSys.InfoController;
import com.frostmourne.camp.service.ActivityService;
import com.frostmourne.camp.service.ActivityServiceImpl;
import com.frostmourne.camp.service.repository.Activity.ActivityRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by jamesRMBP on 06/12/14.
 */

@Controller
@Import(Application.class)
public class ActivityController {


    private Logger log = Logger.getLogger(InfoController.class);


    @Autowired
    private ActivityService activityService;

    @RequestMapping(value = "/activity")
    public String activityHome(Model model) {
        model.addAttribute("title", "Mental service");
        model.addAttribute("activities", activityService.findAllActivities());
        return "view/activity";
    }




    @RequestMapping(value = "/activitypost")
    public String post(final Activity activity, Model model, HttpSession session) {



        return "view/activitypost";
    }

    /**
     *
     * @param activity
     * @param session
     * @param bindingResult
     * @param model
     * @return
     */
    @RequestMapping(value = "/activitypost", method = RequestMethod.POST, params = {"save"})
    public String post(final Activity activity, HttpSession session, final BindingResult bindingResult, final ModelMap model) {
        log.info("[SOSController: info], posting new demand");
        if (bindingResult.hasErrors()) {
            log.error(bindingResult.getAllErrors());
            return "view/activity";
        }



        activity.setDate(new Date());
        activityService.saveActivity(activity);

        model.clear();
        log.info(model);

        return "redirect:/activity";
    }



}
