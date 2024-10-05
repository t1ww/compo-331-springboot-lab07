package se331.lab.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.rest.entity.AuctionItem;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Participant;

import java.util.Optional;

public interface AuctionItemDao {
    Page<AuctionItem> getAuctions(Integer pageSize, Integer page);
    Page<AuctionItem> getAuctionItem(String name,Pageable pageRequest);
    Page<AuctionItem> findByNameAndDescription(String name, String description, Pageable page);
    Page<AuctionItem> getAuctions(String name, Pageable page);
    AuctionItem getAuctionById(Long id);
}