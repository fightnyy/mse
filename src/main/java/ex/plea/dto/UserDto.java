package ex.plea.dto;

import ex.plea.component.Chito;
import ex.plea.component.User;
import ex.plea.component.UserRole;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter @Setter
public class UserDto {
    private String username;

    private String password;

    private UserRole Role = UserRole.ROLE_NOT_PERMITTED;

    private Chito chito = new Chito();

    public User toUser(PasswordEncoder passwordEncoder)
    {
        return new User(username, passwordEncoder.encode(password), Role, chito);
    }
}
