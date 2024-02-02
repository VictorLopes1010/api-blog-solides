package com.blog.demo.serviceImpl;

import com.blog.demo.dto.UserDTO;
import com.blog.demo.repository.UserRepository;
import com.blog.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDTO> searchListUsers(){
        try{
            return userRepository.searchListUsers().stream().map(UserDTO :: new).collect(Collectors.toList());
        }catch (Exception e){
            throw new RuntimeException("Erro ao buscar usuários", e);
        }
    }
}
