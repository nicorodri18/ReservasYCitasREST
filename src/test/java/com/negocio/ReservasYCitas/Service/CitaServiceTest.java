package com.negocio.ReservasYCitas.Service;

import com.negocio.ReservasYCitas.Service.Controller.CitaService;
import com.negocio.ReservasYCitas.Service.Entidades.Cita;
import com.negocio.ReservasYCitas.Service.ORM.CitaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class CitaServiceTest {
    @InjectMocks
    CitaService service;

    @Mock
    CitaRepository repository;

    @Test
    void crearCita(){
        Cita cita= new Cita();
        cita.setId(1);
        cita.setServicio(1);
        cita.setEstilista(11);
        cita.setFechaHora(LocalDateTime.now() );
        repository.save(cita);

        assertSame(cita,repository.findById(1));
    }

}
