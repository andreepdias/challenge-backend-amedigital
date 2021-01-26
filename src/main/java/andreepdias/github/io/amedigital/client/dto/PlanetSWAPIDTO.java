package andreepdias.github.io.amedigital.client.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

public class PlanetSWAPIDTO {

    private String name;
    private String climate;
    private String terrain;
    private List<String> films;

    public PlanetSWAPIDTO() {
    }

    public PlanetSWAPIDTO(String name, String climate, String terrain, List<String> films) {
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
        this.films = films;
    }

    public String getName() {
        return name;
    }

    public String getClimate() {
        return climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public List<String> getFilms() {
        return films;
    }
}
