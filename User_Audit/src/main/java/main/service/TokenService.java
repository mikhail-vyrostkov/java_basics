package main.service;

import main.entity.TokenEntity;
import main.exception.TokenNotFoundException;
import main.model.Token;
import main.repository.TokenRepository;
import main.repository.AuditRepository;
import main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private AuditRepository auditRepository;
  @Autowired
  private TokenRepository accessTokenRepository;

  public Token getOneToken(int id) throws TokenNotFoundException {
    TokenEntity token = accessTokenRepository.findById(id).get();
    if (token == null) {
      throw new TokenNotFoundException("Токен не найден!");
    }
    return Token.toModel(token);
  }
}
