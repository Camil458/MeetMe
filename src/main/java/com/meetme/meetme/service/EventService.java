package com.meetme.meetme.service;

import com.meetme.meetme.model.EventDto;
import org.json.JSONObject;

import java.util.List;
import java.util.Optional;

public interface EventService {
    Optional<EventDto> getEventById(Long id);

    List<JSONObject> getEvents();

    EventDto saveNewEvent(EventDto eventDto);

    Boolean deleteById(Long id);
}
