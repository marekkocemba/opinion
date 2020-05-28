package pl.opinion.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.opinion.model.Opinion;
import pl.opinion.repository.OpinionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OpinionService {

    private final OpinionRepository opinionRepository;
    public List<Opinion> getOpinions(String query) {
        return opinionRepository.findAll();
    }
}
