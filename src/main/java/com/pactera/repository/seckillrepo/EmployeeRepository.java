package com.pactera.repository.seckillrepo;

import com.pactera.entity.seckillentity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author  by pactera on 2017/11/14.
 */
@Component
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
   Employee getByLastName(String lastName);
}
