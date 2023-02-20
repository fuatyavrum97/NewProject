package com.project.earthquake.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.fasterxml.jackson.core.JsonFactory.Feature;
import com.project.earthquake.entity.Earthquake;

@Service
public class EarthquakeService {

    private final RestTemplate restTemplate;
    List <Earthquake> asd = new ArrayList<Earthquake>();

    @Autowired
    public EarthquakeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Earthquake> getEarthquakes(String country, int days) {
        String url = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson" +
                "&starttime=" + getStartDate(days) +
                "&endtime=" + getEndDate() +
                "&minmagnitude=1" +
                "&orderby=time" +
                "&limit=50" +
                "&country=" + country;

        Earthquake earthquakeData = restTemplate.getForObject(url, Earthquake.class);

        if (earthquakeData == null || earthquakeData.getProperties() == null || earthquakeData.getProperties() == null) {
           // asd.add("Earthquake not found");
        	return asd;
        }

        List<Earthquake> earthquakes = new ArrayList<>();

        for (Properties feature : earthquakeData.getProperties()) {
            Properties properties = feature.getProperties();
            earthquakes.add(new Earthquake(
                    country,
                    properties.getPlace(),
                    properties.getMag(),
                    properties.getTime()
            ));
        }

        return earthquakes;
    }

    private String getStartDate(int days) {
        LocalDate endDate = LocalDate.now().minusDays(1);
        LocalDate startDate = endDate.minusDays(days);
        return startDate.toString();
    }

    private String getEndDate() {
        return LocalDate.now().toString();
    }
}
