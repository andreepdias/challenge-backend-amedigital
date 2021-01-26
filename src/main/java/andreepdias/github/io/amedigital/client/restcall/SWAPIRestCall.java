package andreepdias.github.io.amedigital.client.restcall;

import andreepdias.github.io.amedigital.client.dto.PlanetSWAPIDTO;
import andreepdias.github.io.amedigital.client.dto.PlanetsPageSWAPIResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class SWAPIRestCall {

    private final String baseURL = "https://swapi.dev/api";

    public Integer getPlanetMoviesCount(String planetName){
        String planetsPageURL = baseURL + "/planets/?page=";
        String nextURL = planetsPageURL + "1";

        do{
            PlanetsPageSWAPIResponseDTO planetApiResponseDTO = getPlanetsPage(nextURL);

            for (PlanetSWAPIDTO planetDTO : planetApiResponseDTO.getResults()) {
                if(planetDTO.getName().equalsIgnoreCase(planetName)){
                    return planetDTO.getFilms().size();
                }
            }

            nextURL = planetApiResponseDTO.getNext();
            nextURL = fixURLHttpsPrefix(nextURL, planetsPageURL);
        }while (nextURL != null);

        return 0;
    }

    private String fixURLHttpsPrefix(String nextURL, String planetsPageURL) {
        if(nextURL == null) return null;

        Integer indexEquals = nextURL.indexOf('=');
        String nextPageNumber = nextURL.substring(indexEquals + 1);
        return planetsPageURL + nextPageNumber;
    }

    private PlanetsPageSWAPIResponseDTO getPlanetsPage(String nextURL) {
        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<PlanetsPageSWAPIResponseDTO> response = restTemplate.getForEntity(nextURL, PlanetsPageSWAPIResponseDTO.class);
            PlanetsPageSWAPIResponseDTO planetsPageAPIResponseDTO = response.getBody();

            return planetsPageAPIResponseDTO;
        }catch (HttpClientErrorException ex){
            return new PlanetsPageSWAPIResponseDTO(null );
        }
    }
}
