package com.kelvin.customer_feedback.service;

import com.kelvin.customer_feedback.entity.CustomerFeedbackEntity;
import org.hibernate.mapping.Any;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface FeedbackService {
    //Create
    ResponseEntity<CustomerFeedbackEntity> createFeedback(CustomerFeedbackEntity feedback);
    //List all
    List<CustomerFeedbackEntity> fetchFeedbackList();
    //ListById
    ResponseEntity<CustomerFeedbackEntity> fetchById(int feedbackId);
    //DeleteById
    ResponseEntity<String> deleteById(Integer feedbackId);
    //UpdateById
    public ResponseEntity<CustomerFeedbackEntity> updateFeedback(CustomerFeedbackEntity feedback, Integer feedbackId);
}
