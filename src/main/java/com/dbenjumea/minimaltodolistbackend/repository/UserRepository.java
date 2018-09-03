package com.dbenjumea.minimaltodolistbackend.repository;

import com.dbenjumea.minimaltodolistbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = ?1 and u.password = ?2")
    User findByUsernameAndPassword(String username, String password);
}
