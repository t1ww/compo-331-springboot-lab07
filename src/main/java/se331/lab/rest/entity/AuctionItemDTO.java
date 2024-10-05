package se331.lab.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuctionItemDTO {
    private Long id;
    private String name;
    private String description;
    private boolean successfulBid;
    private List<BidDTO> bids; // Include a list of BidDTOs if needed
}