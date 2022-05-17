package com.sda.stefania.petclinic.repository;

import com.sda.stefania.petclinic.model.Veterinarian;
import com.sda.stefania.petclinic.repository.base.BaseRepositoryImpl;

public class VeterinarianRepositoryImpl extends BaseRepositoryImpl<Veterinarian, Long> implements VeterinarianRepository {
    public VeterinarianRepositoryImpl() {
        super(Veterinarian.class);
    }
}

