package com.pactera.repository.seckillrepo;

import com.pactera.entity.seckillentity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Component;

import javax.persistence.QueryHint;
import java.util.List;

/**
 * Created by pactera on 2017/11/14.
 */
@Component
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
   @QueryHints({@QueryHint(name=org.hibernate.ejb.QueryHints.HINT_CACHEABLE,value="true")})
   @Query("FROM Department d")
   List<Department> getAll();
}
