package se331.lab.rest.entity;


import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class AuctionDTO {
    Long id;
    String title;
    String description;
    String type;
    List<AuctionBidDTO> bids;
}