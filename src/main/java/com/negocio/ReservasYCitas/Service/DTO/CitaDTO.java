package com.negocio.ReservasYCitas.Service.DTO;

import com.negocio.ReservasYCitas.Service.Entidades.Estilista;
import com.negocio.ReservasYCitas.Service.Entidades.Servicio;

import java.time.LocalDateTime;

public record CitaDTO(int id, Servicio servicio, Estilista estilista, LocalDateTime fechaHora) {


}
