package com.blog.demo.controller;

import com.blog.demo.dto.AuthenticationDTO;
import com.blog.demo.dto.LoginResponseDTO;
import com.blog.demo.dto.RegisterDTO;
import com.blog.demo.model.Usuario;
import com.blog.demo.repository.UsuarioRepository;
import com.blog.demo.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO authenticationDTO){
        var emailSenha = new UsernamePasswordAuthenticationToken(authenticationDTO.email(), authenticationDTO.senha());
        var auth = this.authenticationManager.authenticate(emailSenha);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDTO registerDTO){
        if(this.usuarioRepository.findByEmail(registerDTO.email()) != null) return  ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.senha());
        Usuario newUser = new Usuario(registerDTO.email(), registerDTO.nome(), encryptedPassword);

        this.usuarioRepository.saveAndFlush(newUser);

        return ResponseEntity.ok().build();
    }

}
