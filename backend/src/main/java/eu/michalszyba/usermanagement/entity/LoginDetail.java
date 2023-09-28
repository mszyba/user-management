package eu.michalszyba.usermanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "app_login_detail")
public class LoginDetail {

    public LoginDetail(LocalDateTime timeStamp, String userName, boolean successful, String details) {
        this.timeStamp = timeStamp;
        this.userName = userName;
        this.successful = successful;
        this.details = details;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime timeStamp;
    private String userName;
    private boolean successful;
    private String details;
}
