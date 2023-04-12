package com.meetme.meetme.entity;

import com.meetme.meetme._enum.EventType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="searches")
public class Search {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private Long id;

    @Column(name="query", nullable=true)
    private String query;

    @Column(name="location_string", nullable=true)
    private String locationString;

    @Enumerated(EnumType.STRING)
    @Column(name="event_type", nullable=true)
    private EventType eventType;

    @Column(name="event_date", nullable=true)
    private LocalDateTime eventDate;
}
