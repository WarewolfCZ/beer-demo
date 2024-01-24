package cz.denisfiser.demo.repository;

import cz.denisfiser.demo.entity.BeerRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRatingRepository extends JpaRepository<BeerRating, Long> {
}
