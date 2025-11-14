package com.joey.stanley.group.project.feedback_analytics_consumer.messaging;

import com.joey.stanley.group.project.feedback_analytics_consumer.dtos.FeedbackSubmittedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class FeedbackEventListener {
    @KafkaListener(
            topics = "feedback-submitted",
            groupId = "feedback-analytics-group")
    public void feedbackListener(FeedbackSubmittedEvent event) {
        System.out.println("Received feedback event: " + event);
    }
}
