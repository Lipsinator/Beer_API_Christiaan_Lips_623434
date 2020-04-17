package nl.inholland.myfirstapi.controller;

import nl.inholland.myfirstapi.model.Beer;
import nl.inholland.myfirstapi.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Controller
@RequestMapping(value = "/beers")
@CrossOrigin(origins = "http://localhost:8080")
public class BeerController {

    @Autowired
    private BeerService service;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Beer>> getAllBeers(){
        return ResponseEntity.status(200).body(service.getAllBeers());
    }

    @RequestMapping(value = "/ratingFrom/{rating}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Beer>> getAllFilteredBeers(@PathVariable("rating") Integer rating){
        List<Beer> allBeers = service.getAllBeers();
        List<Beer> ratedBeers = new ArrayList<Beer>();

        for (Beer beer: allBeers) {
            if (beer.getRating() >= rating){
                ratedBeers.add(beer);
            }
        }
        return ResponseEntity.status(200).body(ratedBeers);
    }

}
