package polytech.ADCE.IWAMicroserviceProximity.controllers;

import polytech.ADCE.IWAMicroserviceProximity.models.LocationModel;
import polytech.ADCE.IWAMicroserviceProximity.repositories.LocationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository ;

    // Get ALL
    @GetMapping
    public List<LocationModel> list() {
        return locationRepository.findAll();
    }

    // POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LocationModel create(@RequestBody final LocationModel location) {
        System.out.println("Received location : " + location.toString());
        return null;
    }
}