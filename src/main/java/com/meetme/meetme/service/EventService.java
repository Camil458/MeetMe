package com.meetme.meetme.service;

import com.meetme.meetme.model.EventDTO;

public interface EventService {
    EventDTO saveNewEvent(EventDTO eventDTO);
}
