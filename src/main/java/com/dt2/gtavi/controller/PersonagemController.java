package com.dt2.gtavi.controller;


import com.dt2.gtavi.entities.Personagem;
import com.dt2.gtavi.repositories.PersonagemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/personagens")
public class PersonagemController {

    private final PersonagemRepository repository;
     public PersonagemController(PersonagemRepository repository){
        this.repository = repository;
    }


    @GetMapping
    public List<Personagem> mostrar(){
         return repository.findAll();
    }

    @PostMapping
    public String criarPersonagem(@RequestBody Personagem lucas){

    try {
         repository.save(lucas);
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

    @PostMapping("/{id}")
    public void atualizar(@PathVariable int id,
                          @RequestBody Personagem p){

         Personagem personagem = repository.getReferenceById(id);
         personagem.setNome(p.getNome());
         personagem.setApelido(p.getApelido());
         personagem.setCategoria(p.getCategoria());
         personagem.setDescricao(p.getDescricao());
         personagem.setImagem(p.getImagem());
         repository.save(personagem);
    }
}
