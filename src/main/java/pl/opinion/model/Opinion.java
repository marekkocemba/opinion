package pl.opinion.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity(name="opinions")
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String company;
    private String city;
    @Column(name = "application_date")
    private String applicationDate;
    private String description;
}
