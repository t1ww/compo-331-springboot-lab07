package se331.lab.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.AuctionItem;

import java.util.List;

@Repository
public interface AuctionItemRepository extends JpaRepository<AuctionItem, Long> {
    Page<AuctionItem> findByNameIgnoreCaseContainingOrDescriptionIgnoreCaseContaining(String name, String description, Pageable pageable);

}
