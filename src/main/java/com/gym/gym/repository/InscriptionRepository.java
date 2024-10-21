package com.gym.gym.repository;

import com.gym.gym.model.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
    // Add any custom query methods if needed
}
