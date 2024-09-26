package se331.lab.rest.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.EventDTO;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.OrganizerDTO;
import se331.lab.rest.entity.Participant;       // Import Participant
import se331.lab.rest.entity.ParticipantDTO;    // Import ParticipantDTO

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);

    EventDTO getEventDTO(Event event);
    List<EventDTO> getEventDTO(List<Event> events);

    OrganizerDTO getOrganizerDTO(Organizer organizer);
    List<OrganizerDTO> getOrganizerDTO(List<Organizer> organizers);

    ParticipantDTO toParticipantDTO(Participant participant);  // Mapping for Participant
    List<ParticipantDTO> toParticipantDTOs(List<Participant> participants);  // List mapping
}
