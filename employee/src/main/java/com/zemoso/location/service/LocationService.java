package com.zemoso.location.service;

import com.zemoso.location.model.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationService {
    public List<Location> getAllLocations();
}
