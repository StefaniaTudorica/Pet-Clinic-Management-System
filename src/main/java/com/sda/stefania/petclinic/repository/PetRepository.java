package com.sda.stefania.petclinic.repository;

import com.sda.stefania.petclinic.model.Pet;
import com.sda.stefania.petclinic.repository.base.BaseRepository;

import java.util.List;

public interface PetRepository extends BaseRepository<Pet, Long> {

     List<Pet> findAllVaccinated();
}
