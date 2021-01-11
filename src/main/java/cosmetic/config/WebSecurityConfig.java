package cosmetic.config;

import cosmetic.service.CustomerServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration

//sẽ kích hoạt việc tích hợp Spring Security với Spring MVC.
@EnableWebSecurity

@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomerServiceIml customUserDetailsService;

    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    // cau hinh chi tiet ve bao mat
    protected void configure(HttpSecurity http) throws Exception {
        http
                .headers()
                .frameOptions().sameOrigin()
                .and()
                .authorizeRequests()
                // khai báo đường dẫn của request
                .antMatchers("/admin/**").hasRole("ADMIN")//dang nhap voi quyen admin để vầy mọi requét đều vô dc trừ admin thì muốn vo admin phải đăng nhập đó
                .and()
                .formLogin()
                // truyen parameter
                .passwordParameter("password")
                .usernameParameter("email")
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error")

                // cho phep tat ca deu duoc truy cap
//                .permitAll()
                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/login?logout")
//                .deleteCookies("my-remember-me-cookie")
//                .permitAll()
//                .and()
                .rememberMe()
                .key("my-secure-key")
//                .rememberMeCookieName("my-remember-me-cookie")
//                .tokenRepository(persistentTokenRepository())
//                .tokenValiditySeconds(24 * 60 * 60)
                .and()
                .exceptionHandling()

                // tat loi 403
                .and().csrf().disable()
        ;
    }

//    PersistentTokenRepository persistentTokenRepository() {
//        JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
//        tokenRepositoryImpl.setDataSource(dataSource);
//        return tokenRepositoryImpl;
//    }
}