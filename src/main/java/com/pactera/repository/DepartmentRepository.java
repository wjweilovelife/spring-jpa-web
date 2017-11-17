package com.pactera.repository;

import com.pactera.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.List;

/**
 * Created by pactera on 2017/11/14.
 */
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
   @QueryHints({@QueryHint(name=org.hibernate.ejb.QueryHints.HINT_CACHEABLE,value="true")})
   @Query("FROM Department d")
   List<Department> getAll();
}
