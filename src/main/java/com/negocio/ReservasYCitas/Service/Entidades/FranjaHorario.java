package com.negocio.ReservasYCitas.Service.Entidades;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class FranjaHorario {
    private LocalDateTime inicio;
    private LocalDateTime fin;
}
