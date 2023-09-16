package com.example.app.controllers;

import com.example.app.entidades.Empresa;
import com.example.app.entidades.Usuario;
import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Data
public class EmpresaData {

    private String email;
    private int id;

    public EmpresaData(){
        if(SecurityContextHolder.getContext().getAuthentication() != null){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Empresa userDetails = (Empresa) authentication.getPrincipal();
            email = userDetails.getUsername();
            id = userDetails.getId();
        }
    }
}