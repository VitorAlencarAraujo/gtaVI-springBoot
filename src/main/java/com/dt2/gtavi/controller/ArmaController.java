package com.dt2.gtavi.controller;

import com.dt2.gtavi.entities.Arma;
import com.dt2.gtavi.entities.Personagem;
import com.dt2.gtavi.repositories.ArmaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/armas")
public class ArmaController {

    private final ArmaRepository repository;
    public ArmaController(ArmaRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Arma> mostrar(){
        return repository.findAll();
    }

    @PostMapping
    public String criarArma(@RequestBody Arma arma){

        try {
            repository.save(arma);
            return "Calvo com sucesso 👌";

        }
        catch (Exception e){
            return "Deu ruim em bixo";
        }
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable int id){

        repository.deleteById(id);
        return "Deletado com sucesso!";
    }

    @GetMapping("/{id}")
    public void buscarId(@PathVariable int id){
        repository.findById(id);
    }
}
