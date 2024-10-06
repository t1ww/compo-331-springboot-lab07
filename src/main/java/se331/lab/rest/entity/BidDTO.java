package se331.lab.rest.entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BidDTO {
    Long id;
    String amount;
    String dateTime;
    BidToAuctionDTO auction;
}