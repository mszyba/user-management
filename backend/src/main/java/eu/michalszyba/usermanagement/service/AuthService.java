package eu.michalszyba.usermanagement.service;

import eu.michalszyba.usermanagement.dto.LoginDto;
import eu.michalszyba.usermanagement.dto.RegisterDto;
import eu.michalszyba.usermanagement.entity.LoginDetail;
import eu.michalszyba.usermanagement.entity.Role;
import eu.michalszyba.usermanagement.entity.User;
import eu.michalszyba.usermanagement.exception.AppException;
import eu.michalszyba.usermanagement.repository.RoleRepository;
import eu.michalszyba.usermanagement.repository.UserRepository;
import eu.michalszyba.usermanagement.security.JwtTokenProvider;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@AllArgsConstructor
@Service
public class AuthService {

    private static final String DEFAULT_ROLE = "ROLE_USER";

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final LoginDetailService loginDetailService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public String register(RegisterDto registerDto) {
        if (userRepository.existsByEmail(registerDto.getEmail())) {
            throw new AppException(HttpStatus.BAD_REQUEST,
                    "Username " + registerDto.getEmail() + " already exists!");
        }
        User user = new User();
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByRoleName(DEFAULT_ROLE);
        roles.add(userRole);

        user.setRoles(roles);
        userRepository.save(user);

        log.info("User " + user + " Register Successfully!");
        return "User Register Successfully!";
    }

    public String login(LoginDto loginDto) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(),
                loginDto.getPassword());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

//        loginDetailService.saveLoginSuccessful(loginDto.getUsername(), "");

        return jwtTokenProvider.generateToken(authentication);
    }
}
