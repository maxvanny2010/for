package forum.control;

import forum.model.Role;
import forum.service.user.UserService;
import forum.service.user.UserServiceAbs;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * RegistrationControl.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/17/2020
 */
@Controller
//@EnableWebSecurity
public class RegistrationControl {
    private final InMemoryUserDetailsManager registration;
    /**
     * field a encoder.
     */
    private final PasswordEncoder encoder;
    /**
     * field a users service.
     */
    private final UserServiceAbs users;

    public RegistrationControl(final InMemoryUserDetailsManager registration,
                               final PasswordEncoder aEncoder,
                               final UserService aService) {
        this.registration = registration;
        this.encoder = aEncoder;
        this.users = aService;
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute final forum.model.User user) {
        final boolean isUser = this.registration.userExists(user.getUsername());
        if (!isUser) {
            user.setEnable(true);
            //пробовал и USER/ ROLE_USER
            user.setAuthority(Role.USER);
            user.setPassword(this.encoder.encode(user.getPassword()));
            this.users.add(user);
            // п.2 по моим вопросам:
            // я делал этот вариант в прошлый раз. он не работает.
            // Логин не пропускает этого нового юзера.
            // скорее всего я добавляю его не правильно и его нет в памяти.
                 /*       this.registration.createUser(User
                    .withUsername(user.getUsername())
                    .password(user.getPassword())
                    .roles(user.getRole().name())
                    .build());*/

            //Сделал ещё одним вариантом. но то же без результатно.
            // иногда как в первом так и втором варианте бросает ошибку:
            // https://gyazo.com/3d3aa1e298db5b1c98eb3ef7251b8573
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(user.getRole().name()));
            UserDetails userDetails = new User(user.getUsername(), user.getPassword(), authorities);
            this.registration.createUser(userDetails);
        }
        return "redirect:/login";
    }

    @GetMapping("/registration")
    public final String moveToRegistration() {
        return "registration";
    }
}
