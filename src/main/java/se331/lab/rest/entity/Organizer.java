package se331.lab.rest.entity;


import jakarta.persistence.*;
import lombok.*;
import se331.lab.rest.user.User;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String name;
    String image;

    @OneToMany(mappedBy = "organizer")
    @Builder.Default
    List<Event> ownEvents = new ArrayList<>();
    @OneToOne
    User user;
}
