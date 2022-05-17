package com.sda.stefania.petclinic.service;

import com.sda.stefania.petclinic.service.exception.InvalidParameterException;

public interface VeterinarianService {

    void create(String firstName, String lastName, String address, String speciality) throws InvalidParameterException;
}
