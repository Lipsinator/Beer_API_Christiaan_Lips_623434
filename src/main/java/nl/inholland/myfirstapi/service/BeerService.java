package nl.inholland.myfirstapi.service;

import nl.inholland.myfirstapi.model.Beer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class BeerService {

    List<Beer> beers;

    public BeerService() {
        this.beers =
                Arrays.asList(
                        new Beer(1L, "Heineken", "Pilsener", 2, 7),
                        new Beer(2L, "Bavaria", "Bock", 4, 4),
                        new Beer(3L, "Grimbergen", "Dubbel", 3, 9),
                        new Beer(4L, "Jopen - Ongelovige Thomas", "Quadrupel", 3, 10),
                        new Beer(5L, "Trinitas", "Tripel", 2, 4),
                        new Beer(6L, "Hertogjan", "Bock", 2, 2),
                        new Beer(7L, "IJbock", "Bock", 5, 4),
                        new Beer(8L, "Texels Bock", "Bock", 4, 9),
                        new Beer(9L, "Hoop awesome autumn", "Bock", 3, 10)
                );

        Collections.sort(beers, (b1, b2) -> b1.getPrice() - b2.getPrice());
    }

    public List<Beer> getAllBeers(){
        return beers;
    }

    public List<String> getAllBrands(){
        List<String> brands = new ArrayList<>();
        for (Beer beer : this.beers) {
            brands.add(beer.getBrand().toLowerCase());
        }
        return brands;
    }

    public List<Beer> getAllSortedRatingBeers() {
        Collections.sort(beers, (b1, b2) -> b2.getRating() - b1.getRating());
        return this.beers;
    }
}
