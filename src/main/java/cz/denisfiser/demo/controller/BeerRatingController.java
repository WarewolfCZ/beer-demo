package cz.denisfiser.demo.controller;

import cz.denisfiser.demo.RatingNotFoundException;
import cz.denisfiser.demo.entity.BeerRating;
import cz.denisfiser.demo.repository.BeerRatingRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Endpoints for beer rating
 */
@RestController
public class BeerRatingController {
    private final BeerRatingRepository repository;

    BeerRatingController(BeerRatingRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/rating")
    List<BeerRating> getRating(@RequestParam(value = "page", defaultValue = "0") int page,
                               @RequestParam(value = "size", defaultValue = "100") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable).getContent();
    }

    @GetMapping("/rating/{id}")
    BeerRating getRating(@PathVariable Long id) throws RatingNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RatingNotFoundException(id));
    }

    @PostMapping("/rating")
    BeerRating addRating(@RequestBody BeerRating beerRating) {
        return repository.save(beerRating);
    }

    @PutMapping("/rating/{id}")
    BeerRating updateRating(@RequestBody BeerRating newRating, @PathVariable Long id) {

        return repository.findById(id).map(rating -> {
                    rating.setRating(newRating.getRating());
                    rating.setNote(newRating.getNote());
                    return repository.save(rating);
                })
                .orElseGet(() -> {
                    newRating.setId(id);
                    return repository.save(newRating);
                });
    }

    @DeleteMapping("/rating/{id}")
    void deleteRating(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
