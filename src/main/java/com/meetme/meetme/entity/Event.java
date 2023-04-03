package com.meetme.meetme.entity;

import com.meetme.meetme._enum.ImageType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private Long id;

    @Column(name="title", nullable=false)
    private String title;

    @Column(name="description", nullable=false)
    private String description;

    @Column(name="start_date", nullable=false)
    private LocalDateTime startDate;

    @Column(name="end_date", nullable=false)
    private LocalDateTime endDate;

    @Column(name="address", nullable=false)
    private String address;

    @Column(name="location_name", nullable=false)
    private String locationName;

    @Column(name="venue_link", nullable=true)
    private String venueLink;

    @Column(name="coords_lat", nullable=false)
    private double CoordsLat;

    @Column(name="coords_lng", nullable=false)
    private double CoordsLng;

    // TODO: Conversion -> replace String with custom class
    @Column(name="ticket_info", nullable=true, columnDefinition="JSON")
    private String ticketInfo;

    @Enumerated(EnumType.STRING)
    @Column(name="image_type", nullable=true)
    private ImageType imageType;

    @Column(name="image", nullable=true)
    private String image;

    @Column(name="link", nullable=true)
    private String link;
}
