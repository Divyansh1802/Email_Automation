package com.EmailAutomation.UserService.Repository;

import com.EmailAutomation.UserService.Model.User_Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User_Client, UUID> {

    boolean existsByEmail(String email);

    User_Client findByEmail(String email);
}
