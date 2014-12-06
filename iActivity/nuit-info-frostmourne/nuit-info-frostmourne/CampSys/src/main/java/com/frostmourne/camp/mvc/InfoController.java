package com.frostmourne.camp.mvc;

import com.frostmourne.camp.Application;
import com.frostmourne.camp.domain.Information;
import com.frostmourne.camp.domain.InformationType;
import com.frostmourne.camp.domain.User;
import com.frostmourne.camp.service.repository.InformationRepository;
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
import java.util.List;

/**
 * Here control all parts for showing and posting message in our application for those people who will need
 * some help
 * <p/>
 * Created by JIN Benli on 04/12/14.
 */
@Controller
@Import(Application.class)
public class InfoController {
    private Logger log = Logger.getLogger(InfoController.class);

    @Autowired
    private InformationRepository informationRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Listing all messages for finding their family
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/find")
    public String info(Model model) {
        log.info("[InfoController: info], listing info find family");
        model.addAttribute("infos", informationRepository.findInformationByType(InformationType.FindMyFamily));
        model.addAttribute("title", "Finding your family!");
        return "view/info";
    }

    /**
     * Listing all messages for planting the vaccine
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/vaccine")
    public String vaccine(Model model) {
        log.info("[InfoController: info], listing info Vaccine");
        model.addAttribute("infos", informationRepository.findInformationByType(InformationType.Vaccine));
        model.addAttribute("title", "Vaccines");
        return "view/info";
    }

    /**
     * Listing all messages for security
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/security")
    public String security(Model model) {
        log.info("[InfoController: info], listing info security");
        model.addAttribute("infos", informationRepository.findInformationByType(InformationType.Security));
        model.addAttribute("title", "Security");
        return "view/info";
    }

    /**
     * Listing all messages
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/all")
    public String all(Model model) {
        log.info("[InfoController: info], listing info all");
        model.addAttribute("infos", informationRepository.findAll());
        model.addAttribute("title", "All");
        log.info(model);
        return "view/info";
    }

    /**
     * Listing the form for posting a message
     *
     * @param information
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/infopost")
    public String post(final Information information, Model model, HttpSession session) {
        log.info("[InfoController: info], listing info all");
        List<User> testList = userRepository.findUserByUsername("test");
        User test = testList.get(0);
        model.addAttribute("title", "All");
        session.setAttribute("test", test);
        model.addAttribute("users", userRepository.findAll());
        List<InformationType> allType = new ArrayList<InformationType>(Arrays.asList(InformationType.values()));
        model.addAttribute("allType", allType);
        log.info(model);
        return "view/post";
    }

    /**
     * Receiving a posted message
     *
     * @param information
     * @param session
     * @param bindingResult
     * @param model
     * @return
     */
    @RequestMapping(value = "/infopost", method = RequestMethod.POST, params = {"save"})
    public String post(final Information information, HttpSession session, final BindingResult bindingResult, final ModelMap model) {
        log.info("[InfoController: post], posting an information");
        if (bindingResult.hasErrors()) {
            log.error(bindingResult.getAllErrors());
            return "view/post";
        }

        User test = (User) session.getAttribute("test");
        information.setSenderPerson(test);
        informationRepository.save(information);
        model.clear();
        log.info(model);
        log.info(informationRepository);
        return "redirect:/all";
    }

}
