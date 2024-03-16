package com.negocio.ReservasYCitas.Service.Controller;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class FranjaHorariaService {

    private LocalDateTime horaInicio;
    private LocalDateTime horaFin;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");

    public void configurarFranjaHoraria() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la hora de inicio (formato de 1 a 24): ");
        int horaInicioInt = Integer.parseInt(scanner.nextLine());

        System.out.println("Ingrese la hora de fin (formato de 1 a 24): ");
        int horaFinInt = Integer.parseInt(scanner.nextLine());

        try {
            horaInicio = parseHora(horaInicioInt);
            horaFin = parseHora(horaFinInt);
        } catch (Exception e) {
            System.out.println("Formato de hora incorrecto. Use valores de 1 a 24.");
            return;
        }

        System.out.println("Franja horaria configurada con éxito.");
    }

    LocalDateTime parseHora(int hora) {
        // Ajustar la hora para que esté en el rango de 1 a 24
        hora = (hora % 24 + 24) % 24;
        return LocalDateTime.of(1, 1, 1, hora, 0);
    }

    public void consultarDisponibilidad(LocalDate fecha) {
        // Lógica para consultar la disponibilidad en la franja horaria
        // Por ejemplo, podrías usar la hora de inicio de la franja horaria como hora predeterminada
        LocalDateTime fechaHoraInicio = LocalDateTime.of(fecha, horaInicio.toLocalTime());
        // Continuar con la lógica para consultar la disponibilidad...
    }

    public boolean estaEnFranjaHoraria(LocalTime hora) {
        return !hora.isBefore(horaInicio.toLocalTime()) && !hora.isAfter(horaFin.toLocalTime());
    }
}
