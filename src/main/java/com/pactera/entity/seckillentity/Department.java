package com.pactera.entity.seckillentity;

import javax.persistence.*;

/**
 * Created by pactera on 2017/11/14.
 */
@Entity
public class Department {
   private int id;
   private String departmentName;


   @GeneratedValue
   @Id
   @Column(name = "id", nullable = false)
   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   @Basic
   @Column(name = "department_name", nullable = true, length = 25)
   public String getDepartmentName() {
      return departmentName;
   }

   public void setDepartmentName(String departmentName) {
      this.departmentName = departmentName;
   }

}
