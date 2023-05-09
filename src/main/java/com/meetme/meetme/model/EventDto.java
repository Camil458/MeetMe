package com.meetme.meetme.model;

import com.meetme.meetme.entity.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventDto {
    private Long id;
    @NotNull
    @NotEmpty
    private String title;

    private User user;

    @NotNull
    @NotEmpty
    private String description;

    @NotNull
    @NotEmpty
    private String location;

    @NotNull
    @NotEmpty
    private LocalDateTime date;
    private String photoLink;
    private double Lng;
    private double Lat;
    private String ticketInfo;
    private String link;
}
