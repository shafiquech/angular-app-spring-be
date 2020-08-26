package com.sq.ch.bike.controllers;

import com.sq.ch.bike.models.Bike;
import com.sq.ch.bike.repositories.BikeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikesController {

  @Autowired
  private BikeRepository bikeRepository;


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

}
