package com.example.TheCompHub.services;

import com.example.TheCompHub.entities.Login;
import com.example.TheCompHub.repositories.LoginRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {
    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public Iterable<Login> getLogin() {
        return loginRepository.findAll();
    }

    public Optional<Login> getLoginById(Integer id) {
        return loginRepository.findById(id);
    }

    public Login addLogin(Login login) {
        return loginRepository.save(login);
    }

    public List<Login> addLogins(List<Login> logins) {
        return (List<Login>) loginRepository.saveAll(logins);
    }
    
}
