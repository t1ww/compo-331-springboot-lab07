package se331.lab.rest.service;

import org.springframework.data.domain.Page;
import se331.lab.rest.entity.Bid;

import java.util.Optional;

public interface BidService {
    Page<Bid> getBids(Integer page, Integer pageSize);
    Optional<Bid> getBidById(Long id);
}
