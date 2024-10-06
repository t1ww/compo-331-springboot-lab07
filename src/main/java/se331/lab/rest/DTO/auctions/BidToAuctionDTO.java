package se331.lab.rest.DTO.auctions;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BidToAuctionDTO {
    Long id;
    String title;
    String description;
    String type;
}