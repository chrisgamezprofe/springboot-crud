package com.vacantesupb.empresa.service;

import com.vacantesupb.empresa.model.Empresa;
import com.vacantesupb.empresa.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public ArrayList<Empresa> getAll(){
        return (ArrayList<Empresa>) empresaRepository.findAll();
    }

    public Empresa saveOrUpdate(Empresa e){
        return empresaRepository.save(e);
    }

    public void delete(Long id){
        empresaRepository.deleteById(id);
    }

    public Optional<Empresa> findById(Long id){
        return empresaRepository.findById(id);
    }



}
