package edu.escuelaing.armadoApp.service;



import edu.escuelaing.armadoApp.cache.ICacheRedis;
import edu.escuelaing.armadoApp.data.AuthenticationRequest;
import edu.escuelaing.armadoApp.data.SalaModel;
import edu.escuelaing.armadoApp.data.Type;
import edu.escuelaing.armadoApp.data.UserModel;
import edu.escuelaing.armadoApp.dto.UserDto;
import edu.escuelaing.armadoApp.repository.TypesRepository;
import edu.escuelaing.armadoApp.repository.UserRepository;
import edu.escuelaing.armadoApp.repository.SalaRepository;
import edu.escuelaing.armadoApp.security.JwtUtils;
import edu.escuelaing.armadoApp.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import sun.text.normalizer.ICUBinary;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    @Autowired
    private TypesRepository typesRepository;
    @Autowired
    private SalaRepository salaRepository;
    @Autowired
    private ICacheRedis cache;

    @Override
    public void createUser(UserDto userDto) throws ArmandoAppException {

        if (userRepository.findByUsername(userDto.getUserName()) == null)
            try {
                System.out.println(userDto.getCategory());
                userRepository.save(new UserModel(userDto));
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

    @Override
    public List<Type> getTypes() {
        return typesRepository.findAll();
    }


    @Override
    public List<UserModel> getUserModel(String category) {
        return userRepository.findUserModelByCategory(category);
    }

    @Override
    public String createSala(){
        SalaModel newSala = salaRepository.save(new SalaModel());
        return  newSala.getId();
    }

    @Override
    public String addUserSala(String idSala) throws ArmandoAppException{
        Optional<SalaModel> m = salaRepository.findById(idSala);
        if(m.isPresent()){
            SalaModel sala = m.get();
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserModel user = userRepository.findByUsername(userDetails.getUsername());
            if(sala.getUsersId().contains(user.getId())) throw new ArmandoAppException("Usuario ya esta en sala");
            cache.incrementUsers(idSala);
            sala.getUsersId().add(user.getId());
            salaRepository.save(sala);
            return ("Usuario agregado correctamente");


        }else{
            throw new ArmandoAppException("Sala no existe");
        }
    }
}
