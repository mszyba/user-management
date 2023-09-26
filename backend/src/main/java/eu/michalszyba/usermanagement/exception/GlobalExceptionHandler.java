package eu.michalszyba.usermanagement.exception;

import eu.michalszyba.usermanagement.dto.ErrorDetailDto;
import eu.michalszyba.usermanagement.entity.ErrorDetail;
import eu.michalszyba.usermanagement.service.ErrorDetailService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@AllArgsConstructor
@ControllerAdvice
public class GlobalExceptionHandler {

    private final ModelMapper modelMapper;
    private final ErrorDetailService errorDetailService;

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorDetail> handleAppException(AppException exception, WebRequest webRequest) {
        ErrorDetailDto errorDetailDto =
                new ErrorDetailDto(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false)
        );

        ErrorDetail errorDetail = modelMapper.map(errorDetailDto, ErrorDetail.class);
        errorDetailService.save(errorDetail);

        return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
    }
}
