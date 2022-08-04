package com.sda.stefania.petclinic.repository;

import com.sda.stefania.petclinic.model.Veterinarian;
import com.sda.stefania.petclinic.repository.base.BaseRepository;

import java.util.List;

public interface VeterinarianRepository extends BaseRepository<Veterinarian, Long> {

    List<Veterinarian> findByMultipleParameters(String firstName, String lastName, String address, String speciality);
}
