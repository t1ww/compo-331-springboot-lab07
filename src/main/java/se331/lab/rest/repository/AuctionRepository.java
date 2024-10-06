package se331.lab.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab.rest.entity.Auction;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
    Page<Auction> findByTitleContainingIgnoreCase(String title, Pageable page);
    Page<Auction> findByDescriptionContainingIgnoreCase(String description, Pageable page);
    Page<Auction> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String title, String description, Pageable page);
}
