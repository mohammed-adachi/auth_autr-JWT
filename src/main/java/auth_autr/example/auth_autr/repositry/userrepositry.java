package auth_autr.example.auth_autr.repositry;
import auth_autr.example.auth_autr.models.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userrepositry extends JpaRepository<user, Integer> {
  public  user findByUsername(String username);
  public   user findByEmail(String email);

}
