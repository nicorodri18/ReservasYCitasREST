package com.negocio.ReservasYCitas.DTO;

import com.negocio.ReservasYCitas.Modelo.Estilista;
import com.negocio.ReservasYCitas.Modelo.Servicio;

import java.time.LocalDateTime;

public record CitaDTO(int id, Servicio servicio, Estilista estilista,LocalDateTime fechaHora) {


}
