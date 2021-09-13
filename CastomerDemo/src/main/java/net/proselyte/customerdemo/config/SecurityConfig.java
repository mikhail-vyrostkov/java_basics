package net.proselyte.customerdemo.config;

import net.proselyte.customerdemo.model.Permission;
import net.proselyte.customerdemo.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final UserDetailsService userDetailsService;

  @Autowired
  public SecurityConfig(@Qualifier("customerDetailsServiceImpl")
      UserDetailsService userDetailsService) {
    this.userDetailsService = userDetailsService;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers(HttpMethod.GET,"/api/**").hasAuthority(Permission.CUSTOMERS_READ.getPermission())
        .antMatchers(HttpMethod.POST,"/api/**").hasAuthority(Permission.CUSTOMERS_WRITE.getPermission())
        .antMatchers(HttpMethod.PUT,"/api/**").hasAuthority(Permission.CUSTOMERS_WRITE.getPermission())
        .antMatchers(HttpMethod.DELETE,"/api/**").hasAuthority(Permission.CUSTOMERS_WRITE.getPermission())
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
        .loginPage("/auth/login").permitAll()
        .defaultSuccessUrl("/auth/success")
        .and()
        .logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout", "POST"))
        .invalidateHttpSession(true)
        .clearAuthentication(true)
        .deleteCookies("JSESSIONID")
        .logoutSuccessUrl("/auth/login");
  }


  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(daoAuthenticationProvider());
  }

  @Bean
  protected PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder(12);
  }

  @Bean
  protected DaoAuthenticationProvider daoAuthenticationProvider(){
    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
    daoAuthenticationProvider.setUserDetailsService(userDetailsService);
    return daoAuthenticationProvider;
  }

}
