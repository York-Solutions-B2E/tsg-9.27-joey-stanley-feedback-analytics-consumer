package com.joey.stanley.group.project.feedback_analytics_consumer.messaging;

import com.joey.stanley.group.project.feedback_analytics_consumer.dtos.FeedbackSubmittedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class FeedbackEventListener {

    private static final Logger log = LoggerFactory.getLogger(FeedbackEventListener.class);

    @KafkaListener(
            topics = "feedback-submitted",
            groupId = "feedback-analytics-group")
    public void feedbackListener(FeedbackSubmittedEvent event) {
        log.info("Received feedback: id={} memberId={} providerName={} rating={} comment={} submittedAt={} schemaVersion={}",
                event.getId(),
                event.getMemberId(),
                event.getProviderName(),
                event.getRating(),
                event.getComment(),
                event.getSubmittedAt(),
                event.getSchemaVersion()
        );
    }
}
