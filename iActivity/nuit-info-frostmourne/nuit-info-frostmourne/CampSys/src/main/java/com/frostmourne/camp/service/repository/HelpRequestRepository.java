package com.frostmourne.camp.service.repository;

import com.frostmourne.camp.domain.HelpRequest;
import com.frostmourne.camp.domain.HelpRequestType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jamesRMBP on 05/12/14.
 */
public interface HelpRequestRepository extends CrudRepository<HelpRequest, Long> {
    public List<HelpRequest> findHelpRequestByType(HelpRequestType helpRequestType);

}
