package se331.lab.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.rest.entity.Auction;

import java.util.List;

public interface AuctionService {
    List<Auction> getAllAuctions();
    Auction getAuctionById(Long id);
    Page<Auction> getAuctionsByTitle(String title, Pageable page);
    Page<Auction> getAuctionsByDescription(String description, Pageable page);
    Page<Auction> getAuctionsByTitleOrDescription(String title, String description, Pageable page);
}
