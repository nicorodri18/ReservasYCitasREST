package com.negocio.ReservasYCitas.Service.Entidades;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int servicio;
    private int estilista;
    private LocalDateTime fechaHora;


}
