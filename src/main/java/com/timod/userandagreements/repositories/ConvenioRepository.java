package com.timod.userandagreements.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.timod.userandagreements.models.ConvenioModel;

@Repository
public interface ConvenioRepository extends CrudRepository<ConvenioModel, Long>{
    
}