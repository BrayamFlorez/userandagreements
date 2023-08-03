package com.timod.userandagreements.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.timod.userandagreements.models.UsuarioModel;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long>{
    
}
