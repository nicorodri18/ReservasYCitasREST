package com.negocio.ReservasYCitas.Service.Entidades;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Data
@Entity
@Table(name = "estilistas")
public class Estilista {
    @Id
    @Column
    private int id;
    @Column(name = "nombre")
    @OneToOne
    @JoinColumn(name = "estilista")
    private String nombre;

}
