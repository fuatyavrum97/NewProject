package com.project.earthquake.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.earthquake.entity.Earthquake;
import com.project.earthquake.service.EarthquakeService;

@RestController
@RequestMapping("/earthquakes")
public class EarthquakeController {

    private final EarthquakeService earthquakeService;

    public EarthquakeController(EarthquakeService earthquakeService) {
        this.earthquakeService = earthquakeService;
    }

    @GetMapping("/{country}/{days}")
    public ResponseEntity<?> getEarthquakes(@PathVariable String country, @PathVariable int days) {
        List<Earthquake> earthquakes = earthquakeService.getEarthquakes(country, days);

        if (earthquakes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No earthquakes were recorded in the past " + days + " days.");
        } else {
            return ResponseEntity.ok(earthquakes);
        }
    }
}