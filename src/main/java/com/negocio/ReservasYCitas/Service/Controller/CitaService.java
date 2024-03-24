package com.negocio.ReservasYCitas.Service.Controller;

import com.negocio.ReservasYCitas.Service.Entidades.Cita;
import com.negocio.ReservasYCitas.Service.ORM.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CitaService {
    @Autowired
    private CitaRepository repository;

    public Cita crearCita(int servicio, int estilista,LocalDateTime date){
        Cita nueva= new Cita();
        nueva.setEstilista(estilista);
        nueva.setFechaHora(date);
        nueva.setServicio(servicio);

    return  repository.save(nueva);
    }
    public Cita buscarCita(int id){
        Optional<Cita> optional = repository.findById(id);
        Cita cita = optional.get();
        return cita;
    }
    public List<Cita> traerTodas(){
        return repository.findAll();
    }
    public Cita actualizarCita(int id, LocalDateTime fecha){
        Cita cita=repository.findById(id).orElse(null);
        cita.setFechaHora(fecha);
        return repository.save(cita);
    }






}
