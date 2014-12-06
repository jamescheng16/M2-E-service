package com.frostmourne.camp.rest;

import com.frostmourne.camp.Application;
import com.frostmourne.camp.domain.Information;
import com.frostmourne.camp.domain.InformationType;
import com.frostmourne.camp.service.repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by jamesRMBP on 05/12/14.
 */

@Controller
@Import(Application.class)
public class InformationRestService {

    @Autowired
    InformationRepository informationRepository;

    /**
     * this method give all the information
     *
     * @return list of all the information in jason
     */
    @RequestMapping(value = "/api/getAllInformation", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Information> getAll() {
        return (List<Information>) informationRepository.findAll();
    }


    /**
     *  /**
     * find family information
     */


    /**
     * vaccine information
     */


    /**
     * for alert the security danger
     */


    /**
     * normal
     */


    /**
     * this method give the api to get all the informations of a type
     *
     * @param type information type
     * @return all the information of a type in jason
     */
    @RequestMapping(value = "/api/getInformation/{type}", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Information> getInformationByType(@PathVariable String type) {
        if (type.equals("findmyfamily")) {
            return informationRepository.findInformationByType(InformationType.FindMyFamily);
        }
        if (type.equals("vaccine")) {
            return informationRepository.findInformationByType(InformationType.Vaccine);
        }
        if (type.equals("security")) {
            return informationRepository.findInformationByType(InformationType.Security);
        }

        if (type.equals("normal")) {
            return informationRepository.findInformationByType(InformationType.normal);
        }

        return (List<Information>) informationRepository.findAll();
    }


}
