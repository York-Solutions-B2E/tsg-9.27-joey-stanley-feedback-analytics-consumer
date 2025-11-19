package com.joey.stanley.group.project.feedback_analytics_consumer.messaging;

import com.joey.stanley.group.project.feedback_analytics_consumer.dtos.FeedbackSubmittedEvent;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class FeedbackEventListenerTest {

    private final FeedbackEventListener feedbackEventListener = new FeedbackEventListener();

    @Test
    void feedbackListener_handleEvent_withoutException() {
        //Arrange
        FeedbackSubmittedEvent event = new FeedbackSubmittedEvent();
        event.setId(UUID.randomUUID().toString());
        event.setMemberId("m-1337");
        event.setProviderName("Provider 1");
        event.setRating(5);
        event.setComment("He fixed all my problems!");
        event.setSubmittedAt(Instant.now());
        event.setSchemaVersion(1);

        //Act & Assert - Ensures function runs without throwing exception for a valid event
        //assert... expects an Executable (box to run code). Use Lambda as shorthand
        assertDoesNotThrow(() -> feedbackEventListener.feedbackListener(event));
    }
}
