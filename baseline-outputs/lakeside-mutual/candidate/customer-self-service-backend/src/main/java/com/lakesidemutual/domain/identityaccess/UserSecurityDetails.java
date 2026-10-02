package com.lakesidemutual.domain.identityaccess;
 import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
public class UserSecurityDetails implements UserDetails{

 private  long serialVersionUID;

 private  Boolean accountNonExpired;

 private  Boolean accountNonLocked;

 private  Collection<? extends GrantedAuthority> authorities;

 private  Boolean credentialsNonExpired;

 private  String email;

 private  Boolean enabled;

 private  Long id;

 private  String password;

public UserSecurityDetails(Long id, String email, String password, Collection<? extends GrantedAuthority> authorities) {
    this.setId(id);
    this.setUsername(email);
    this.setPassword(password);
    this.setEmail(email);
    this.setAuthorities(authorities);
}
public void setCredentialsNonExpired(Boolean credentialsNonExpired){
    this.credentialsNonExpired = credentialsNonExpired;
}


@JsonIgnore
public Boolean getCredentialsNonExpired(){
    return this.credentialsNonExpired;
}


public void setPassword(String password){
    this.password = password;
}


public void setUsername(String username){
    this.password = username;
}


public void setAccountNonLocked(Boolean accountNonLocked){
    this.accountNonLocked = accountNonLocked;
}


public void setAccountNonExpired(Boolean accountNonExpired){
    this.accountNonExpired = accountNonExpired;
}


public Long getId(){
    return this.id;
}


@Override
public boolean isAccountNonLocked(){
    return this.getAccountNonLocked();
}


@JsonIgnore
public Boolean getAccountNonLocked(){
    return this.accountNonLocked;
}


@Override
public Collection<? extends GrantedAuthority> getAuthorities(){
    return this.authorities;
}


@Override
public String getUsername(){
    return this.email;
}


public void setEnabled(Boolean enabled){
    this.enabled = enabled;
}


@Override
@JsonIgnore
public String getPassword(){
    return this.password;
}


public void setEmail(String email){
    this.email = email;
}


@Override
public boolean isAccountNonExpired(){
    return this.getAccountNonExpired();
}


@Override
public boolean isCredentialsNonExpired(){
    return this.getCredentialsNonExpired();
}


public void setAuthorities(Collection<? extends GrantedAuthority> authorities){
    this.authorities = authorities;
}


@JsonIgnore
public Boolean getEnabled(){
    return this.enabled;
}


@Override
public boolean isEnabled(){
    return this.getEnabled();
}


public String getEmail(){
    return this.email;
}


public void setId(Long id){
    this.id = id;
}


@JsonIgnore
public Boolean getAccountNonExpired(){
    return this.accountNonExpired;
}


}