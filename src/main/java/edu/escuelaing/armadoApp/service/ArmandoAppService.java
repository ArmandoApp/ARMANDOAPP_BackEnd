package edu.escuelaing.armadoApp.service;



import edu.escuelaing.armadoApp.data.AuthenticationRequest;
import edu.escuelaing.armadoApp.data.UserModel;
import edu.escuelaing.armadoApp.repository.UserRepository;
import edu.escuelaing.armadoApp.security.JwtUtils;
import edu.escuelaing.armadoApp.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class ArmandoAppService implements IArmandoAppService{
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public void createUser(AuthenticationRequest authenticationRequest) throws ArmandoAppException {
        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();
        UserModel userModel = new UserModel();
        userModel.setUsername(username);
        userModel.setPassword(password);

        if (userRepository.findByUsername(username) == null)
            try {
                userRepository.save(userModel);
            } catch (Exception e) {
                throw new ArmandoAppException("No se pudo guardar un usuario");
            }
        else {
            throw new ArmandoAppException("Usuario ya existe");
        }
    }

    @Override
    public String login(AuthenticationRequest authenticationRequest) throws ArmandoAppException {
        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BadCredentialsException e) {
            throw new ArmandoAppException("Credenciales incorrectas");
        }

        UserDetails loadedUser = userService.loadUserByUsername(username);

        return jwtUtils.generateToken(loadedUser);
    }
}
