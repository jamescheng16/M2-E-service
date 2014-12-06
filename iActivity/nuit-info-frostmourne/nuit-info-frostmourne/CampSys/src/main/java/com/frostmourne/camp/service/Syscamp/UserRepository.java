package com.frostmourne.camp.service.Syscamp;

import com.frostmourne.camp.domain.CampSys.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jamesRMBP on 05/12/14.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findUserByUsername(String username);
}
