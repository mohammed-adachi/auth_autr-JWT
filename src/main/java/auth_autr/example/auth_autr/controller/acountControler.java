package auth_autr.example.auth_autr.controller;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import com.nimbusds.jose.jwk.source.ImmutableSecret;

import auth_autr.example.auth_autr.models.user;

@RestController
@RequestMapping("/acount")
public class acountControler {
  @Value("${security.jwt.token.secret-key}")
  private String secretKey;
  @Value("${security.jwt.issuer}")
    private String issuer;
    private createJwtToken( user user){
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
     return encoder.encode(parms);  
    }

}
