package com.EmailAutomation.AI_gen_MAILService.Repository;

import com.EmailAutomation.AI_gen_MAILService.Model.AI_gen_Email;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AI_MailRepository extends MongoRepository<AI_gen_Email,String> {

    AI_gen_Email findByEmail(@NotBlank @Email String email);

    boolean existsByEmail(String email);
}
