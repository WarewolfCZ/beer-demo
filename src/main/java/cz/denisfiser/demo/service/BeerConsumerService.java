package cz.denisfiser.demo.service;

import cz.denisfiser.demo.entity.Beer;

import java.util.List;

/**
 * Consumes Beer REST API
 */
public interface BeerConsumerService {
    /**
     * Load list of beers from API
     * @return beer list
     */
    List<Beer> loadRemoteBeers();
}
