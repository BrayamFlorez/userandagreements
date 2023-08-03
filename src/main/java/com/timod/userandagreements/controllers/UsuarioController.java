package com.timod.userandagreements.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timod.userandagreements.models.UsuarioModel;
import com.timod.userandagreements.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> obtenerUsuarioPorId(@PathVariable Long id) {
        UsuarioModel usuario = usuarioService.obtenerUsuarioPorId(id);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarUsuario(@PathVariable Long id, @RequestBody UsuarioModel usuario) {
        boolean actualizado = usuarioService.actualizarUsuario(id, usuario);
        if (actualizado) {
            return new ResponseEntity<>("Usuario actualizado correctamente.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se pudo actualizar el usuario.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuarioPorId(@PathVariable Long id) {
        boolean eliminado = usuarioService.eliminarUsuarioPorId(id);
        if (eliminado) {
            return new ResponseEntity<>("Usuario eliminado correctamente.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se pudo eliminar el usuario.", HttpStatus.NOT_FOUND);
        }
    }
}
