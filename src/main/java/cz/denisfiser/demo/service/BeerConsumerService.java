package cz.denisfiser.demo.service;

import cz.denisfiser.demo.entity.Beer;

import java.util.List;

public interface BeerConsumerService {
    List<Beer> loadRemoteBeers();
}
