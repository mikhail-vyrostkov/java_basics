package main.service;

import java.util.Optional;
import main.entity.AuditEntity;
import main.entity.UserEntity;
import main.exception.AuditNotFoundException;
import main.exception.UserNotFoundException;
import main.model.Audit;
import main.model.User;
import main.repository.AuditRepository;
import main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditSevice {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private AuditRepository auditRepository;

  public Audit addAudit(AuditEntity audit, int userId) {
    UserEntity user = userRepository.findById(userId).get();
    audit.setUser(user);
    return Audit.toModel(auditRepository.save(audit));
  }

  public Audit getOneAudit(int id) throws AuditNotFoundException {
    AuditEntity audit = auditRepository.findById(id).get();
    if (audit == null) {
      throw new AuditNotFoundException("Аудит не найден!");
    }
    return Audit.toModel(audit);
  }

}
