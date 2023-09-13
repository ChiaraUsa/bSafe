package com.example.app.servicios;

import com.example.app.auth.AuthenticationResponse;
import com.example.app.config.JwtService;
import com.example.app.entidades.Usuario;
import com.example.app.repository.UsuarioCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioCrudRepository UserRepository;
    public Optional<Usuario> findById(int id) {
        return UserRepository.findById(id);
    }

    public boolean actualizar(int id,String name, String email){
        Usuario usuarioExiste = UserRepository.findById(id).orElse(null);
        Usuario usuarioX = UserRepository.findByEmail(email).orElse(null);

        if(!name.isBlank() && !email.isBlank())
        {
            if(usuarioX==null || usuarioExiste.getId()==usuarioX.getId()) {
                usuarioExiste.setFirstname(name);
                usuarioExiste.setEmail(email);
                UserRepository.save(usuarioExiste);
                return true;
            }
        }
        return false;
    }
}
