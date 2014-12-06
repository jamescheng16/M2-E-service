package com.frostmourne.camp.service.repository;

import com.frostmourne.camp.domain.Information;
import com.frostmourne.camp.domain.InformationType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jamesRMBP on 05/12/14.
 */
public interface InformationRepository extends CrudRepository<Information, Long> {
    public List<Information> findInformationByType(InformationType informationType);

}
