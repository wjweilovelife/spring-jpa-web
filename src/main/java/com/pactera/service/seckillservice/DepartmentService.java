package com.pactera.service.seckillservice;

import com.pactera.entity.seckillentity.Department;
import com.pactera.repository.seckillrepo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pactera on 2017/11/14.
 */
@Service
@Transactional
public class DepartmentService {

   @Autowired
   private DepartmentRepository departmentRepository;


   public List<Department> getAll(){
      return departmentRepository.getAll();
   }

   public void save(Department department) {
      departmentRepository.save(department);
   }
}
