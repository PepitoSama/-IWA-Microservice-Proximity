package polytech.ADCE.IWAMicroserviceProximity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

    private long distanceMax;

    private long tempsMax;

    @Autowired
    private Environment environment;

    // POST
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean create(@RequestBody final LocationModel location) {
        // Get max values
        this.distanceMax = Long.parseLong(environment.getProperty("app.distanceMax"));
        this.tempsMax = Long.parseLong(environment.getProperty("app.tempsMax"));

        List<LocationModel> locations = locationRepository.findAll();
        boolean coroned = false;
        for(LocationModel loc : locations) {
            System.out.println(location.toString());
            long differenceTemps = Math.abs(location.getGeolocation_timestamp().getTime() - loc.getGeolocation_timestamp().getTime());
            if(differenceTemps <= tempsMax) {
                double distanceMeter = DistanceCalculator.distance(location.getLatitude(), location.getLongitude(), loc.getLatitude(), loc.getLongitude(), "K")*1000;
                if(distanceMeter <= distanceMax)
                    if(!location.getUsername().equals(loc.getUsername()))
                        coroned = true;
            }
        }
        return coroned ? true : false;
    }
}