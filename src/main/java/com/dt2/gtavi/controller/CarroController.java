package com.dt2.gtavi.controller;

import com.dt2.gtavi.entities.Carro;
import com.dt2.gtavi.repositories.CarroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/veiculos")
public class CarroController {
    private final CarroRepository repository;
    public CarroController(CarroRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Carro> mostrar(){
        return repository.findAll();
    }

    @PostMapping
    public String criarCarro(@RequestBody Carro carro){

        try {
            repository.save(carro);
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
