package ex.plea.controller;

import ex.plea.component.Response;
import ex.plea.component.User;
import ex.plea.dto.UserDto;
import ex.plea.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

;

@RestController
@RequestMapping("/register")
@Slf4j
public class RegistrationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public Response processRegistration(UserDto userDto)
    {
        Response response = new Response();
        System.out.println("You Enter Here!");
        try {
            userRepository.save(userDto.toUser(passwordEncoder));
            response.setResponse("success");
            response.setMessage("회원가입을 성공했습니다.");
        }
        catch(Exception e)
        {
            response.setResponse("failed");
            response.setMessage("회원가입을 실패했습니다.");
        }
        return response;
    }


}
