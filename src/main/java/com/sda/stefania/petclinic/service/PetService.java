package com.sda.stefania.petclinic.service;

import com.sda.stefania.petclinic.service.exception.InvalidParameterException;

import java.util.Date;

public interface PetService {

    void create(String race, Date birthDate, boolean isVaccinated, String ownerFirstName, String ownerLastName)throws InvalidParameterException;
}