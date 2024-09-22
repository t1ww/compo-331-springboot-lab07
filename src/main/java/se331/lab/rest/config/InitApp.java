package se331.lab.rest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.EventRepository;
import se331.lab.rest.repository.OrganizerRepository;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Organizer org1, org2, org3;
        org1 = organizerRepository.save(Organizer.builder().name("CAMT").build());
        org2 = organizerRepository.save(Organizer.builder().name("CMU").build());
        org3 = organizerRepository.save(Organizer.builder().name("Chiang Mai").build());
        Event tempEvent;
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
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);
        // //
        tempEvent = eventRepository.save(
                Event.builder()
                        .category("Academic")
                        .title("Commencement Day")
                        .description("A time for celebration")
                        .location("CMU Convention hall")
                        .date("21th Jan")
                        .time("3.00-4.00pm.")
                        .petsAllowed(false)
                        .build()
        );
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);
        // //
        tempEvent = eventRepository.save(
                Event.builder()
                        .category("Cultural")
                        .title("Loy Krathong")
                        .description("A time for Krathong")
                        .location("Ping River")
                        .date("21th Nov")
                        .time("8.00-10.00pm.")
                        .petsAllowed(false)
                        .build()
        );
        tempEvent.setOrganizer(org2);
        org2.getOwnEvents().add(tempEvent);
        // //
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
        tempEvent.setOrganizer(org3);
        org3.getOwnEvents().add(tempEvent);
    }
}
