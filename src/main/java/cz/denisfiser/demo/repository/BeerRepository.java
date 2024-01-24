package cz.denisfiser.demo.repository;

import cz.denisfiser.demo.entity.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BeerRepository extends JpaRepository<Beer, Integer> {
}
