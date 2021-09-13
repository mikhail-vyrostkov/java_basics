package main.controller;

import main.entity.AuditEntity;
import main.service.AuditSevice;
import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/audits")
public class AuditController {

  @Autowired
  private AuditSevice auditSevice;

  @PostMapping
  public ResponseEntity addAudit(@RequestBody AuditEntity audit, @RequestParam int userId) {
    try {
      return ResponseEntity.ok(auditSevice.addAudit(audit, userId));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Произошла ошибка");
    }
  }

  @GetMapping
  public ResponseEntity getOneAudit(@RequestParam int userId) {
    try {
      return ResponseEntity.ok(auditSevice.getOneAudit(userId));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Произошла ошибка");
    }
  }
}
