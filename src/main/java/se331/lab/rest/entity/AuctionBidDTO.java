package se331.lab.rest.entity;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AuctionBidDTO {
    Long id;
    String amount;
    String dateTime;
}