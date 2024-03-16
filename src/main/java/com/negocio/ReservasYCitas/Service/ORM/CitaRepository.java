package com.negocio.ReservasYCitas.Service.ORM;

import com.negocio.ReservasYCitas.Service.Entidades.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaRepository extends JpaRepository<Cita,Integer> {
}
