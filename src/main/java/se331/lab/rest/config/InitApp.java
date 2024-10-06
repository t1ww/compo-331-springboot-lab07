package se331.lab.rest.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.*;
import se331.lab.rest.repository.AuctionItemRepository;
import se331.lab.rest.repository.EventRepository;
import se331.lab.rest.repository.OrganizerRepository;
import se331.lab.rest.repository.ParticipantRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;
    final ParticipantRepository participantRepository;
    final AuctionItemRepository auctionItemRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) {
        // organizer
        Organizer org1, org2, org3;
        org1 = organizerRepository.save(Organizer.builder().name("CAMT").build());
        org2 = organizerRepository.save(Organizer.builder().name("CMU").build());
        org3 = organizerRepository.save(Organizer.builder().name("Chiang Mai").build());

        // Participants
        Participant p1 = participantRepository.save(
                Participant.builder()
                        .name("Alice Johnson")
                        .telNo("123-456-7890")
                        .build()
        );

        Participant p2 = participantRepository.save(
                Participant.builder()
                        .name("Bob Smith")
                        .telNo("098-765-4321")
                        .build()
        );

        Participant p3 = participantRepository.save(
                Participant.builder()
                        .name("Carol White")
                        .telNo("555-123-4567")
                        .build()
        );

        Participant p4 = participantRepository.save(
                Participant.builder()
                        .name("David Green")
                        .telNo("111-222-3333")
                        .build()
        );

        Participant p5 = participantRepository.save(
                Participant.builder()
                        .name("Eve Black")
                        .telNo("222-333-4444")
                        .build()
        );

        // events
        Event tempEvent;

        // Event 1: Midterm Exam
        tempEvent = eventRepository.save(
                Event.builder()
                        .category("Academic")
                        .title("Midterm Exam")
                        .description("A time for taking exam")
                        .location("CAMT building")
                        .date("3rd Sept")
                        .time("3.00-4.00pm.")
                        .petsAllowed(false)
                        .build()
        );
        // Assign participants to the event
        tempEvent.setParticipants(List.of(p1, p2, p3));
        p1.getEventHistory().add(tempEvent);
        p2.getEventHistory().add(tempEvent);
        p3.getEventHistory().add(tempEvent);
        // Assign organizer
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);

        // Event 2: Commencement Day
        tempEvent = eventRepository.save(
                Event.builder()
                        .category("Academic")
                        .title("Commencement Day")
                        .description("A time for celebration")
                        .location("CMU Convention hall")
                        .date("21st Jan")
                        .time("3.00-4.00pm.")
                        .petsAllowed(false)
                        .build()
        );
        // Assign participants to the event
        tempEvent.setParticipants(List.of(p2, p4, p5));
        p2.getEventHistory().add(tempEvent);
        p4.getEventHistory().add(tempEvent);
        p5.getEventHistory().add(tempEvent);
        // Assign organizer
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);

        // Event 3: Loy Krathong
        tempEvent = eventRepository.save(
                Event.builder()
                        .category("Cultural")
                        .title("Loy Krathong")
                        .description("A time for Krathong")
                        .location("Ping River")
                        .date("21st Nov")
                        .time("8.00-10.00pm.")
                        .petsAllowed(false)
                        .build()
        );
        // Assign participants to the event
        tempEvent.setParticipants(List.of(p1, p3, p5));
        p1.getEventHistory().add(tempEvent);
        p3.getEventHistory().add(tempEvent);
        p5.getEventHistory().add(tempEvent);
        // Assign organizer
        tempEvent.setOrganizer(org2);
        org2.getOwnEvents().add(tempEvent);

        // Event 4: Songkran
        tempEvent = eventRepository.save(
                Event.builder()
                        .category("Cultural")
                        .title("Songkran")
                        .description("Let's play water")
                        .location("Chiang Mai Moat")
                        .date("13th April")
                        .time("10.00am-6.00pm.")
                        .petsAllowed(true)
                        .build()
        );
        // Assign participants to the event
        tempEvent.setParticipants(List.of(p3, p4, p5));
        p3.getEventHistory().add(tempEvent);
        p4.getEventHistory().add(tempEvent);
        p5.getEventHistory().add(tempEvent);
        // Assign organizer
        tempEvent.setOrganizer(org3);
        org3.getOwnEvents().add(tempEvent);
        //

        // AUCTIONS
        AuctionItem item1 = new AuctionItem();
        item1.setName("Vintage Vase");
        item1.setDescription("A beautiful vintage vase from the 19th century.");

        AuctionItem item2 = new AuctionItem();
        item2.setName("Antique Clock");
        item2.setDescription("An exquisite antique clock with intricate designs.");

        AuctionItem item3 = new AuctionItem();
        item3.setName("Painting by Van Gogh");
        item3.setDescription("An original painting by Vincent van Gogh.");

        AuctionItem item4 = new AuctionItem();
        item4.setName("Sculpture of a Lion");
        item4.setDescription("A stunning sculpture carved from marble.");

        AuctionItem item5 = new AuctionItem();
        item5.setName("Collectible Coins");
        item5.setDescription("A collection of rare coins from around the world.");

        // Creating Bids for each Auction Item
        Bid bid1 = new Bid();
        bid1.setBidAmount(150.0);
        bid1.setSuccessful(true);
        bid1.setAuctionItem(item1);

        Bid bid2 = new Bid();
        bid2.setBidAmount(160.0);
        bid2.setSuccessful(false);
        bid2.setAuctionItem(item1);

        Bid bid3 = new Bid();
        bid3.setBidAmount(170.0);
        bid3.setSuccessful(true);
        bid3.setAuctionItem(item2);

        Bid bid4 = new Bid();
        bid4.setBidAmount(220.0);
        bid4.setSuccessful(true);
        bid4.setAuctionItem(item3);

        Bid bid5 = new Bid();
        bid5.setBidAmount(200.0);
        bid5.setSuccessful(false);
        bid5.setAuctionItem(item3);

        Bid bid6 = new Bid();
        bid6.setBidAmount(180.0);
        bid6.setSuccessful(true);
        bid6.setAuctionItem(item4);

        // Adding bids to auction items
        item1.setBids(new ArrayList<>(List.of(bid1, bid2)));
        item2.setBids(new ArrayList<>(List.of(bid3)));
        item3.setBids(new ArrayList<>(List.of(bid4, bid5)));
        item4.setBids(new ArrayList<>(List.of(bid6)));
        item5.setBids(new ArrayList<>()); // No bids for item5

        // Marking successfulBid based on bids
        item1.setSuccessfulBid(item1.getBids().stream().anyMatch(Bid::isSuccessful));
        item2.setSuccessfulBid(item2.getBids().stream().anyMatch(Bid::isSuccessful));
        item3.setSuccessfulBid(item3.getBids().stream().anyMatch(Bid::isSuccessful));
        item4.setSuccessfulBid(item4.getBids().stream().anyMatch(Bid::isSuccessful));
        item5.setSuccessfulBid(item5.getBids().stream().anyMatch(Bid::isSuccessful));

        // Saving auction items
        auctionItemRepository.saveAll(List.of(item1, item2, item3, item4, item5));
    }



}