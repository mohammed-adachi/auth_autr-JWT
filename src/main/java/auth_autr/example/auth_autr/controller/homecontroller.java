package auth_autr.example.auth_autr.controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class homecontroller {
@GetMapping("/home")
public ResponseEntity<Map<String, String>> home() {
    Map<String, String> response = new HashMap<>();
    response.put("message", "home page");
    return ResponseEntity.ok(response); // Renvoie un objet JSON avec la clé "message"
}
@GetMapping("/store")
public String store() {
    return "store page";
}
@GetMapping("/admin/home")
public String adminhome() {
    return "admin home page";
}
@GetMapping("/client/home")
public String clienthome() {
    return "client home page";
}

}
