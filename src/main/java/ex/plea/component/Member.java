package ex.plea.component;

import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table
public class Member {
    @Id
    @GeneratedValue
    private Long id;


    @Column(unique = true)
    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    private UserRole Role = UserRole.ROLE_NOT_PERMITTED;

    @Embedded
    private Chito chito;

}
