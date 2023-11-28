package com.oauth.implementation.dao;


import com.oauth.implementation.model.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    // Custom query methods, if needed, can be added here
    PasswordResetToken findByToken(String token);
}

