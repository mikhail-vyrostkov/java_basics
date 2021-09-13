package main.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_User")
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "User_ID")
  private int userId;
  @Column(name = "Name")
  private String name;
  @Column(name = "Pass")
  private String pass;
  @Column(name = "Mail")
  private String mail;

  @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
  private List<AuditEntity> audits;

  @OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
  private TokenEntity accessToken;

  public UserEntity() {
  }

  public List<AuditEntity> getAudits() {
    return audits;
  }

  public void setAudits(List<AuditEntity> audits) {
    this.audits = audits;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public TokenEntity getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(TokenEntity accessToken) {
    this.accessToken = accessToken;
  }
}
