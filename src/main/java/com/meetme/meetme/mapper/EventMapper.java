package com.meetme.meetme.mapper;

import com.meetme.meetme.entity.Event;
import com.meetme.meetme.model.EventDto;
import org.mapstruct.Mapper;

@Mapper
public interface EventMapper {
    Event eventDtoToEvent(EventDto eventDto);
    EventDto eventToEventDto(Event event);
}
