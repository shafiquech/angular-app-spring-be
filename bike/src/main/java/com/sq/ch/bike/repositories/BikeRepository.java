package com.sq.ch.bike.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sq.ch.bike.models.Bike;

public interface BikeRepository extends JpaRepository<Bike, Long> {

}
