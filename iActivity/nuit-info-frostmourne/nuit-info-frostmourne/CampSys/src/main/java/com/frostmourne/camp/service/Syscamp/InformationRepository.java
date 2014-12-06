package com.frostmourne.camp.service.Syscamp;

import com.frostmourne.camp.domain.CampSys.Information;
import com.frostmourne.camp.domain.CampSys.InformationType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jamesRMBP on 05/12/14.
 */
public interface InformationRepository extends CrudRepository<Information, Long> {
    public List<Information> findInformationByType(InformationType informationType);

}
