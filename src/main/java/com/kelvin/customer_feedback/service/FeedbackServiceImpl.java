package com.kelvin.customer_feedback.service;

import com.kelvin.customer_feedback.entity.CustomerFeedbackEntity;
import com.kelvin.customer_feedback.repository.CustomerFeedbackRepository;
import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private CustomerFeedbackRepository feedbackRepository;

    //Create - HTTP Response done
    public ResponseEntity<CustomerFeedbackEntity> createFeedback(CustomerFeedbackEntity feedback) {
        CustomerFeedbackEntity createResponse = feedbackRepository.save(feedback);
        return ResponseEntity.status(HttpStatus.CREATED).body(createResponse);
    }

    //ListAll
    public List<CustomerFeedbackEntity> fetchFeedbackList(){
        return (List<CustomerFeedbackEntity>) feedbackRepository.findAll();
    }

    //ListById - HTTP Response done
    public ResponseEntity<CustomerFeedbackEntity> fetchById(int feedbackId){
        Optional<CustomerFeedbackEntity> fetchId = feedbackRepository.findByFeedbackId(feedbackId);
        if (fetchId.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(feedbackRepository.findById(feedbackId).get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //DeleteById
    public  ResponseEntity<String> deleteById(Integer feedbackId){
        Optional<CustomerFeedbackEntity> record = feedbackRepository.findByFeedbackId(feedbackId);
        if (record.isPresent()) {
            feedbackRepository.deleteById(feedbackId);
            return ResponseEntity.status(HttpStatus.OK).body("Record Deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //UpdateById
    public ResponseEntity<CustomerFeedbackEntity> updateFeedback(CustomerFeedbackEntity feedback, Integer feedbackId) {
        Optional<CustomerFeedbackEntity> inDB = feedbackRepository.findByFeedbackId(feedbackId);
        CustomerFeedbackEntity response = null;
        if (inDB.isPresent()) {
           var data = inDB.get();
            data.setCustomerName(feedback.getCustomerName());
            data.setDate(feedback.getDate());
            data.setContent(feedback.getContent());
            response = feedbackRepository.save(data);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
