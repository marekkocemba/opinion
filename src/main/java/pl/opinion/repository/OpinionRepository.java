package pl.opinion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.opinion.model.Opinion;

import java.util.List;

@Repository
public interface OpinionRepository  extends JpaRepository<Opinion, Long> {

    List<Opinion> findByCompanyContainingIgnoreCase(String company);

}