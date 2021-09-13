
package main.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tAccessToken")
public class TokenEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Token_ID")
  private int tokenId;
  @Column(name = "ExpireDate")
  private Date expireDate;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "User_ID")
  private UserEntity user;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "Audit_ID")
  private AuditEntity audit;


  public TokenEntity() {
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

  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }

  public AuditEntity getAudit() {
    return audit;
  }

  public void setAudit(AuditEntity audit) {
    this.audit = audit;
  }
}

