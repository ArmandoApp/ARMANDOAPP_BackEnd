package edu.escuelaing.armadoApp.controllerArmando;


import edu.escuelaing.armadoApp.data.BaseResponse;
import edu.escuelaing.armadoApp.service.ArmandoAppException;
import edu.escuelaing.armadoApp.service.IArmandoAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/v1/Armando/sala")

public class SalaController {
    @Autowired
    private IArmandoAppService service;

    @PostMapping
    private ResponseEntity<?> crearSala(){
        String idSala = service.createSala();
        return ResponseEntity.ok(new BaseResponse(idSala));
    }
    @PutMapping("/user/{idSala}")
    private ResponseEntity<?> addUserSala(@PathVariable String idSala){
         try{
             return new ResponseEntity<>(new BaseResponse(service.addUserSala(idSala)), HttpStatus.CREATED);
        }catch(ArmandoAppException e){
             Logger.getLogger(SalaController.class.getName()).log(Level.SEVERE,e.getMessage(),e);
             return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
