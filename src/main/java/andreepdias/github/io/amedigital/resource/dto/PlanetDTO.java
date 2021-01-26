package andreepdias.github.io.amedigital.resource.dto;

import andreepdias.github.io.amedigital.domain.Planet;

public class PlanetDTO {

    private Long id;
    private String name;
    private String climate;
    private String terrain;
    private Integer moviesCount;

    public PlanetDTO(Long id, String name, String climate, String terrain, Integer moviesCount) {
        this.id = id;
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
        this.moviesCount = moviesCount;
    }

    public static PlanetDTO toDTO(Planet planet) {
        return new PlanetDTO(planet.getId(), planet.getName(), planet.getClimate(), planet.getTerrain(), planet.getMoviesCount());
    }

    public Planet toEntity() {
        return new Planet(this.name, this.climate, this.terrain);
    }

    public Long getId() {
        return id;
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

    public Integer getMoviesCount() {
        return moviesCount;
    }
}
