package ex.plea.component;

import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
/**
 * UserDetails를 구현함으로 인해 해당사용자에게 부여된 권한과 해당사용자 계정을 사용할 수 있는지의 여부등을
 * 알려줄 수 있다.
 */
@Entity
@Table
public class User implements UserDetails {
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

    private Chito chito;

    protected User(){

    }

    public User(String username, String password, UserRole role, Chito chito)
    {
        this.username = username;
        this.password = password;
        this.Role = role;
        this.chito = chito;
    }


    @Override
    // 해당 사용자에게 부여된 권한을 저장한 컬렉션을 반환
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    //expired 시리즈는 해당 사용자의 계정을 활성화 시킬것인지 아닌지 설정해주는것 여기서는 비활성화할 필요가 없어서 다 true로 해주었다.
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
