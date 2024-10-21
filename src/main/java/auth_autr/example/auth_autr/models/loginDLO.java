package auth_autr.example.auth_autr.models;

import jakarta.validation.constraints.NotEmpty;

public class loginDLO {
@NotEmpty
private String password;
@NotEmpty
private String username;

public  String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
public  String getUsername() {
    return username;
}
public void setUsername(String username) {
    this.username = username;
}

}
