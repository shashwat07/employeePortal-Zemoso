package com.zemoso.location.service;

import com.zemoso.location.model.Location;
import com.zemoso.location.repo.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService{
    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getAllLocations(){
        return (List<Location>)locationRepository.findAll();
    }
}
