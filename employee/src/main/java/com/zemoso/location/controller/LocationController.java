package com.zemoso.location.controller;

import com.zemoso.location.model.Location;
import com.zemoso.location.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @RequestMapping(method= RequestMethod.GET, value="/locations")
    @ResponseBody
    public ResponseEntity<Map> getAllLocations(){
        List<Location> locations = locationService.getAllLocations();
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("locations", locations);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
