package com.meetme.meetme.model;

import com.meetme.meetme._enum.EventType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class SearchDTO {
    private Long id;
    private String query;
    private String locationString;
    private EventType eventType;
    private LocalDateTime eventDate;
}