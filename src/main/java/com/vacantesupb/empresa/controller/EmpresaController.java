package com.vacantesupb.empresa.controller;

import com.vacantesupb.empresa.model.Empresa;
import com.vacantesupb.empresa.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    Map<String,Object> map =new HashMap<>();

    @GetMapping
    private ResponseEntity<ArrayList<Empresa>> getAll(){
        return ResponseEntity.ok(empresaService.getAll());
    }

    @PostMapping
    private ResponseEntity<Object> save(@RequestBody Empresa obj){
        try{

            obj = empresaService.saveOrUpdate(obj);
            return ResponseEntity.created(new URI("/api/empresas/"+obj.getId())).body(obj);
        }catch (Exception ex){
            map.put("error",true);
            map.put("message","Ya existe una empresa con nit:"+obj.getNit());
            //map.put("token",getJWTToken(obj.getNit()));
            return new ResponseEntity<Object>(map, HttpStatus.CONFLICT);
        }
    }
/*
    private String getJWTToken(String unico) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(unico)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }

*/
    @PutMapping(path = "/{id}")
    private ResponseEntity<Object> update(@PathVariable("id") long id,@RequestBody Empresa obj){
        try{
            obj.setId(id);
            obj = empresaService.saveOrUpdate(obj);
            return ResponseEntity.accepted().body(obj);
        }catch (Exception ex){
            map.put("error",true);
            map.put("message","No se pudo actualizar la empresa");
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }
    }

    @GetMapping(path = "/{id}")
    private ResponseEntity<Object> findById(@PathVariable("id") long id){
        ResponseEntity response = ResponseEntity.ok(empresaService.findById(id));
        return response;
    }


    @DeleteMapping(path = "/{id}")
    private ResponseEntity<Object> deleteById(@PathVariable("id") long id){
        ResponseEntity response = ResponseEntity.ok(empresaService.findById(id));
        if(response.toString().contains("Optional.empty")){
            map.put("error",true);
            map.put("message","No existe una empresa con id:"+id);
            return new ResponseEntity<>(map,HttpStatus.OK);
        }else{
            empresaService.delete(id);
            map.put("error",false);
            map.put("message","La empresa fue eliminada correctamente");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
    }


}
