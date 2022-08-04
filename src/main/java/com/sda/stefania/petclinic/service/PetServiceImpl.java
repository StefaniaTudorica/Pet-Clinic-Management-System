package com.sda.stefania.petclinic.service;

import com.sda.stefania.petclinic.model.Client;
import com.sda.stefania.petclinic.model.Pet;
import com.sda.stefania.petclinic.repository.ClientRepository;
import com.sda.stefania.petclinic.repository.ClientRepositoryImpl;
import com.sda.stefania.petclinic.repository.PetRepository;
import com.sda.stefania.petclinic.repository.PetRepositoryImpl;
import com.sda.stefania.petclinic.service.PetService;
import com.sda.stefania.petclinic.service.exception.InvalidParameterException;
import org.hibernate.dialect.lock.OptimisticEntityLockException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final ClientRepository clientRepository;


    public PetServiceImpl() {
        this.petRepository = new PetRepositoryImpl();
        this.clientRepository = new ClientRepositoryImpl();
    }

    @Override
    public void create(String race, Date birthDate, boolean isVaccinated, String ownerFirstName, String ownerLastName) throws InvalidParameterException {
        if (race==null || race.isBlank()){
          throw new InvalidParameterException("The race is null or blank");
        }
        if (birthDate==null){
            throw new InvalidParameterException("The birthdate is null.");
        }
        if (birthDate.after(new Date())){
            throw new InvalidParameterException("The birthdate is in the future.");
        }
        if (ownerFirstName==null || ownerFirstName.isBlank()){
            throw new InvalidParameterException("The owner's first name is null or blank.");
        }
        if (ownerLastName==null || ownerLastName.isBlank()){
            throw new InvalidParameterException("The owner's last name is null or blank.");
        }


       Optional<Client> clientResult =  clientRepository.findByFirstNameAndLastName(ownerFirstName, ownerLastName);
        if (clientResult.isEmpty()){
            Client client = new Client(ownerFirstName, ownerLastName, null, null);
            clientRepository.create(client);
            clientResult = Optional.of(client);
        }

        Pet pet = new Pet(race, birthDate, isVaccinated);
        pet.setOwner(clientResult.get());
        petRepository.create(pet);
    }

    @Override
    public List<Pet> findAllVaccinated() {
        return petRepository.findAllVaccinated();
    }

}
