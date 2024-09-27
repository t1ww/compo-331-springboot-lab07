package se331.lab.rest.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.Participant;
import se331.lab.rest.repository.EventRepository;
import se331.lab.rest.repository.OrganizerRepository;
import se331.lab.rest.repository.ParticipantRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;
    final ParticipantRepository participantRepository;

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
    }
}
