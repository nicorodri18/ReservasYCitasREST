package com.negocio.ReservasYCitas.Service.Controller;

import com.negocio.ReservasYCitas.Service.Entidades.Estilista;
import com.negocio.ReservasYCitas.Service.ORM.EstilistaRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
public class EstilistaController {

    private EstilistaRepository repository;

    @GetMapping("/estilista/{id}")
    public Response<Estilista> consultarEstilista(@PathVariable Integer id){

        return new Response<>(repository.findById(id).orElse(null),null);
    }
    @GetMapping("/estilistas")
    public List<Estilista> consultarEstilistas(){

        return repository.findAll();
    }
    @PostMapping("/estilista")
    public Response<Estilista> agregarEstilista(@RequestBody Estilista estilista){
        repository.save(estilista);
        return new Response<>(estilista,null);
    }
    @DeleteMapping("/estilista/del")
    public Response<String> eliminarEstilista(@RequestBody Integer id){
        repository.deleteById(id);
        return new Response<>("Estilista eliminado Con exito",null);

    }
    @PutMapping("/estilista/update")
    public Response<Estilista> modificarEstilista(@RequestBody Integer id, String nombre){
        Estilista cambio;
        cambio=repository.findById(id).orElse(null);
        if (cambio!=null){
            cambio.setNombre(nombre);
            repository.save(cambio);
        }
        return new Response<>(cambio,null);
    }
}
