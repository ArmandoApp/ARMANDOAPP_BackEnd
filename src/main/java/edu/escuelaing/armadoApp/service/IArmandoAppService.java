package edu.escuelaing.armadoApp.service;

import edu.escuelaing.armadoApp.data.AuthenticationRequest;
import edu.escuelaing.armadoApp.data.Type;
import edu.escuelaing.armadoApp.data.UserModel;
import edu.escuelaing.armadoApp.dto.UserDto;

import java.util.List;

public interface IArmandoAppService {
    public void createUser(UserDto userDto) throws ArmandoAppException;

    public String login(AuthenticationRequest authenticationRequest) throws ArmandoAppException;

    List<Type> getTypes();

    List<UserModel> getUserModel(String category);

}
