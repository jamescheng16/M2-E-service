package com.frostmourne.camp.service;

import com.frostmourne.camp.domain.activity.Activity;

import java.util.List;

/**
 * Created by jamesRMBP on 06/12/14.
 */
public interface ActivityService {

    public List<Activity> findAllActivities();

    public void saveActivity(Activity activity);
}
