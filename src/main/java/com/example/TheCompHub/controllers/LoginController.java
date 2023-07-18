package com.example.TheCompHub.controllers;

import com.example.TheCompHub.entities.Login;
import com.example.TheCompHub.services.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/form")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Login>> getLogin(){
        return ResponseEntity.ok(loginService.getLogin());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Login> getLoginById(@PathVariable Integer id) {
        Optional<Login> login = loginService.getLoginById(id);
        return login.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Login> addLogin(@RequestBody Login login) {
        Login addedLogin = loginService.addLogin(login);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedLogin);
    }
}
