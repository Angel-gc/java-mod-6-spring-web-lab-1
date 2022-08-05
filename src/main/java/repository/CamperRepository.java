package repository;

import Model.Camper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CamperRepository extends JpaRepository<Camper, Long> {
    Camper findByName(String name);
    void deleteByName(String name);
}
