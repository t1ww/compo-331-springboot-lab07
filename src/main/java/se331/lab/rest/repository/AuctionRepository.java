package se331.lab.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab.rest.entity.Participant;

public interface AuctionRepository extends JpaRepository<Participant, Long> {
}