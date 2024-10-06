package se331.lab.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lab.rest.dao.interfaces.AuctionDao;
import se331.lab.rest.entity.Auction;
import se331.lab.rest.repository.AuctionRepository;

import java.util.List;

@Repository
public class AuctionDaoImpl implements AuctionDao {

    @Autowired
    AuctionRepository auctionRepository;

    @Override
    public List<Auction> getAllAuctions() {
        return auctionRepository.findAll();
    }

    @Override
    public Page<Auction> getAllAuctions(Integer pageSize, Integer page) {
        return auctionRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Auction getAuctionById(Long id) {
        return auctionRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Auction> getAuctionsByTitle(String title, Pageable page) {
        return auctionRepository.findByTitleContainingIgnoreCase(title, page);
    }

    @Override
    public Page<Auction> getAuctionsByDescription(String description, Pageable page) {
        return auctionRepository.findByDescriptionContainingIgnoreCase(description, page);
    }

    @Override
    public Page<Auction> getAuctionsByType(String type, Pageable page) { // New method to filter by type
        return auctionRepository.findByTypeContainingIgnoreCase(type, page);
    }

    @Override
    public Page<Auction> getAuctionsByTitleOrDescription(String title, String description, Pageable page) {
        return auctionRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(title, description, page);
    }

    @Override
    public Page<Auction> getAuctionsByTitleOrType(String title, String type, Pageable page) { // New method to filter by title or type
        return auctionRepository.findByTitleContainingIgnoreCaseOrTypeContainingIgnoreCase(title, type, page);
    }

    @Override
    public Auction saveAuction(Auction auction) {
        return auctionRepository.save(auction);
    }
}
