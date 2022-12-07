package edu.eci.arsw.papermind.backend.controller;


import edu.eci.arsw.papermind.backend.converter.BibliotecaConverter;
import edu.eci.arsw.papermind.backend.dto.BibliotecaDto;
import edu.eci.arsw.papermind.backend.exception.ResourceNotFoundException;
import edu.eci.arsw.papermind.backend.model.Biblioteca;
import edu.eci.arsw.papermind.backend.services.BibliotecaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BibliotecaController {

    @Autowired
    private BibliotecaServices bibliotecaServices;
    @Autowired
    BibliotecaConverter bibliotecaConverter;

    //Get Bibliotecas
    @GetMapping("/bibliotecas")
    public List<Biblioteca> getAllBibliotecas(){
        return this.bibliotecaServices.getBibliotecas();
    }

    //Get Biblioteca by Name
    @GetMapping("/bibliotecas/{name}")
    public ResponseEntity<?> getBibliotecaByName(@PathVariable(value = "name") String name) throws ResourceNotFoundException { //@PathVariable indica que nos referimos a datos incluidos dentro del mismo path del pedido
        return new ResponseEntity<>(bibliotecaServices.getBibliotecaByName(name),HttpStatus.ACCEPTED);
    }

    //Save Biblioteca
    @PostMapping("/bibliotecas")
    public ResponseEntity<?> createBiblioteca(@RequestBody BibliotecaDto bibliotecadto){
        Biblioteca biblioteca = bibliotecaConverter.dtoToEntity(bibliotecadto);
        ResponseEntity<?> bibliotecaAnswer = bibliotecaServices.saveBiblioteca(biblioteca);
        return bibliotecaAnswer;
    }

    //Update Bibblioteca
    @PutMapping("/bibliotecas/{name}")
    public ResponseEntity<?> updateBiblioteca(@PathVariable(value = "name") String name, @RequestBody BibliotecaDto bibliotecaDatosdto) throws ResourceNotFoundException {
        Biblioteca biblioteca = bibliotecaConverter.dtoToEntity(bibliotecaDatosdto);
        ResponseEntity<?> bibliotecaAnswer = bibliotecaServices.updateBiblioteca(name,biblioteca);
        return bibliotecaAnswer;
    }

    //Delete Biblioteca
    @DeleteMapping("/bibliotecas/{nombre}")
    public ResponseEntity<?> deleteBiblioteca(@PathVariable(value = "nombre") String nombre) throws ResourceNotFoundException {
        return this.bibliotecaServices.deleteBiblioteca(nombre);
    }

}
