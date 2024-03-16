package com.negocio.ReservasYCitas.Service.Entidades;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Table(name="citas")
@Entity
@Data
public class Cita {
    @Id
    @Column
    private int id;
    @Column
    private Servicio servicio;
    @Column(name = "estilista")
    @OneToOne
    @JoinColumn(name="nombre")
    private Estilista estilista;
    @Column
    private LocalDateTime fechaHora;

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

}
