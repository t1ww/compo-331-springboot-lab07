package se331.lab.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.rest.entity.Auction;

import java.util.List;

public interface AuctionDao {
    List<Auction> getAllAuctions();
    Auction getAuctionById(Long id);

    // New methods for querying by title and description
    Page<Auction> getAuctionsByTitle(String title, Pageable page);
    Page<Auction> getAuctionsByDescription(String description, Pageable page);

    // Alternatively, a combined method if you need more flexibility
    Page<Auction> getAuctionsByTitleOrDescription(String title, String description, Pageable page);
}
