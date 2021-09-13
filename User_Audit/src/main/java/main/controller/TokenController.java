package main.controller;

import main.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tokens")
public class TokenController {

  @Autowired
  private TokenService accessTokenService;

  @GetMapping
  public ResponseEntity getOneToken(@RequestParam int userId) {
    try {
      return ResponseEntity.ok(accessTokenService.getOneToken(userId));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Произошла ошибка");
    }
  }

}
