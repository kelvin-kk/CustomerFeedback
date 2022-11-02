package com.kelvin.customer_feedback.repository;

import com.kelvin.customer_feedback.entity.CustomerFeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerFeedbackRepository extends JpaRepository<CustomerFeedbackEntity, Integer> {
    public Optional<CustomerFeedbackEntity> findByFeedbackId(Integer feedbackId);
}
