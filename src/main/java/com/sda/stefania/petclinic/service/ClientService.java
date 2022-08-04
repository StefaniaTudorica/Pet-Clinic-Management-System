package com.sda.stefania.petclinic.service;

import com.sda.stefania.petclinic.model.Pet;

import java.util.List;

public interface ClientService {
    List<Pet> findPetsForClientID(Long id);
}
