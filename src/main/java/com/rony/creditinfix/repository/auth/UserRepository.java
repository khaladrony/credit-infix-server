package com.rony.creditinfix.repository.auth;


import com.rony.creditinfix.entity.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Query("select count(u) from User u where u.id <> ?1 AND u.username = ?2 ")
    int countByUsername(Long id, String username);
}
