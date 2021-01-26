package andreepdias.github.io.amedigital.client.dto;

import andreepdias.github.io.amedigital.domain.Planet;

import java.util.ArrayList;
import java.util.List;

public class PlanetsPageSWAPIResponseDTO {

    private String next;
    private List<PlanetSWAPIDTO> results = new ArrayList<>();

    public PlanetsPageSWAPIResponseDTO() {}

    public PlanetsPageSWAPIResponseDTO(String next, List<PlanetSWAPIDTO> results) {
        this.results = results;
    }

    public PlanetsPageSWAPIResponseDTO(String next){
        this.next = next;
    }

    public List<PlanetSWAPIDTO> getResults() {
        return results;
    }

    public String getNext() {
        return next;
    }
}