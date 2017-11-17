package com.pactera.repository;

import com.pactera.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pactera on 2017/11/14.
 */
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {
   EmployeeEntity getByLastName(String lastName);
}
