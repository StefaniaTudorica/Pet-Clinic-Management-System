package com.sda.stefania.petclinic.repository;

import com.sda.stefania.petclinic.model.Pet;
import com.sda.stefania.petclinic.repository.base.BaseRepositoryImpl;

public class PetRepositoryImpl extends BaseRepositoryImpl<Pet, Long> implements PetRepository {
    public PetRepositoryImpl() {
        super(Pet.class);
    }
}
