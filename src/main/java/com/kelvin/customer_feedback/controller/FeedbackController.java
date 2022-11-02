package com.kelvin.customer_feedback.controller;

import com.kelvin.customer_feedback.entity.CustomerFeedbackEntity;
import com.kelvin.customer_feedback.service.FeedbackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FeedbackController {
    @Autowired
    private FeedbackServiceImpl feedbackServiceImpl;

    //Create
    @PostMapping("/addFeedback")
    public ResponseEntity<CustomerFeedbackEntity> createFeedback(@RequestBody CustomerFeedbackEntity feedback){
        return feedbackServiceImpl.createFeedback(feedback);
    }

    //ListAll
    @GetMapping("/feedback")
    public List<CustomerFeedbackEntity> listAllFeedbacks(){
        return feedbackServiceImpl.fetchFeedbackList();
    }

    //ListById
    @GetMapping("/listFeedback/{feedbackId}")
    public ResponseEntity<CustomerFeedbackEntity> listFeedbackById (@PathVariable("feedbackId") Integer feedbackId){
        return feedbackServiceImpl.fetchById(feedbackId);
    }

    //DeleteById
    @DeleteMapping("/deleteFeedback/{feedbackId}")
    public ResponseEntity<String> deleteById(@PathVariable("feedbackId") Integer feedbackId){
        return feedbackServiceImpl.deleteById(feedbackId);
    }

    @PutMapping("/updateFeedback/{feedbackId}")
    public ResponseEntity<CustomerFeedbackEntity> updateCustomerFeedback(@RequestBody CustomerFeedbackEntity feedback,
                                                                        @PathVariable("feedbackId")
                                                         Integer feedbackId){
        return feedbackServiceImpl.updateFeedback(feedback,feedbackId);
    }
}

