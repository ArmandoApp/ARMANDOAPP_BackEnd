package edu.escuelaing.armadoApp.controllerArmando;

import edu.escuelaing.armadoApp.service.IArmandoAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/Armando/Chat")
public class ChatController {
    @Autowired
    IArmandoAppService iArmandoAppService;

}
