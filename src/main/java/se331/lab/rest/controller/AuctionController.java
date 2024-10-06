package se331.lab.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.lab.rest.entity.Auction;
import se331.lab.rest.service.interfaces.AuctionService;
import se331.lab.rest.util.LabMapper;

@Controller
@RequiredArgsConstructor
public class AuctionController {
    final AuctionService auctionService;

    @GetMapping("/auctions")
    public ResponseEntity<?> getAuctionLists(
            @RequestParam(value = "_limit", required = false) Integer perPage,
            @RequestParam(value = "_page", required = false) Integer page,
            @RequestParam(value = "title", required = false) String title) {

        perPage = perPage == null ? 1 : perPage;
        page = page == null ? 1 : page;

        Page<Auction> pageOutput;
        if (title == null) {
            pageOutput = auctionService.getAllAuctions(perPage, page);
        } else {
            pageOutput = auctionService.getAuctionsByTitle(title, PageRequest.of(page - 1, perPage));
        }

        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("X-Total-Count", String.valueOf(pageOutput.getTotalElements()));

        return new ResponseEntity<>(LabMapper.INSTANCE.getAuctionDTO(pageOutput.getContent()), responseHeader, HttpStatus.OK);
    }

    @GetMapping("/auctions/{id}")
    public ResponseEntity<?> getAuction(@PathVariable("id") Long id) {
        Auction output = auctionService.getAuctionById(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getAuctionDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given auction id is not found");
        }
    }
}
