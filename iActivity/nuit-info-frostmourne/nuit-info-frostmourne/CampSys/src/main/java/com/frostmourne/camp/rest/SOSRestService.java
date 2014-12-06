package com.frostmourne.camp.rest;

import com.frostmourne.camp.domain.HelpRequest;
import com.frostmourne.camp.domain.HelpRequestType;
import com.frostmourne.camp.service.repository.HelpRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * this class give the all the information by rest in jason
 * Created by jamesRMBP on 05/12/14.
 */
@Controller
public class SOSRestService {

    @Autowired
    HelpRequestRepository helpRequestRepository;

    /**
     * this method give all the sos request
     *
     * @return list of all the sos request in jason
     */
    @RequestMapping(value = "/api/getallsos", method = RequestMethod.GET)
    public
    @ResponseBody
    List<HelpRequest> getAll() {
        return (List<HelpRequest>) helpRequestRepository.findAll();
    }


    /**
     * this method give the api to get all the help request of a type
     *
     * @param type help request type
     * @return all the help request of a type in jason
     */
    @RequestMapping(value = "/api/gethelprequest/{type}", method = RequestMethod.GET)
    public
    @ResponseBody
    List<HelpRequest> getInformationByType(@PathVariable String type) {
        if (type.equals("mental")) {
            return helpRequestRepository.findHelpRequestByType(HelpRequestType.mental);
        }
        if (type.equals("body")) {
            return helpRequestRepository.findHelpRequestByType(HelpRequestType.body);
        }
        return null;
    }


}
