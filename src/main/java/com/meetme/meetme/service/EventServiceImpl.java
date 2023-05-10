package com.meetme.meetme.service;

import com.meetme.meetme.mapper.EventMapper;
import com.meetme.meetme.model.EventDto;
import com.meetme.meetme.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public List<JSONObject> getEvents() {
        List<EventDto> events =  eventRepository.findAll().stream().map(eventMapper::eventToEventDto).toList();
        List<JSONObject> eventsList = new ArrayList<>();

        int i = 0;
        for (EventDto e:events){
            JSONObject event = new JSONObject();

            event.put("title", e.getTitle());

            JSONObject start_date = new JSONObject();
            start_date.put("start_date", e.getDate());
            event.put("date", start_date);

            String[] address = new String[]{e.getLocation()};
            event.put("address", address);

            event.put("link", e.getLink());

            event.put("ticket_info", e.getTicketInfo());

            event.put("description", e.getDescription());

            event.put("image", e.getPhotoLink());

            String coordinates = "["+e.getLng()+", "+e.getLng()+"]";
            event.put("coordinates", coordinates);

            event.put("id", i);
            i++;

            eventsList.add(event);
        }

        return eventsList;
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
