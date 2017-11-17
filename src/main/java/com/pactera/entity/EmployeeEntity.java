package com.pactera.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by pactera on 2017/11/17.
 */
@Entity
@Table(name = "employee", schema = "seckill")
public class EmployeeEntity implements Serializable{
   private int id;
   private String lastName;
   private String email;
   private Date createTime;
   private Date birth;
   private String birthday;
   private int departmentId;

   @Id
   @Column(name = "id")
   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   @Basic
   @Column(name = "last_name")
   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   @Basic
   @Column(name = "email")
   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   @Basic
   @Column(name = "create_time")
   public Date getCreateTime() {
      return createTime;
   }

   public void setCreateTime(Date createTime) {
      this.createTime = createTime;
   }

   @Basic
   @Column(name = "birth")
   public Date getBirth() {
      return birth;
   }

   public void setBirth(Date birth) {
      this.birth = birth;
   }
   @Basic
   public String getBirthday() {
      return birthday;
   }

   public void setBirthday(String birthday) {
      this.birthday = birthday;
   }

   @Basic
   @Column(name = "department_id")
   public int getDepartmentId() {
      return departmentId;
   }

   public void setDepartmentId(int departmentId) {
      this.departmentId = departmentId;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      EmployeeEntity that = (EmployeeEntity) o;

      if (id != that.id) return false;
      if (departmentId != that.departmentId) return false;
      if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
      if (email != null ? !email.equals(that.email) : that.email != null) return false;
      if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
      if (birth != null ? !birth.equals(that.birth) : that.birth != null) return false;
      if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;

      return true;
   }

   @Override
   public int hashCode() {
      int result = id;
      result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
      result = 31 * result + (email != null ? email.hashCode() : 0);
      result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
      result = 31 * result + (birth != null ? birth.hashCode() : 0);
      result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
      result = 31 * result + departmentId;
      return result;
   }

}
