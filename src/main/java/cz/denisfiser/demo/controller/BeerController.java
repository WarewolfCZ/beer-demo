package cz.denisfiser.demo.controller;

import cz.denisfiser.demo.entity.Beer;
import cz.denisfiser.demo.repository.BeerRepository;
import cz.denisfiser.demo.service.BeerConsumerService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Serves beers loaded from remote API.
 * The beers are loaded on the first run and then on future runs whenever the database table is empty
 */
@RestController
public class BeerController {

    private static final Logger log = LoggerFactory.getLogger(BeerController.class);

    private final BeerRepository repository;

    private final BeerConsumerService service;

    BeerController(BeerRepository repository, BeerConsumerService beerConsumerService) {
        this.repository = repository;
        this.service = beerConsumerService;
    }

    @PostConstruct
    public void init() {
        if (repository.count() == 0) {
            log.info("Loading beer data");
            List<Beer> beers = service.loadRemoteBeers();
            repository.saveAll(beers);
        }
    }

    @GetMapping("/beers")
    List<Beer> getBeers(@RequestParam(value = "page", defaultValue = "0") int page,
                   @RequestParam(value = "size", defaultValue = "100") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable).getContent();
    }
}
