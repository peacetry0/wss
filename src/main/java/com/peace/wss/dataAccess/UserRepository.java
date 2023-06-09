package com.peace.wss.dataAccess;

import com.peace.wss.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByUserName(String userName) ;
}
