package com.dt2.gtavi.controller;

import com.dt2.gtavi.entities.Carro;
import com.dt2.gtavi.entities.Missao;
import com.dt2.gtavi.repositories.MissaoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/missoes")
public class MissaoController {

    private final MissaoRepository repository;
    public MissaoController(MissaoRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Missao> mostrar(){
        return repository.findAll();
    }

    @PostMapping
    public String criarMissao(@RequestBody Missao missao){

        try {
            repository.save(missao);
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
