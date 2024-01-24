package cz.denisfiser.demo;

public class RatingNotFoundException extends Exception {
    public RatingNotFoundException(Long id) {
        super("Rating with id " + id + " not found");
    }
}
