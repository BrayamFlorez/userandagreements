package com.timod.userandagreements.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timod.userandagreements.models.ConvenioModel;
import com.timod.userandagreements.repositories.ConvenioRepository;

@Service
public class ConvenioService {

    @Autowired
    ConvenioRepository convenioRepository;

    public ArrayList<ConvenioModel> obtenerConvenios() {
        return (ArrayList<ConvenioModel>) convenioRepository.findAll();
    }

    public ConvenioModel guardarConvenio(ConvenioModel convenio) {
        return convenioRepository.save(convenio);
    }

    public boolean actualizarConvenio(Long id, ConvenioModel convenio) {
        Optional<ConvenioModel> convenioOptional = convenioRepository.findById(id);
        if (convenioOptional.isPresent()) {
            convenio.setId(id); // Establecer el ID para que se actualice correctamente en la base de datos
            convenioRepository.save(convenio);
            return true;
        }
        return false;
    }
    

    public ConvenioModel obtenerConvenioPorId(Long id) {
        Optional<ConvenioModel> convenioOptional = convenioRepository.findById(id);
        if (convenioOptional.isPresent()) {
            return convenioOptional.get();
        }
        return null; // O puedes lanzar una excepción si no se encuentra el convenio con el ID especificado
    }

    public boolean eliminarConvenioPorId(Long id) {
        try {
            convenioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Agrega otros métodos según tus necesidades, por ejemplo:

    // Método para buscar convenios por algún criterio específico, etc.
}
