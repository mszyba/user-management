package eu.michalszyba.usermanagement.service;

import eu.michalszyba.usermanagement.entity.ErrorDetail;
import eu.michalszyba.usermanagement.repository.ErrorDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ErrorDetailService {

    private final ErrorDetailRepository errorDetailRepository;

    public void save(ErrorDetail errorDetail) {
        errorDetailRepository.save(errorDetail);
    }
}
