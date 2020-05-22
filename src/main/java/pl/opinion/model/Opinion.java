package pl.opinion.model;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
public class Opinion {

    private final Integer id;
    private final String company;
    private final String city;
    private final LocalDate applicationDate;
    private final String description;
}
