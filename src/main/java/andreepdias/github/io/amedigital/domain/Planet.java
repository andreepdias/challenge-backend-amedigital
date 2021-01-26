package andreepdias.github.io.amedigital.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String climate;
    private String terrain;
    private Integer moviesCount;

    public Planet() {
    }

    public Planet(String name, String climate, String terrain) {
        this.id = null;
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
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

    public void setMoviesCount(Integer moviesCount) {
        this.moviesCount = moviesCount;
    }
}
