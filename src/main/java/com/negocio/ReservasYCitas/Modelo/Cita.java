package com.negocio.ReservasYCitas.Modelo;

import java.time.LocalDateTime;
import lombok.*;

@Setter
@Getter
public class Cita {
    private int id;
    private Servicio servicio;
    private Estilista estilista;
    private LocalDateTime fechaHora;

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

}
