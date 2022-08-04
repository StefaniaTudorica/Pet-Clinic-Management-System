package com.sda.stefania.petclinic.repository;

import com.sda.stefania.petclinic.model.Veterinarian;
import com.sda.stefania.petclinic.repository.base.BaseRepositoryImpl;
import com.sda.stefania.petclinic.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.List;

public class VeterinarianRepositoryImpl extends BaseRepositoryImpl<Veterinarian, Long> implements VeterinarianRepository {
    public VeterinarianRepositoryImpl() {
        super(Veterinarian.class);
    }

    @Override
    public List<Veterinarian> findByMultipleParameters(String firstName, String lastName, String address, String speciality) {
        try {
            Session session = SessionManager.getSessionFactory().openSession();
            String query = "FROM Veterinarian v WHERE";

            if (firstName != null) {
                query += " v.firstName=:firstName ";
            }else{
                query+="v.id is not null";
            }
            query+=" And ";

            if (lastName != null) {
                query += " v.lastName=:lastName ";
            }else{
                query+="v.id is not null";
            }
            query+=" And ";

            if (address != null) {
                query += " v.address=:address ";
            }else{
                query+="v.id is not null";
            }
            query+=" And ";

            if (speciality != null) {
                query += " v.speciality=:speciality ";
            }else{
                query+="v.id is not null";
            }

            System.out.println(query);
            Query<Veterinarian> query1 = session.createQuery(query, Veterinarian.class);
            if (firstName != null){
            query1.setParameter("firstName", firstName);
            }
            if (lastName != null){
                query1.setParameter("lastName", lastName);
            }
            if (address != null){
                query1.setParameter("address", address);
            }
            if (speciality != null){
                query1.setParameter("speciality", speciality);
            }
            List<Veterinarian> veterinarians = query1.list();
            session.close();
            return veterinarians;

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}

