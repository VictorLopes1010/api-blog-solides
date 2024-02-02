package com.blog.demo.repository;

import com.blog.demo.dto.UserDTO;
import com.blog.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    UserDetails findByEmail(String email);

    @Query(value = "SELECT u.id as id, u.email as email, u.name as name from Users u", nativeQuery = true)
    List<UserDTO.UserInterfaceDTO> searchListUsers();

}
