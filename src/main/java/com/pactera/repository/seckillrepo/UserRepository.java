package com.pactera.repository.seckillrepo;

import com.pactera.entity.seckillentity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author wjwei
 */
@Component
public interface UserRepository extends JpaRepository<User,Integer> {
}
