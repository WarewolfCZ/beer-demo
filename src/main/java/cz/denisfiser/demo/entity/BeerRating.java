package cz.denisfiser.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class BeerRating {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    private Beer beer;
    private int rating;
    private String note;

}
