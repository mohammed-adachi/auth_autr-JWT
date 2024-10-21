package auth_autr.example.auth_autr.models;

import jakarta.validation.constraints.*;

public class registerDLO {
  
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String email;
    private String role;
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
  
   
  


}
