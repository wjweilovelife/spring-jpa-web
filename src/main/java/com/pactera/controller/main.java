package com.pactera.controller;

import com.pactera.entity.Department;
import com.pactera.entity.EmployeeEntity;
import com.pactera.service.DepartmentService;
import com.pactera.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Map;

/**
 * Created by pactera on 2017/11/14.
 */
@Controller
public class main {

   @Autowired
   private EmployeeService employeeService;

   @Autowired
   private DepartmentService departmentService;

   /**
    * 员工列表
    * @param pageNo
    * @param pageSize
    * @param map
    * @return
    */
   @RequestMapping("/emps")
   public String list(@RequestParam(value="pageNo", defaultValue="1") int pageNo,
                      @RequestParam(value = "pageSize",defaultValue = "5") int pageSize ,
                      Map<String, Object> map){
      Page<EmployeeEntity> page = employeeService.getPage(pageNo, pageSize);
      map.put("page", page);
      return "emp/list";
   }
   /**
    * 删除员工信息
    * @param id
    * @return
    */
   @RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
   public String delete(@PathVariable("id") Integer id){
      employeeService.delete(id);
      return "redirect:/emps";
   }

   @ModelAttribute
   public void getEmployee(@RequestParam(value="id",required=false) Integer id,
                           Map<String, Object> map){
      if(id != null){
         EmployeeEntity employee = employeeService.get(id);
         map.put("employee", employee);
      }
   }

   @RequestMapping(value="/emp/{id}",method=RequestMethod.PUT)
   public String update(EmployeeEntity employee) throws ParseException {
      employeeService.save(employee);
      return "redirect:/emps";
   }

   /**
    * 进入员工修改页面
    * @param id
    * @param map
    * @return
    */
   @RequestMapping(value="/emp/{id}", method=RequestMethod.GET)
   public String input(@PathVariable("id") Integer id, Map<String, Object> map){
      EmployeeEntity employee = employeeService.get(id);
      map.put("employeeEntity", employee);
      map.put("departments", departmentService.getAll());
      return "emp/input";
   }

   /**
    * 跳转到input页面
    * @param map
    * @return
    */
   @RequestMapping(value="/emp",method= RequestMethod.GET)
   public String input(Map<String,Object> map){
      map.put("departments", departmentService.getAll());
      map.put("employeeEntity", new EmployeeEntity());
      return "emp/input";
   }

   /**
    * 保存员工信息
    * @param employeeEntity
    * @return
    */
   @RequestMapping(value="/add_emp",method=RequestMethod.POST)
   public String save(EmployeeEntity employeeEntity) throws ParseException {
      employeeService.save(employeeEntity);
      return "redirect:/emps";
   }

   /**
    * 跳转到部门页面
    * @param map
    * @return
    */
   @RequestMapping("/dep")
   public String forwardDep(Map<String,Object> map){
      map.put("department", new Department());
      return "emp/department";
   }

   /**
    * 保存部门
    * @param department
    * @return
    */
   @RequestMapping(value = "/add_dep",method = RequestMethod.POST)
   public String addDep(Department department){
      departmentService.save(department);
      return "redirect:/emps";
   }
}
