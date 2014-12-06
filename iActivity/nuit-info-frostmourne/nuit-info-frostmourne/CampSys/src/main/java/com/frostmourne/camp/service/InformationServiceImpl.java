package com.frostmourne.camp.service;

import com.frostmourne.camp.domain.User;
import com.frostmourne.camp.service.repository.InformationRepository;
import com.frostmourne.camp.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by jamesRMBP on 05/12/14.
 */
@Component(value = "informationService")
public class InformationServiceImpl implements InformationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InformationRepository informationRepository;

    @Override
    public User findUserByName(long uid, String name) {
        Iterable<User> users = userRepository.findAll();

        if (users == null) {
            return null;
        }
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }

        return null;
    }


}
