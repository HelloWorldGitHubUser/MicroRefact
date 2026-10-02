package com.lakesidemutual.domain.identityaccess;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import com.lakesidemutual.infrastructure.UserLoginRepository;
import org.microserviceapipatterns.domaindrivendesign.DomainService;
@Component
public class UserDetailsServiceImpl implements DomainService,UserDetailsService{

@Autowired
 private  UserLoginRepository userRepository;


@Override
public UserDetails loadUserByUsername(String email){
    UserLoginEntity user = this.userRepository.findByEmail(email);
    if (user == null) {
        return null;
    } else {
        return new UserSecurityDetails(user.getId(), user.getEmail(), user.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList(user.getAuthorities()));
    }
}


}