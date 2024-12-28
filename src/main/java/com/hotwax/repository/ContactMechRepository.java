package com.hotwax.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotwax.model.ContactMech;

public interface ContactMechRepository extends JpaRepository<ContactMech, Integer> {

}
