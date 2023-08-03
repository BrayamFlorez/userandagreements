package com.timod.userandagreements.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.timod.userandagreements.models.ConvenioModel;
import com.timod.userandagreements.services.ConvenioService;

@RestController
@RequestMapping("/convenio")
public class ConvenioController {

    @Autowired
    ConvenioService convenioService;

    @GetMapping()
    public ArrayList<ConvenioModel> obtenerConvenios() {
        return convenioService.obtenerConvenios();
    }

    @PostMapping
    public ConvenioModel guardarConvenio(@RequestBody ConvenioModel convenio) {
        return this.convenioService.guardarConvenio(convenio);
    }

    // Agrega otros métodos según tus necesidades, por ejemplo:

    @GetMapping("/{id}")
    public ConvenioModel obtenerConvenioPorId(@PathVariable Long id) {
        return convenioService.obtenerConvenioPorId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarConvenioPorId(@PathVariable Long id) {
        boolean eliminado = convenioService.eliminarConvenioPorId(id);
        if (eliminado) {
            return new ResponseEntity<>("Convenio eliminado correctamente.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se pudo eliminar el convenio.", HttpStatus.NOT_FOUND);
        }
    }
    
    // ErrorController personalizado
    @ControllerAdvice
public class CustomErrorController {

    // Manejo de excepciones generales
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>("Error interno del servidor: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Manejo de NotFoundException (404 Not Found)
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
        return new ResponseEntity<>("Recurso no encontrado: " + ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Agrega más métodos @ExceptionHandler para otros tipos de excepciones según tus necesidades
}

}
