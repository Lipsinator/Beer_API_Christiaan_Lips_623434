package nl.inholland.myfirstapi.controller;

import nl.inholland.myfirstapi.model.Beer;
import nl.inholland.myfirstapi.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

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
}
