package com.vacantesupb.empresa.service;

import com.vacantesupb.empresa.model.Empresa;
import com.vacantesupb.empresa.model.Vacante;
import com.vacantesupb.empresa.repository.EmpresaRepository;
import com.vacantesupb.empresa.repository.VacanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class VacanteService {

    @Autowired
    private VacanteRepository vacanteRepository;

    public ArrayList<Vacante> getAll(){
        return (ArrayList<Vacante>) vacanteRepository.findAll();
    }

    public Vacante saveOrUpdate(Vacante e){
        return vacanteRepository.save(e);
    }

    public void delete(Long id){
        vacanteRepository.deleteById(id);
    }

    public Optional<Vacante> findById(Long id){
        return vacanteRepository.findById(id);
    }

}
