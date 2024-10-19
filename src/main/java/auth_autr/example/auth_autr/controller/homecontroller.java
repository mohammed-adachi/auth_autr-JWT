package auth_autr.example.auth_autr.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class homecontroller {
@GetMapping("/home")
public String home() {
    return "home page";
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
