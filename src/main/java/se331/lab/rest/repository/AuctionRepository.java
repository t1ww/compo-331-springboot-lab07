package se331.lab.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab.rest.entity.Auction;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
    Page<Auction> findByTitleContainingIgnoreCase(String title, Pageable pageable);
    Page<Auction> findByDescriptionContainingIgnoreCase(String description, Pageable pageable);
    Page<Auction> findByTypeContainingIgnoreCase(String type, Pageable pageable); // Add this method
    Page<Auction> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String title, String description, Pageable pageable);
    Page<Auction> findByTitleContainingIgnoreCaseOrTypeContainingIgnoreCase(String title, String type, Pageable pageable); // Add this method
}
