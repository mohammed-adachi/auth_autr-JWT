package auth_autr.example.auth_autr.service;
import auth_autr.example.auth_autr.models.user;
import auth_autr.example.auth_autr.repositry.userrepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class serviceUser implements UserDetailsService {
    @Autowired
    private userrepositry userrepositry;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      
          var userapp = userrepositry.findByUsername(username);      
        if(userapp != null){
           var springuser=User.withUsername(userapp.getUsername())
           .password(userapp.getPassword())
           .roles(userapp.getRole())
           .build();
              return springuser;
          
       }
       return null;
    }

}
