package com.meetme.meetme.service;

import com.meetme.meetme.mapper.EventMapper;
import com.meetme.meetme.model.EventDTO;
import com.meetme.meetme.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Override
    public EventDTO saveNewEvent(EventDTO eventDTO) {
        return eventMapper.eventToEventDto(eventRepository.save(eventMapper.eventDtoToEvent(eventDTO)));
    }
}
