package com.frostmourne.camp.service;

import com.frostmourne.camp.domain.activity.Activity;
import com.frostmourne.camp.service.repository.Activity.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by jamesRMBP on 06/12/14.
 */
@Component(value = "activityService")
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    ActivityRepository activityRepository;


    @Override
    public List<Activity> findAllActivities() {
        return (List<Activity>) activityRepository.findAll();
    }

    @Override
    public void saveActivity(Activity activity) {

        activityRepository.save(activity);
    }


}
