package com.scm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    // extra method db relatedOptions
    // Custom query methods
    // Custom finder methods

    // find by email
    User findByEmail(String email);

    // find by email and password
    User findByEmailAndPassword(String email, String password);

}
