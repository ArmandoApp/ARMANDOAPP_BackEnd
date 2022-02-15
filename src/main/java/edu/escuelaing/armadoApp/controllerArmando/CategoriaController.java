package edu.escuelaing.armadoApp.controllerArmando;

import edu.escuelaing.armadoApp.data.Type;
import edu.escuelaing.armadoApp.data.UserModel;
import edu.escuelaing.armadoApp.service.IArmandoAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/Armando/Categorias")
public class CategoriaController {

    @Autowired
    IArmandoAppService iArmandoAppService;

    @GetMapping("/showCategories")
    public ResponseEntity<List<Type>> getTypes(){

        return new ResponseEntity<List<Type>>(iArmandoAppService.getTypes(), HttpStatus.ACCEPTED);

    }

    @GetMapping("/getCategories/{category}")
    public ResponseEntity<List<UserModel>> getUserCategories(@PathVariable String category){
        return new ResponseEntity<List<UserModel>>(iArmandoAppService.getUserModel(category), HttpStatus.OK);
    }



}
