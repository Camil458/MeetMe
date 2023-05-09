package com.meetme.meetme.service;

import com.meetme.meetme.mapper.EventMapper;
import com.meetme.meetme.model.EventDto;
import com.meetme.meetme.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    private final UserService userService;

    @Override
    public Optional<EventDto> getEventById(Long id) {
        return Optional.ofNullable(eventMapper.eventToEventDto(eventRepository.findById(id).orElse(null)));
    }

    @Override
    public List<EventDto> getEvents() {
        return eventRepository.findAll().stream().map(eventMapper::eventToEventDto).collect(Collectors.toList());
    }

    @Override
    public EventDto saveNewEvent(EventDto eventDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        eventDto.setUser(userService.getByUsername(authentication.getName()));
        return eventMapper.eventToEventDto(eventRepository.save(eventMapper.eventDtoToEvent(eventDto)));
    }

    @Override
    public Boolean deleteById(Long id) {
        if(eventRepository.existsById(id)){
            eventRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
