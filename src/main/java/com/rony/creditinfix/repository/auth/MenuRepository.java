package com.rony.creditinfix.repository.auth;

import com.rony.creditinfix.entity.auth.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    Optional<Menu> findByName(String name);

    @Query("select count(m) from Menu m where m.id <> ?1 AND m.name = ?2 ")
    int countByName(Long id, String name);
}
