package com.pactera.entity;

import javax.persistence.*;

/**
 * Created by pactera on 2017/11/14.
 */
@Entity
public class Department {
   private Integer id;
   private String departmentName;

   @GeneratedValue
   @Id
   @Column(name = "id", nullable = false)
   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
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

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Department that = (Department) o;

      if (id != that.id) return false;
      if (departmentName != null ? !departmentName.equals(that.departmentName) : that.departmentName != null)
         return false;

      return true;
   }

   @Override
   public int hashCode() {
      int result = id;
      result = 31 * result + (departmentName != null ? departmentName.hashCode() : 0);
      return result;
   }
}
