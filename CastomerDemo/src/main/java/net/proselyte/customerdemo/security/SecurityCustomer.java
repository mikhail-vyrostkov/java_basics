package net.proselyte.customerdemo.security;

import java.util.Collection;
import java.util.List;
import lombok.Data;
import net.proselyte.customerdemo.model.Customer;
import net.proselyte.customerdemo.model.Status;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Data
public class SecurityCustomer implements UserDetails {

  private final String username;
  private final String password;
  private final List<SimpleGrantedAuthority> authorities;
  private final boolean isActive;

  public SecurityCustomer(String username, String password,
      List<SimpleGrantedAuthority> authorities, boolean isActive) {
    this.username = username;
    this.password = password;
    this.authorities = authorities;
    this.isActive = isActive;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return isActive;
  }

  @Override
  public boolean isAccountNonLocked() {
    return isActive;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return isActive;
  }

  @Override
  public boolean isEnabled() {
    return isActive;
  }

  public static UserDetails fromCustomer(Customer customer){
    return new User(
        customer.getEmail(), customer.getPassword(),
        customer.getStatus().equals(Status.ACTIVE),
        customer.getStatus().equals(Status.ACTIVE),
        customer.getStatus().equals(Status.ACTIVE),
        customer.getStatus().equals(Status.ACTIVE),
        customer.getRole().getAuthorities()
    );
  }
}
