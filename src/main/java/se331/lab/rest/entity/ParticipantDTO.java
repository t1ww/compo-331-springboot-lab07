package se331.lab.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantDTO {
    Long id;               // Assuming you have an ID field
    String name;           // Participant's name
    String telNo;         // Participant's telephone number
    // Add any additional fields relevant to the participant
}
