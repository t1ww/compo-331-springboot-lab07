package se331.lab.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.service.OrganizerService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrganizerController {

    final OrganizerService OrganizerService;

    @GetMapping("Organizers")
    public ResponseEntity<?> getOrganizerLists(
            @RequestParam(value = "_limit", required = false) Integer perPage,
            @RequestParam(value = "_page", required = false) Integer page) {
        if(page == null){ // temp fix, idk
            page = 1;
        }
        // set page output and response
        Page<Organizer> pageOutput = OrganizerService.getOrganizers(perPage, page);
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(pageOutput.getContent(), responseHeader, HttpStatus.OK);
    }

    @GetMapping("Organizers/{id}")
    public ResponseEntity<?> getOrganizer(@PathVariable("id") Long id) {
        // Fetching a single Organizer by id using the service
        Organizer output = OrganizerService.getOrganizerById(id);
        if (output != null) {
            return ResponseEntity.ok(output);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("/Organizers")
    public ResponseEntity<?> addOrganizer(@RequestBody Organizer Organizer) {
        Organizer output = OrganizerService.saveOrganizer(Organizer);
        return ResponseEntity.ok(output);
    }
}