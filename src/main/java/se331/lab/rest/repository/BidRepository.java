package se331.lab.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab.rest.entity.Bid;

public interface BidRepository extends JpaRepository<Bid, Long> {
}