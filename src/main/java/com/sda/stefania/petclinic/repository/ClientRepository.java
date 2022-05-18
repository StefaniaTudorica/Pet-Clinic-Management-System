package com.sda.stefania.petclinic.repository;

import com.sda.stefania.petclinic.model.Client;
import com.sda.stefania.petclinic.repository.base.BaseRepository;

import java.util.Optional;

public interface ClientRepository extends BaseRepository<Client, Long> {

    Optional<Client> findByFirstNameAndLastName(String firstName, String lastName);
}
