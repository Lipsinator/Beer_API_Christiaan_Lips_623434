package nl.inholland.myfirstapi.service;

import nl.inholland.myfirstapi.model.Beer;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BeerService {

    List<Beer> beers;

    public BeerService() {
        this.beers =
                Arrays.asList(
                        new Beer(1L, "Heineken", "Pilsener", 2, 7),
                        new Beer(2L, "Bavaria", "Bock", 2.40, 4),
                        new Beer(3L, "Grimbergen", "Dubbel", 3.50, 13),
                        new Beer(4L, "Jopen - Ongelovige Thomas", "Quadrupel", 3.75, 11),
                        new Beer(5L, "Trinitas", "Tripel", 3.20, 4),
                        new Beer(6L, "Hertogjan", "Bock", 2.90, 2),
                        new Beer(7L, "IJbock", "Bock", 3.20, 4),
                        new Beer(8L, "Texels Bock", "Bock", 1.99, 9),
                        new Beer(9L, "Hoop awesome autumn", "Bock", 3.60, 16)
                );

    }

    public List<Beer> getAllBeers(){
        return beers;
    }
}
