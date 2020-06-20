package forum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * SecurityConfig.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/18/2020
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected final void configure(final AuthenticationManagerBuilder auth)
            throws Exception {
        final PasswordEncoder pass = this.passwordEncoder();
        auth.inMemoryAuthentication()
                .passwordEncoder(pass)
                .withUser("user")
                .password(pass.encode("secret"))
                .roles("USER")
                .and()
                .withUser("admin")
                .password(pass.encode("secret"))
                .roles("USER", "ADMIN");
    }

    /**
     * Method to get.
     *
     * @return encoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected final void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/forum", "/login", "/registration", "/post")
                .permitAll()
                .antMatchers("/**").authenticated()
                .antMatchers("/cabinet").hasAnyRole("USER", "ADMIN")
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/forum")
                .failureUrl("/login?error=true")
                .usernameParameter("username").passwordParameter("password")
                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
                .and()
                .csrf().disable();
    }

    @Override
    public final void configure(final WebSecurity web) {
        web.ignoring()
                .antMatchers("/resources/", "/js/message.js");
    }
}
