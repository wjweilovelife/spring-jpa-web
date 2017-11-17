package com.pactera.service;

import com.pactera.entity.EmployeeEntity;
import com.pactera.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pactera on 2017/11/14.
 */
@Service
public class EmployeeService {
   public static final SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
   @Autowired
   private EmployeeRepository employeeRepository;

   @Transactional
   public void delete(Integer id){
      employeeRepository.delete(id);
   }

   @Transactional(readOnly=true)
   public EmployeeEntity get(Integer id){
      return employeeRepository.findOne(id);
   }

   @Transactional
   public void save(EmployeeEntity employeeEntity) throws ParseException {
      if(employeeEntity.getId()==0){
         employeeEntity.setCreateTime(new Date());
      }
      employeeEntity.setBirth(fmt.parse(employeeEntity.getBirthday()));
      employeeRepository.saveAndFlush(employeeEntity);
   }

   @Transactional(readOnly=true)
   public EmployeeEntity getByLastName(String lastName){
      return employeeRepository.getByLastName(lastName);
   }

   @Transactional(readOnly=true)
   public Page<EmployeeEntity> getPage(int pageNo, int pageSize){
      Sort sort = new Sort(Sort.Direction.ASC,"birth");
      PageRequest pageable = new PageRequest(pageNo - 1, pageSize,sort);
      return employeeRepository.findAll(pageable);
   }
}
