package com.negocio.ReservasYCitas.Service.Controller;

import com.negocio.ReservasYCitas.Service.Entidades.Servicio;
import com.negocio.ReservasYCitas.Service.ORM.ServicioRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
public class ServicioController {

    private ServicioRepository repository;

    @GetMapping
    public Response<Servicio> buscarServicio(@PathVariable Integer id){

        return new Response<>(repository.findById(id).orElse(null),null);
    }
    @GetMapping
    public List<Servicio> traerServicios(){
        return repository.findAll();
    }
    @PostMapping
    public Response<Servicio> nuevoServicio(@RequestBody Servicio servicio){
        repository.save(servicio);
        return new Response<>(servicio,null);

    }
    @PutMapping
    public Response<Servicio> modificarServicio(@RequestBody Integer id, String nombre){
        Servicio modificar;
        modificar=repository.findById(id).orElse(null);
        if (modificar!=null){
            modificar.setNombre(nombre);
            repository.save(modificar);
        }
        return new Response<>(modificar,null);

    }
    @DeleteMapping
    public Response<String> eliminarServicio(@RequestBody Integer id){
        repository.deleteById(id);
        return new Response<>("Servicio Eliminado",null);
    }
}
