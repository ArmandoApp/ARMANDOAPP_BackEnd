package edu.escuelaing.armadoApp.service;

import edu.escuelaing.armadoApp.data.AuthenticationRequest;
import edu.escuelaing.armadoApp.dto.UserDto;

public interface IArmandoAppService {
    public void createUser(UserDto userDto) throws ArmandoAppException;

    public String login(AuthenticationRequest authenticationRequest) throws ArmandoAppException;
}
