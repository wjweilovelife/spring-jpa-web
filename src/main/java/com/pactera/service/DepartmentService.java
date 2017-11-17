package com.pactera.service;

import com.pactera.entity.Department;
import com.pactera.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pactera on 2017/11/14.
 */
@Service
public class DepartmentService {

   @Autowired
   private DepartmentRepository departmentRepository;

   @Transactional(readOnly=true)
   public List<Department> getAll(){
      return departmentRepository.getAll();
   }

   public void save(Department department) {
      departmentRepository.save(department);
   }
}
