package com.negocio.ReservasYCitas.Modelo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class FranjaHorario {
    private LocalDateTime inicio;
    private LocalDateTime fin;
    // Constructor, getters y setters
}
