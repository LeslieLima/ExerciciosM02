package tech.devinhouse.veiculos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.devinhouse.veiculos.exception.RegistroJaExistenteException;
import tech.devinhouse.veiculos.model.Usuario;
import tech.devinhouse.veiculos.repository.UsuarioRepository;

import java.util.*;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public Usuario inserir(Usuario usuario) {
        if (repo.existsByEmail(usuario.getEmail()))
            throw new RegistroJaExistenteException("Usuario", usuario.getEmail());
        String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);
        return repo.save(usuario);
    }

    public List<Usuario> consultar() {
        return repo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        Optional<Usuario> usuarioOpt = repo.findByEmail(email);
        if (usuarioOpt.isEmpty())
            throw new UsernameNotFoundException("User not found");
        return usuarioOpt.get();
        // mesma coisa
//        return repo.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

    }
}
