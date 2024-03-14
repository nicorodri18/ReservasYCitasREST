package com.negocio.ReservasYCitas.Modelo;

import com.negocio.ReservasYCitas.Service.CitaService;
import com.negocio.ReservasYCitas.Service.FranjaHorariaService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;


public class Menu {


    private CitaService citaService;
    private FranjaHorariaService franjaHorariaService;

    public Menu(CitaService citaService, FranjaHorariaService franjaHorariaService) {
        this.citaService = citaService;
        this.franjaHorariaService = franjaHorariaService;
    }

    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Configurar Franja Horaria");
            System.out.println("2. Consultar Disponibilidad");
            System.out.println("3. Reservar Cita");
            System.out.println("4. Cancelar Cita");
            System.out.println("5. Reprogramar Cita");
            System.out.println("6. Consultar Citas");
            System.out.println("7. Salir");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    franjaHorariaService.configurarFranjaHoraria();
                    break;
                case "2":
                    System.out.println("Ingrese la fecha (formato YYYY-MM-DD): ");
                    String fechaStr = scanner.nextLine();
                    citaService.consultarDisponibilidad(LocalDate.parse(fechaStr));
                    break;
                case "3":
                    System.out.println("Ingrese el ID del servicio: ");
                    int servicioId = Integer.parseInt(scanner.nextLine());

                    System.out.println("Ingrese el ID del estilista: ");
                    int estilistaId = Integer.parseInt(scanner.nextLine());

                    System.out.println("Ingrese la hora de la cita (formato de 1 a 24): ");
                    int horaCita = Integer.parseInt(scanner.nextLine());
                    LocalDateTime fechaCita = franjaHorariaService.parseHora(horaCita);
                    citaService.reservarCita(servicioId, estilistaId, fechaCita);
                    break;
                case "4":
                    System.out.println("Ingrese el ID de la cita a cancelar: ");
                    int citaIdCancelar = Integer.parseInt(scanner.nextLine());
                    citaService.cancelarCita(citaIdCancelar);
                    break;
                case "5":
                    System.out.println("Ingrese el ID de la cita a reprogramar: ");
                    int citaIdReprogramar = Integer.parseInt(scanner.nextLine());

                    System.out.println("Ingrese la nueva hora de la cita (formato de 1 a 24): ");
                    int nuevaHoraCita = Integer.parseInt(scanner.nextLine());
                    LocalDateTime nuevaFechaHora = franjaHorariaService.parseHora(nuevaHoraCita);
                    citaService.reprogramarCita(citaIdReprogramar, nuevaFechaHora);
                    break;
                case "6":
                    citaService.consultarCitas();
                    break;
                case "7":
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}
