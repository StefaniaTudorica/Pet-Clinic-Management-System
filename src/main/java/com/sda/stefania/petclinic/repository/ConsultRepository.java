package com.sda.stefania.petclinic.repository;

import com.sda.stefania.petclinic.model.Consult;
import com.sda.stefania.petclinic.repository.base.BaseRepository;
import com.sda.stefania.petclinic.utils.SessionManager;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface ConsultRepository extends BaseRepository<Consult, Long> {

}
