package pl.opinion.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.opinion.model.Opinion;
import pl.opinion.service.OpinionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OpinionController {

    private final OpinionService opinionService;

    @GetMapping
    public List<Opinion> getOpinions(){
        return opinionService.getOpinions();
    }
}
