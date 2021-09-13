package main.model;

import java.util.Date;
import main.entity.TokenEntity;


public class Token {
  private int tokenId;
  private Date expireDate;

  public static Token toModel(TokenEntity entity){
    Token token = new Token();
    token.setTokenId(entity.getTokenId());
    token.setExpireDate(entity.getExpireDate());
    return token;
  }

  public Token() {
  }

  public int getTokenId() {
    return tokenId;
  }

  public void setTokenId(int tokenId) {
    this.tokenId = tokenId;
  }

  public Date getExpireDate() {
    return expireDate;
  }

  public void setExpireDate(Date expireDate) {
    this.expireDate = expireDate;
  }
}
