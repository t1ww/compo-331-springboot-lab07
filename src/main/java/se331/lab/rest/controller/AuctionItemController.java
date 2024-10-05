package se331.lab.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.lab.rest.entity.AuctionItem;
import se331.lab.rest.entity.AuctionItemDTO; // Import the AuctionItemDTO
import se331.lab.rest.entity.Event;
import se331.lab.rest.service.AuctionItemService;
import se331.lab.rest.util.LabMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AuctionItemController {

    final AuctionItemService auctionItemService; // Use a service for business logic

    @GetMapping("auctions")
    public ResponseEntity<?> getAllAuctionItems(
            @RequestParam(value = "_limit", required = false) Integer perPage,
            @RequestParam(value = "_page", required = false) Integer page,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "description", required = false) String description) {
        perPage = perPage == null ? 1 : perPage;
        page = page == null ? 1 : page;

        Page<AuctionItem> auctionItems;
        if (name == null) {
            auctionItems = auctionItemService.getAuctions(perPage, page);
        } else {
            auctionItems = auctionItemService.getAuctions(name, PageRequest.of(page-1, perPage));
        }

        System.out.println("AuctionItems: " + auctionItems.getContent());  // Log to verify the data

        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("X-Total-Count", String.valueOf(auctionItems.getTotalElements()));

        return new ResponseEntity<>(LabMapper.INSTANCE.getAuctionItemDTO(auctionItems.getContent()), responseHeader, HttpStatus.OK);
    }

    @GetMapping("auctions/{id}")
    public ResponseEntity<?> getAuctions(@PathVariable("id") Long id) {
        // Fetching a single event by id using the service
        AuctionItem output = auctionItemService.getAuctionById(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getAuctionItemDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }



}
