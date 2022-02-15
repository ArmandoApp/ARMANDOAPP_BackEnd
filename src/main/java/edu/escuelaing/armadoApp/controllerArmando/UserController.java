package edu.escuelaing.armadoApp.controllerArmando;

import java.util.logging.Level;
import java.util.logging.Logger;

import edu.escuelaing.armadoApp.data.AuthenticationRequest;
import edu.escuelaing.armadoApp.data.BaseResponse;
import edu.escuelaing.armadoApp.dto.UserDto;
import edu.escuelaing.armadoApp.service.ArmandoAppException;
import edu.escuelaing.armadoApp.service.IArmandoAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController

public class UserController {
    @Autowired
    private IArmandoAppService service;

    @GetMapping("/dashboard")
    private String testingToken() {
        return "Welcome to the Dashboard" + SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @PostMapping("/createUser")
    private ResponseEntity<?> registrarUsuario(@RequestBody UserDto userDto) {
        try {
            service.createUser(userDto);
            return new ResponseEntity<>("Usuario " + userDto.getUserName() + " creado correctamente", HttpStatus.CREATED);
        } catch (ArmandoAppException e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    private ResponseEntity<?> autenticarUsuario(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            String token = service.login(authenticationRequest);
            return ResponseEntity.ok(new BaseResponse(token));
        } catch (ArmandoAppException e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}