package am.itspace.bagariocompanycommon.service;

import am.itspace.bagariocompanycommon.entity.Role;
import am.itspace.bagariocompanycommon.entity.User;
import am.itspace.bagariocompanycommon.repository.UserRepository;
import am.itspace.bagaryocompany.exception.DuplicateException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final EmailService emailService;

    private final PasswordEncoder passwordEncoder;

    public void save(User user) throws DuplicateException, MessagingException {
        if (userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new DuplicateException("User already exist!");
        }
        user.setEnable(false);
        user.setVerifyToken(UUID.randomUUID().toString());
        userRepository.save(user);
        emailService.sendHtmlEmail(user.getEmail(),"please verify your email","HI" + user.getName() +
                "\n" + " Please verify your account by clicking on this link " +
                "<a href = \"http://localhost:8080/user/verify?email="
                +user.getName()+"&token="+user.getVerifyToken()+"\">Activate</a>");
    }

    public void verifyUser(String email, String token) throws Exception {
        Optional<User> userByToken = userRepository.findByEmailAndVerifyToken(email, token);

        if (userByToken.isEmpty()){
            throw new Exception("User Does Not Exists With Mail And Token ");
        }
        User user = userByToken.get();
        if (user.isEnable()){
            throw new Exception("User Already Enabled");
        }
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnable(true);
        user.setVerifyToken(null);
        userRepository.save(user);
    }
    public List<User> showAllUser() {
        return userRepository.findAll();
    }
}
