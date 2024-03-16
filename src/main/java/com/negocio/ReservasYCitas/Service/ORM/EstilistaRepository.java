package com.negocio.ReservasYCitas.Service.ORM;

import com.negocio.ReservasYCitas.Service.Entidades.Estilista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstilistaRepository extends JpaRepository<Estilista,Integer> {
}
