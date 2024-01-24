package cz.denisfiser.demo.service;

import cz.denisfiser.demo.entity.Beer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class BeerConsumerServiceImpl implements BeerConsumerService {
    private static final Logger log = LoggerFactory.getLogger(BeerConsumerServiceImpl.class);
    private static final String BASE_URL = "https://random-data-api.com/api/v2/beers?size=100";

    private final RestTemplate restTemplate;

    public BeerConsumerServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Beer> loadRemoteBeers() {
        ResponseEntity<List<Beer>> responseEntity = restTemplate.exchange(BASE_URL, HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
                });
        List<Beer> beers = responseEntity.getBody();
        if (beers != null) {
            log.info(beers.size() +  " remote beers loaded");
            return new ArrayList<>(beers);
        } else {
            log.warn("No remote beers loaded");
            return new ArrayList<>();
        }
    }
}
