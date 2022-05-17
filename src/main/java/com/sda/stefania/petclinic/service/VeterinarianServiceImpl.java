package com.sda.stefania.petclinic.service;

import com.sda.stefania.petclinic.model.Veterinarian;
import com.sda.stefania.petclinic.repository.VeterinarianRepository;
import com.sda.stefania.petclinic.repository.VeterinarianRepositoryImpl;
import com.sda.stefania.petclinic.service.exception.InvalidParameterException;

public class VeterinarianServiceImpl implements VeterinarianService {
    private final VeterinarianRepository veterinarianRepository;

    public VeterinarianServiceImpl() {
        this.veterinarianRepository = new VeterinarianRepositoryImpl();
    }

    @Override
    public void create(String firstName, String lastName, String address, String speciality) throws InvalidParameterException {
        if (firstName == null || firstName.isBlank()) {
            throw new InvalidParameterException("The first name is null or empty.");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new InvalidParameterException("The last name is null or empty.");
        }
        if (address == null || address.isBlank()) {
            throw new InvalidParameterException("The address is null or empty.");
        }
        if (speciality == null || speciality.isBlank()) {
            throw new InvalidParameterException("The speciality is null or empty.");
        }

        veterinarianRepository.create(new Veterinarian(firstName, lastName, address, speciality));
    }
}