package com.sda.stefania.petclinic.service;

import com.sda.stefania.petclinic.model.Consult;
import com.sda.stefania.petclinic.model.Pet;
import com.sda.stefania.petclinic.model.Veterinarian;
import com.sda.stefania.petclinic.repository.*;
import com.sda.stefania.petclinic.service.exception.InvalidParameterException;
import com.sda.stefania.petclinic.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ConsultServiceImpl implements ConsultService {
    private final VeterinarianRepository veterinarianRepository;
    private final ConsultRepository consultRepository;
    private final PetRepository petRepository;


    public ConsultServiceImpl() {
        this.veterinarianRepository = new VeterinarianRepositoryImpl();
        this.consultRepository = new ConsultRepositoryImpl();
        this.petRepository = new PetRepositoryImpl();
    }

    @Override
    public void create(Long veterinarianId, Long petId, Date date, String description) throws InvalidParameterException {
        if (veterinarianId == null) {
            throw new InvalidParameterException("The veterinarian's id is null");
        }
        if (petId == null) {
            throw new InvalidParameterException("The pet's id is null");
        }
        if (date == null) {
            throw new InvalidParameterException("The date is null");
        }
        if (description == null || description.isBlank()) {
            throw new InvalidParameterException("The description is null or blank");
        }

        Optional<Veterinarian> veterinarianResult = veterinarianRepository.findById(veterinarianId);
        if (veterinarianResult.isEmpty()) {
            throw new InvalidParameterException("Invalid vet id");
        }

        Optional<Pet> petResult = petRepository.findById(petId);
        if (petResult.isEmpty()) {
            throw new InvalidParameterException("Invalid pet id");
        }
        Consult consult = new Consult(date, description);
        consult.setDate(date);
        consult.setDescription(description);

        consult.setVeterinarian(veterinarianResult.get());
        consult.setPet(petResult.get());
        consultRepository.create(consult);
    }

    @Override
    public List<Consult> findAllWithUnvaccinatedPets() {
        return consultRepository.findAllWithUnvaccinatedPets();
    }

    @Override
    public List<Consult> findAllByVetIdAndDateBetween(Long vetId, Date startDate, Date endDate) {
        try {
            Session session = SessionManager.getSessionFactory().openSession();
            Query<Consult> query = session.createQuery("From Consult c WHERE c.veterinarian.id=:vetId " +
                    "AND c.date BETWEEN :startDate AND :endDate", Consult.class);
            query.setParameter("vetId", vetId);
            query.setParameter("startDate", startDate);
            query.setParameter("endDate", endDate);
            List<Consult> consults = query.list();

            session.close();
            return consults;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}