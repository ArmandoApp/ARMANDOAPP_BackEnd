package edu.escuelaing.armadoApp.service;

import edu.escuelaing.armadoApp.data.AuthenticationRequest;

public interface IArmandoAppService {
    public void createUser(AuthenticationRequest authenticationRequest) throws ArmandoAppException;

    public String login(AuthenticationRequest authenticationRequest) throws ArmandoAppException;
}
