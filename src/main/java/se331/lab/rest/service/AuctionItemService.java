package se331.lab.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.lab.rest.entity.AuctionItem;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.AuctionItemRepository;

import java.util.List;


public interface AuctionItemService {

    Page<AuctionItem> findByNameAndDescription(String name, String description, Pageable page);
    Page<AuctionItem> getAuctions(String name, Pageable pageable);
    Page<AuctionItem> getAuctions(Integer pageSize, Integer page);
    AuctionItem getAuctionById(Long id);


}
