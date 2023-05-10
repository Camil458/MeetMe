package com.meetme.meetme.controller;

import com.meetme.meetme.model.EventDto;
import com.meetme.meetme.service.EventService;
import com.meetme.meetme.service.GoogleSearchService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/events")
public class EventController {
    GoogleSearchService googleSearchService;
    EventService eventService;

    @GetMapping
    public ResponseEntity<String> getEvents(@RequestParam(value = "q") String q, @RequestParam(value = "date", required = false) String date, @RequestParam(value = "priv", required = false) String priv, @RequestParam(value = "page", required = false) String page) {
        if (priv != null) {
            return ResponseEntity.ok(eventService.getEvents().toString());
        } else {
            return ResponseEntity.ok(googleSearchService.search(q, date, page));
        }
    }

    @PostMapping("/add")
    public ResponseEntity addEvent(@RequestBody EventDto eventDto){
        eventService.saveNewEvent(eventDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
