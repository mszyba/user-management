package eu.michalszyba.usermanagement.service;

import eu.michalszyba.usermanagement.dto.RegisterDto;
import eu.michalszyba.usermanagement.entity.Role;
import eu.michalszyba.usermanagement.entity.User;
import eu.michalszyba.usermanagement.exception.AppException;
import eu.michalszyba.usermanagement.repository.RoleRepository;
import eu.michalszyba.usermanagement.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    private final PasswordEncoder passwordEncoder;

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
}
