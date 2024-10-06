package se331.lab.rest.entity;

import jakarta.persistence.*;
import lombok.*;
import se331.lab.rest.entity.Organizer;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String amount;
    String dateTime;
    @ManyToOne
    Auction auction;
}