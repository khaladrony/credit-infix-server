package com.rony.creditinfix.repository.auth;

import com.rony.creditinfix.entity.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);

    @Query("select count(r) from Role r where r.id <> ?1 AND r.name = ?2 ")
    int countByName(Long id, String name);
}
