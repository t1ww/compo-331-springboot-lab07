package se331.lab.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.AuctionItem;
import se331.lab.rest.entity.Event;
import se331.lab.rest.repository.AuctionItemRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AuctionItemDaoImpl implements AuctionItemDao {
    final AuctionItemRepository auctionItemRepository;

    @Override
    public Page<AuctionItem> getAuctionItem(String name, Pageable pageRequest) {
        return auctionItemRepository.findAll(pageRequest);
    }

    @Override
    public Page<AuctionItem> getAuctions(Integer pageSize, Integer page) {
        return auctionItemRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Page<AuctionItem> findByNameAndDescription(String name, String description, Pageable page) {
        return auctionItemRepository.findByNameIgnoreCaseContainingOrDescriptionIgnoreCaseContaining(name, description, page);
    }

    @Override
    public Page<AuctionItem> getAuctions(String title, Pageable page) {
        return auctionItemRepository.findByNameIgnoreCaseContainingOrDescriptionIgnoreCaseContaining(title, title, page);
    }

    @Override
    public AuctionItem getAuctionById(Long id) {
        return auctionItemRepository.findById(id).orElse(null);
    }
}