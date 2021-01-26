package andreepdias.github.io.amedigital.repository;

import andreepdias.github.io.amedigital.domain.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {

    List<Planet> findByNameContainingIgnoreCase(String name);
}
