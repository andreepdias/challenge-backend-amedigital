package andreepdias.github.io.amedigital.service;

import andreepdias.github.io.amedigital.client.restcall.SWAPIRestCall;
import andreepdias.github.io.amedigital.domain.Planet;
import andreepdias.github.io.amedigital.repository.PlanetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetService {

    private final PlanetRepository repository;
    private final SWAPIRestCall restCall;

    public PlanetService(PlanetRepository repository, SWAPIRestCall restCall) {
        this.repository = repository;
        this.restCall = restCall;
    }

    public List<Planet> findAll(){
        return repository.findAll();
    }

    public Planet findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Planet with id " + id + " was not found."));
    }

    public List<Planet> findAllByName(String name){
        return repository.findByNameContainingIgnoreCase(name);
    }

    public void deleteById(Long id){
        boolean existsById = repository.existsById(id);
        if(!existsById){
            throw new IllegalArgumentException("Planet with id " + id + " was not found.");
        }
        repository.deleteById(id);
    }

    public Planet create(Planet planet) {
        Integer planetMoviesCount = restCall.getPlanetMoviesCount(planet.getName());
        planet.setMoviesCount(planetMoviesCount);
        return repository.save(planet);
    }

}
