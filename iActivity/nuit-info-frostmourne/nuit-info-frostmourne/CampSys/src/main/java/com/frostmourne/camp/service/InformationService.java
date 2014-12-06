package com.frostmourne.camp.service;

import com.frostmourne.camp.domain.User;

/**
 * Created by jamesRMBP on 05/12/14.
 */
public interface InformationService {

    public User findUserByName(long uid, String name);


}
