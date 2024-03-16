package com.negocio.ReservasYCitas.Service.ORM;

import com.negocio.ReservasYCitas.Service.Entidades.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicioRepository extends JpaRepository<Servicio,Integer> {
}
