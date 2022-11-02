package com.kelvin.customer_feedback.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer_review")
public class CustomerFeedbackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer feedbackId;
    public String customerName;
    public String date;
    public String content;


    //Getters and Setters
    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //To String
    @Override
    public String toString() {
        return "CustomerFeedbackEntity{" +
                "feedbackId=" + feedbackId +
                ", customerName='" + customerName + '\'' +
                ", date=" + date +
                ", content='" + content + '\'' +
                '}';
    }
}
