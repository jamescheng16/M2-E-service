package com.frostmourne.camp.mvc;

import com.frostmourne.camp.Application;
import com.frostmourne.camp.domain.HelpRequest;
import com.frostmourne.camp.domain.HelpRequestType;
import com.frostmourne.camp.domain.User;
import com.frostmourne.camp.service.repository.HelpRequestRepository;
import com.frostmourne.camp.service.repository.UserRepository;
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
 * Here we listing all SOS messages or posting some SOS messages
 * <p/>
 * Created by jamesRMBP on 05/12/14.
 */
@Controller
@Import(Application.class)
public class SOSController {
    private Logger log = Logger.getLogger(InfoController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HelpRequestRepository helpRequestRepository;

    /**
     * Listing all mental demands
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/sosmental")
    public String sosmental(Model model) {
        model.addAttribute("title", "Mental service");
        model.addAttribute("infos", helpRequestRepository.findHelpRequestByType(HelpRequestType.mental));
        return "view/sos";
    }

    /**
     * Listing all physical demands
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/sosphysical")
    public String sosphysical(Model model) {
        model.addAttribute("title", "Physical service");
        model.addAttribute("infos", helpRequestRepository.findHelpRequestByType(HelpRequestType.body));
        return "view/sos";
    }

    /**
     * Listing all demands
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/sosall")
    public String sosall(Model model) {
        model.addAttribute("title", "Physical service");
        model.addAttribute("infos", helpRequestRepository.findAll());
        return "view/sos";
    }

    /**
     * Listing a form to post a SOS message
     *
     * @param helpRequest
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/sospost")
    public String post(final HelpRequest helpRequest, Model model, HttpSession session) {
        log.info("[SOSController: info], posting new demand");
        List<User> testList = userRepository.findUserByUsername("test");
        User test = testList.get(0);
        model.addAttribute("title", "All");
        session.setAttribute("test", test);
        model.addAttribute("users", userRepository.findAll());
        List<HelpRequestType> allType = new ArrayList<HelpRequestType>(Arrays.asList(HelpRequestType.values()));
        model.addAttribute("allType", allType);
        log.info(model);
        return "view/sospost";
    }

    /**
     * Receiving the SOS message
     *
     * @param helpRequest
     * @param session
     * @param bindingResult
     * @param model
     * @return
     */
    @RequestMapping(value = "/sospost", method = RequestMethod.POST, params = {"save"})
    public String post(final HelpRequest helpRequest, HttpSession session, final BindingResult bindingResult, final ModelMap model) {
        log.info("[SOSController: info], posting new demand");
        if (bindingResult.hasErrors()) {
            log.error(bindingResult.getAllErrors());
            return "view/sospost";
        }

        User test = (User) session.getAttribute("test");
        helpRequest.setAuthor(test);
        helpRequest.setDate(new Date());
        helpRequestRepository.save(helpRequest);
        model.clear();
        log.info(model);
        log.info(helpRequestRepository);
        return "redirect:/sosall";
    }


}
