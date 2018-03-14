package com.pactera.service.seckillservice;

import com.pactera.entity.seckillentity.Employee;
import com.pactera.repository.seckillrepo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pactera on 2017/11/14.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeeService {
   public static final SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
   @Autowired
   private EmployeeRepository employeeRepository;

   public void delete(Integer id){
      employeeRepository.delete(id);
   }

   public Employee get(Integer id){
      return employeeRepository.findOne(id);
   }


   public void save(Integer id, String name, String email, Integer dpartid){
      Employee employee = null;
      if(!StringUtils.isEmpty(id)){
         employee = employeeRepository.findOne(id);
      }else {
          employee = new Employee();
          employee.setLastName(name);
          employee.setEmail(email);
          employee.setCreateTime(new Date());
          employee.setDepartmentId(dpartid);
      }
      employeeRepository.saveAndFlush(employee);
   }

   public Employee getByLastName(String lastName){
      return employeeRepository.getByLastName(lastName);
   }

   public Page<Employee> getPage(int pageNo, int pageSize){
      Sort sort = new Sort(Sort.Direction.ASC,"birth");
      PageRequest pageable = new PageRequest(pageNo - 1, pageSize,sort);
      return employeeRepository.findAll(pageable);
   }
}
