package se331.lab.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.AuctionItemDao;
import se331.lab.rest.entity.AuctionItem;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.AuctionItemRepository;

import java.util.List;
@Service

public class AuctionItemServiceImpl implements AuctionItemService {
    final AuctionItemDao auctionItemDao;

    @Override
    public Page<AuctionItem> getAuctions(Integer pageSize, Integer page) {
        return auctionItemDao.getAuctions(pageSize, page);
    }
    // Constructor to initialize auctionItemDao
    public AuctionItemServiceImpl(AuctionItemDao auctionItemDao) {
        this.auctionItemDao = auctionItemDao; // Initializing the final variable
    }

    @Override
    public Page<AuctionItem> findByNameAndDescription(String title, String description, Pageable pageable) {
        return auctionItemDao.findByNameAndDescription(title, description, pageable); // Ensure this method is defined properly in AuctionItemDao
    }

    @Override
    public Page<AuctionItem> getAuctions(String title, Pageable pageable) {
        return auctionItemDao.getAuctions(title, pageable);
    }

    @Override
    public AuctionItem getAuctionById(Long id) {
        return auctionItemDao.getAuctionById(id);
    }



}

