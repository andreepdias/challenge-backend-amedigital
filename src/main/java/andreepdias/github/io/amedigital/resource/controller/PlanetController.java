package andreepdias.github.io.amedigital.resource.controller;

import andreepdias.github.io.amedigital.domain.Planet;
import andreepdias.github.io.amedigital.resource.dto.PlanetDTO;
import andreepdias.github.io.amedigital.service.PlanetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("planets")
public class PlanetController {

    private final PlanetService service;

    public PlanetController(PlanetService service) {
        this.service = service;
    }

    @PostMapping
    public PlanetDTO create(@RequestBody PlanetDTO dto){
        Planet planet = dto.toEntity();
        planet = service.create(planet);
        return PlanetDTO.toDTO(planet);
    }

    @GetMapping
    public List<PlanetDTO> getAll(){
        return service.findAll().stream()
                .map(PlanetDTO::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping(params = "name")
    public List<PlanetDTO> getAllByName(@RequestParam String name){
        return service.findAllByName(name)
                .stream()
                .map(PlanetDTO::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public PlanetDTO getById(@PathVariable Long id){
        Planet planet;
        try{
            planet = service.findById(id);
        }catch (IllegalArgumentException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
        return PlanetDTO.toDTO(planet);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        try{
            service.deleteById(id);
        }catch (IllegalArgumentException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }


}
