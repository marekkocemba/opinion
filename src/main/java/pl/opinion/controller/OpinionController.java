package pl.opinion.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.opinion.model.Opinion;
import pl.opinion.service.OpinionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OpinionController {

    private final OpinionService opinionService;

    @GetMapping("/opinions")
    public List<Opinion> getOpinions(@RequestParam String company){
        return opinionService.getOpinions(company);
    }

    @GetMapping("/opinions/{id}")
    public Opinion getOpinionById(@PathVariable Long id){
        return opinionService.getOpinionById(id);
    }
}
