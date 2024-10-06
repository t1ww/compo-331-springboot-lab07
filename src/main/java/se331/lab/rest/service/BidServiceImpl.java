package se331.lab.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.BidDao;
import se331.lab.rest.entity.Bid;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BidServiceImpl implements BidService {
    final BidDao bidDao;

    @Override
    public Page<Bid> getBids(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return bidDao.getBids(pageable);
    }

    @Override
    public Optional<Bid> getBidById(Long id) {
        return bidDao.findById(id);
    }
}
