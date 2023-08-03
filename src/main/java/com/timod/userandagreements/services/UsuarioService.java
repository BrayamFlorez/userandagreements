package com.timod.userandagreements.services;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.timod.userandagreements.models.UsuarioModel;
import com.timod.userandagreements.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    public UsuarioModel obtenerUsuarioPorId(Long id) {
        Optional<UsuarioModel> usuarioOptional = usuarioRepository.findById(id);
        return usuarioOptional.orElse(null);
    }

    public boolean actualizarUsuario(Long id, UsuarioModel usuario) {
        Optional<UsuarioModel> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            usuario.setId(id); // Establecer el ID para que se actualice correctamente en la base de datos
            usuarioRepository.save(usuario);
            return true;
        }
        return false;
    }

    public boolean eliminarUsuarioPorId(Long id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Agrega otros métodos según tus necesidades.
}
