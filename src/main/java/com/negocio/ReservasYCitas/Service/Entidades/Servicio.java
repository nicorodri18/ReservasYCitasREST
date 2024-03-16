package com.negocio.ReservasYCitas.Service.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Data
@Entity
@Table(name = "servicios")
public class Servicio {

    @Id
    @Column
    private int id;
    @Column
    private String nombre;

}
