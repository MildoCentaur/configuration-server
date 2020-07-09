package ar.com.eureka.configurationsever;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("health-check")
public class HealthCheckController {
  @Value("${encrypt.key}")
  String key1;
  @Value("${spring.security.user.name}")
  String name;
  @Value("${spring.security.user.password}")
  String password;

  @GetMapping("health-check/security")
  String configurations() {
    return key1 + " "+name +" "+password ;
  }

}
