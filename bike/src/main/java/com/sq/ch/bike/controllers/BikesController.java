package com.sq.ch.bike.controllers;

import com.sq.ch.bike.models.Bike;
import com.sq.ch.bike.repositories.BikeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/bikes")
@RequiredArgsConstructor
public class BikesController {


  private final BikeRepository bikeRepository;
  private final OAuth2RestTemplate oAuth2RestTemplate;
  private final RestTemplate restTemplate;


  @GetMapping
  public List<Bike> list() {
    return bikeRepository.findAll();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public void create(@RequestBody Bike bike) {
    System.out.println(bike.getName());
    bikeRepository.save(bike);
  }

  @GetMapping("/{id}")
  public Bike get(@PathVariable("id") long id) {
    return bikeRepository.getOne(id);
  }

  @GetMapping("/{id}/history")
  public List<String> getBikeHistory(@PathVariable("id") String bikeId) {

    ResponseEntity<List<String>> responseEntity = oAuth2RestTemplate.exchange(
        "http://localhost:8083/v1/history/{bikeId}",
        HttpMethod.GET,
        null, new ParameterizedTypeReference<List<String>>() {
        }, bikeId);

    return responseEntity.getBody();
  }

}
