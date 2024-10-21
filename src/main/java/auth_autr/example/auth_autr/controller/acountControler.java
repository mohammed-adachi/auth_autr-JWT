package auth_autr.example.auth_autr.controller;

import java.time.Instant;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.nimbusds.jose.jwk.source.ImmutableSecret;

import auth_autr.example.auth_autr.models.registerDLO;
import auth_autr.example.auth_autr.models.user;
import auth_autr.example.auth_autr.repositry.userrepositry;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/acount")
public class acountControler {
  @Value("${security.jwt.secret-key}")
  private String secretKey;
  @Value("${security.jwt.issuer}")
    private String issuer;
 @Autowired
 private userrepositry userrepositry; 

  @PostMapping("/register")
  public ResponseEntity<Object> register(@ Valid @RequestBody registerDLO registerDLO ,BindingResult result){
    if(result.hasErrors()){
      var  errorlist= result.getAllErrors();
      var errorMap= new HashMap<String,String>();
      for(var error:errorlist){
        errorMap.put(error.getObjectName(),error.getDefaultMessage());
      }
      return ResponseEntity.badRequest().body(errorMap);
    }
    
   var bCryptPassword= new BCryptPasswordEncoder();
    var user= new user();

    user.setUsername(registerDLO.getUsername());
    user.setPassword(bCryptPassword.encode(registerDLO.getPassword()));
    user.setEmail(registerDLO.getEmail());
    user.setRole("ROLE_USER");
   
    try {
      var otheruser= userrepositry.findByUsername(registerDLO.getUsername());
      if(otheruser != null){
        return ResponseEntity.badRequest().body("user already exist");
      }

      var otheruseremail= userrepositry.findByEmail(registerDLO.getEmail());
      if(otheruseremail != null){
        return ResponseEntity.badRequest().body("email already exist");
      }
      userrepositry.save(user);
      
      var response= new HashMap<String,Object>();
      response.put("user",user);
      response.put("token",createJwtToken(user));
      return ResponseEntity.ok(response);

    } catch (Exception e) {
      System.out.println("is ana exception");
      e.printStackTrace();
    }
    return ResponseEntity.badRequest().body("error");
  }

    private String createJwtToken(user user){
    Instant now = Instant.now();
    JwtClaimsSet claims = JwtClaimsSet.builder()
    .subject(user.getUsername())
    .issuer(issuer)
    .issuedAt(now)
    .claim("role", user.getRole())
    .subject(user.getUsername())
    .expiresAt(now.plusSeconds(60))    
    .build();
    var encoder= new NimbusJwtEncoder(new ImmutableSecret<>(secretKey.getBytes()));
    var parms= JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS256).build(),claims);
     return encoder.encode(parms).getTokenValue();  
    }

}
