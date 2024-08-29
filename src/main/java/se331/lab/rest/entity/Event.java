package se331.lab.rest.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;

@Data
@Builder
public class Event {
    Long id;
    String category;
    String title;
    String description;
    String location;
    String date;
    String time;
    Boolean petAllowed;
    String organizer;
}