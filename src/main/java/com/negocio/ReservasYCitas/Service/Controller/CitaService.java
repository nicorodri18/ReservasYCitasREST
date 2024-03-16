package com.negocio.ReservasYCitas.Service.Controller;

import com.negocio.ReservasYCitas.Service.Entidades.Estilista;
import com.negocio.ReservasYCitas.Service.Entidades.Servicio;
import com.negocio.ReservasYCitas.Service.Entidades.Cita;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class CitaService {


    private FranjaHorariaService franjaHorariaService;
    private List<Cita> citas;
    private int proximoId; // Para asignar IDs a nuevas citas

    public CitaService(FranjaHorariaService franjaHorariaService) {
        this.franjaHorariaService = franjaHorariaService;
        this.citas = new ArrayList<>();
        this.proximoId = 1;
    }

    public void consultarDisponibilidad(LocalDate fecha) {
        franjaHorariaService.consultarDisponibilidad(fecha);
        // Aquí podrías mostrar la disponibilidad en función de las citas ya reservadas
    }

    public void reservarCita(int servicioId, int estilistaId, LocalDateTime fechaHora) {
        // Verificar si la hora está dentro de la franja horaria permitida
        if (!franjaHorariaService.estaEnFranjaHoraria(fechaHora.toLocalTime())) {
            System.out.println("La hora de la cita está fuera de la franja horaria permitida.");
            return;
        }
        // Verificar disponibilidad en esa hora específica
        if (hayConflictoDeCita(fechaHora)) {
            System.out.println("Ya hay una cita programada en esa hora. Por favor, elija otra hora.");
            return;
        }
        // Crear la nueva cita
        Servicio servicio = new Servicio(); // Obtener el servicio por su ID desde algún servicio de datos
        servicio.setId(servicioId);
        Estilista estilista = new Estilista(); // Obtener el estilista por su ID desde algún servicio de datos
        estilista.setId(estilistaId);
        Cita cita = new Cita();
        cita.setId(proximoId++);
        cita.setServicio(servicio);
        cita.setEstilista(estilista);
        cita.setFechaHora(fechaHora);
        citas.add(cita);

        System.out.println("Cita reservada con éxito. ID de la cita: " + cita.getId());
    }

    private boolean hayConflictoDeCita(LocalDateTime fechaHora) {
        // Verificar si ya hay una cita programada en la hora especificada
        return citas.stream().anyMatch(c -> c.getFechaHora().equals(fechaHora));
    }

    public void cancelarCita(int citaId) {
        Optional<Cita> citaOptional = citas.stream().filter(c -> c.getId() == citaId).findFirst();
        if (citaOptional.isPresent()) {
            citas.remove(citaOptional.get());
            System.out.println("Cita cancelada con éxito.");
        } else {
            System.out.println("No se encontró una cita con el ID especificado.");
        }
    }

    public void reprogramarCita(int citaId, LocalDateTime nuevaFechaHora) {
        Optional<Cita> citaOptional = citas.stream().filter(c -> c.getId() == citaId).findFirst();
        if (citaOptional.isPresent()) {
            Cita cita = citaOptional.get();
            // Verificar si la nueva hora está dentro de la franja horaria permitida
            if (!franjaHorariaService.estaEnFranjaHoraria(nuevaFechaHora.toLocalTime())) {
                System.out.println("La nueva hora de la cita está fuera de la franja horaria permitida.");
                return;
            }
            // Verificar disponibilidad en la nueva hora específica
            if (hayConflictoDeCita(nuevaFechaHora)) {
                System.out.println("Ya hay una cita programada en la nueva hora. Por favor, elija otra hora.");
                return;
            }
            // Actualizar la fecha y hora de la cita
            cita.setFechaHora(nuevaFechaHora);
            System.out.println("Cita reprogramada con éxito.");
        } else {
            System.out.println("No se encontró una cita con el ID especificado.");
        }
    }

    public void consultarCitas() {
        if (citas.isEmpty()) {
            System.out.println("No hay citas programadas.");
        } else {
            System.out.println("Citas programadas:");
            for (Cita cita : citas) {
                System.out.println(cita); // Aquí podrías mostrar los detalles de cada cita
            }
        }
    }

}
