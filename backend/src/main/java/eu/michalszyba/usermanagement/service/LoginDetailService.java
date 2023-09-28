package eu.michalszyba.usermanagement.service;

import eu.michalszyba.usermanagement.entity.LoginDetail;
import eu.michalszyba.usermanagement.repository.LoginDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class LoginDetailService {

    private final LoginDetailRepository loginDetailRepository;

    public void saveLoginSuccessful(String username, String message) {
        LoginDetail loginDetail = new LoginDetail(LocalDateTime.now(), username, true, message);
        loginDetailRepository.save(loginDetail);
    }
}
