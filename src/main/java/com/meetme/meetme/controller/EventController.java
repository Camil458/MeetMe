package com.meetme.meetme.controller;

import com.meetme.meetme.service.GoogleSearchService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/events")
public class EventController {
    GoogleSearchService googleSearchService;

    @GetMapping
    public ResponseEntity<String> getEvents(@RequestParam("q") String query){
        // response pattern
        String json = """
                [
                    {
                        "id": "0",
                        "title": "To da Rhythm: Forest of no Return // BassBitches",
                        "date": {
                            "start_date": "May 6",
                            "when": "Sat, May 6, 10 PM – Sun, May 7, 6 AM GMT+2"
                        },
                        "address": [
                            "Komplex Schwerin, Pfaffenstraße 4",
                            "Schwerin, Germany"
                        ],
                        "link": "https://allevents.in/schwerin/to-da-rhythm-forest-of-no-return-bassbitches/200024218849620?ref=eventlist-cat",
                        "event_location_map": {
                            "image": "https://www.google.com/maps/vt/data=WV_qPps_2UO-XHvsAKh2XZHrShkc4T75AyU4ziwbmKbupLIAYx_WyB14tAPXLAnk_jI7G_4_d9Alm2NyHsq436xEGhrbvuDflSW3eWAigJdD-a-V2Wc",
                            "link": "https://www.google.com/maps/place//data=!4m2!3m1!1s0x47adda1c25281e63:0xf420e422a26178cb?sa=X&hl=en",
                            "serpapi_link": "https://serpapi.com/search.json?data=%214m2%213m1%211s0x47adda1c25281e63%3A0xf420e422a26178cb&engine=google_maps&google_domain=google.com&hl=en&q=Events+in+Warsow&type=place"
                        },
                        "coordinates":[53.630780529251325, 11.415952299999999],
                        "description": "Get ready for an immersive and unforgettable live experience as FOREST OF NO RETURN takes the stage. This dynamic duo combines the raw energy of live drums with the power and aesthetics of a drum...",
                        "ticket_info": [
                            {
                                "source": "AllEvents.in",
                                "link": "https://allevents.in/schwerin/to-da-rhythm-forest-of-no-return-bassbitches/200024218849620?ref=eventlist-cat",
                                "link_type": "more info"
                            }
                        ],
                        "venue": {
                            "name": "Komplex Schwerin",
                            "rating": 4.1,
                            "reviews": 54,
                            "link": "https://www.google.com/search?ucbcb=1&hl=en&q=Komplex+Schwerin&ludocid=17591310981913475275&ibp=gwp%3B0,7"
                        },
                        "thumbnail": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQdDRr1iCQCtsyvbFfTBrbvMu3hLVal0VcFr58vEU6H51k7h6c5g8a0DtI&s",
                        "image": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQACmPgOzy1HdLwhsADORAGKlFkz1RQKWlxwu14gILmSg&s=10",
                        "event_type": "Music"
                    },
                    {
                        "id": "1",
                        "title": "Champagne Menü - BRINKMANNfinest Lounge Schwerin",
                        "date": {
                            "start_date": "May 4",
                            "when": "Thu, May 4, 6:30 PM GMT+2"
                        },
                        "address": [
                            "BRINKMANNfinest, TOBACCOHOUSE BRINKMANN, Mecklenburgstraße 13",
                            "Schwerin, Germany"
                        ],
                        "link": "https://www.eventim.de/en/event/champagne-menue-brinkmannfinest-lounge-schwerin-brinkmannfinest-lounge-16695473/",
                        "event_location_map": {
                            "image": "https://www.google.com/maps/vt/data=2p8BtrEoS0zRPbH542UbWMCe2palZdGqkCNREFrYIvWLYdRp7BV3A0xh-BjN95kQ-ydqpDD3TYCiK4yiaGmHkdD-9kQzN6zRuIime9lj97tnx9A01Us",
                            "link": "https://www.google.com/maps/place//data=!4m2!3m1!1s0x47adda1e319093fb:0x94321b4d9318bfb1?sa=X&hl=en",
                            "serpapi_link": "https://serpapi.com/search.json?data=%214m2%213m1%211s0x47adda1e319093fb%3A0x94321b4d9318bfb1&engine=google_maps&google_domain=google.com&hl=en&q=Events+in+Warsow&type=place"
                        },
                        "coordinates":[53.62967952782117, 11.4121092711642],
                        "ticket_info": [
                            {
                                "source": "Eventim.de",
                                "link": "https://www.eventim.de/en/event/champagne-menue-brinkmannfinest-lounge-schwerin-brinkmannfinest-lounge-16695473/",
                                "link_type": "tickets"
                            }
                        ],
                        "venue": {
                            "name": "BRINKMANNfinest",
                            "rating": 4.8,
                            "reviews": 123,
                            "link": "https://www.google.com/search?ucbcb=1&hl=en&q=BRINKMANNfinest&ludocid=10678627686443171761&ibp=gwp%3B0,7"
                        },
                        "thumbnail": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTaUXXv_LaowWyTbi4szW6H-0Bjy2DLrKpj1kdWwtU&s",
                        "image": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8Evvmki0PU4kdunn66I1qxVCD3lFlLofw8AxlrhtZTA&s",
                        "event_type": "Food"
                    }
                ]""";

        // return ResponseEntity.ok(googleSearchService.search(query));
        return ResponseEntity.ok(json);
    }
}
