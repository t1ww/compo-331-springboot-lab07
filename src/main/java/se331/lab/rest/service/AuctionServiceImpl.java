package se331.lab.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.AuctionDao;
import se331.lab.rest.entity.Auction;

import java.util.List;

@Service
public class AuctionServiceImpl implements AuctionService {

    @Autowired
    AuctionDao auctionDao;

    @Override
    public List<Auction> getAllAuctions() {
        return auctionDao.getAllAuctions();
    }

    @Override
    public Auction getAuctionById(Long id) {
        return auctionDao.getAuctionById(id);
    }

    @Override
    public Page<Auction> getAuctionsByTitle(String title, Pageable page) {
        return auctionDao.getAuctionsByTitle(title, page);
    }

    @Override
    public Page<Auction> getAuctionsByDescription(String description, Pageable page) {
        return auctionDao.getAuctionsByDescription(description, page);
    }

    @Override
    public Page<Auction> getAuctionsByTitleOrDescription(String title, String description, Pageable page) {
        return auctionDao.getAuctionsByTitleOrDescription(title, description, page);
    }
}
