package com.meetme.meetme.mapper;

import com.meetme.meetme.entity.Event;
import com.meetme.meetme.model.EventDTO;
import org.mapstruct.Mapper;

@Mapper
public interface EventMapper {
    Event eventDtoToEvent(EventDTO eventDTO);
    EventDTO eventToEventDto(Event event);
}
