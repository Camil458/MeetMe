package com.meetme.meetme.model;

import com.meetme.meetme._enum.ImageType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class EventDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String address;
    private String locationName;
    private String venueLink;
    private double CoordsLat;
    private double CoordsLng;
    private String ticketInfo;
    private ImageType imageType;
    private String image;
    private String link;
}
