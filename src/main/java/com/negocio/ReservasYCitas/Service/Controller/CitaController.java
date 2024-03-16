package com.negocio.ReservasYCitas.Service.Controller;


import com.negocio.ReservasYCitas.Service.Entidades.Cita;
import com.negocio.ReservasYCitas.Service.ORM.CitaRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;


import java.util.List;
@Component
@RestController
public class CitaController {
    private CitaRepository repository;

    public CitaController(CitaRepository citaRepository){
        this.repository= repository;
    }
    @PostMapping("/cita")
    public String reservarCita(@RequestBody Cita cita){
        repository.save(cita);
        return "Cita Agendada";
    }
    @GetMapping("/cita/{id}")
    public Cita buscarCitaPorId(@PathVariable Integer id){
        return repository.findById(id).orElse(null);
    }

    @GetMapping("/citas/{id}")
    public Response<Cita> traerCita(@RequestBody Integer id){
        return new Response<>(repository.findById(id).orElse(null),null) ;
    }
    @GetMapping("/citas")
    public List<Cita> traerCitas(){
        return repository.findAll();
    }
    @DeleteMapping("/cita/borrar/{id}")
    public Response cancelarCita(@RequestBody Integer id){
        repository.deleteById(id);
        return new Response<> (null,"Cita Cancelada");
    }
    @PutMapping("/cita/{id}")
    public Response<Cita> reprogramarCita(@RequestBody Integer id, LocalDateTime date){
        Cita actualizar;
        actualizar=repository.findById(id).orElse(null);
        if (actualizar!=null){
            actualizar.setFechaHora(date);
            repository.save(actualizar);
        }
        return  new Response<>(repository.findById(id).orElse(null),"");
    }
}
