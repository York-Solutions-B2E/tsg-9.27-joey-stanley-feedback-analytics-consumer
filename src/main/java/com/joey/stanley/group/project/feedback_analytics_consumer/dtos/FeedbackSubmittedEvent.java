package com.joey.stanley.group.project.feedback_analytics_consumer.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class FeedbackSubmittedEvent {
    private String id;
    private String memberId;
    private String providerName;
    private int rating;
    private String comment;
    private Instant submittedAt;
    private int schemaVersion = 1;

}

