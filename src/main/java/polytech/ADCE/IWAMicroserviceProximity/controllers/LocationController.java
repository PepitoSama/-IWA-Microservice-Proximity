package polytech.ADCE.IWAMicroserviceProximity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import polytech.ADCE.IWAMicroserviceProximity.models.LocationModel;
import polytech.ADCE.IWAMicroserviceProximity.repositories.LocationRepository;
import polytech.ADCE.IWAMicroserviceProximity.services.DistanceCalculator;

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
    public boolean create(@RequestBody final LocationModel location) {
        System.out.println(location);
        List<LocationModel> locations = locationRepository.findAll();
        boolean coroned = false;
        for(LocationModel loc : locations) {
            if(Math.abs(location.getGeolocation_timestamp().getTime() - loc.getGeolocation_timestamp().getTime()) <= 1000) {
                System.out.println(loc);
                double distanceMeter = DistanceCalculator.distance(location.getLatitude(), location.getLongitude(), loc.getLatitude(), loc.getLongitude(), "K")*1000;
                if(distanceMeter <= 2) {
                    coroned = true;
                }
            }
        }
        return coroned ? true : false;
    }
}