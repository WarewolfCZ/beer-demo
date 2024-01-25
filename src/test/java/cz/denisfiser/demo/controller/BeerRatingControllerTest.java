package cz.denisfiser.demo.controller;

import cz.denisfiser.demo.entity.BeerRating;
import cz.denisfiser.demo.repository.BeerRatingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerRatingControllerTest {

    @Autowired
    private BeerRatingController controller;

    @Autowired
    private BeerRatingRepository beerRatingRepository;

    @Test
    void getRating() {
        beerRatingRepository.deleteAll();
        BeerRating rating = new BeerRating();
        assertEquals(0, beerRatingRepository.count());
        rating.setNote("BeerRating 1");
        rating.setRating(1);
        beerRatingRepository.save(rating);

        rating = new BeerRating();
        rating.setNote("BeerRating 2");
        rating.setRating(1);
        beerRatingRepository.save(rating);

        rating = new BeerRating();
        rating.setNote("BeerRating 3");
        rating.setRating(1);
        beerRatingRepository.save(rating);

        List<BeerRating> beerRatingList = controller.getRating(0, 100);

        assertEquals(3, beerRatingList.size());
        assertEquals("BeerRating 2", beerRatingList.get(1).getNote());
    }
}