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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tAudit")
public class AuditEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Audit_ID")
  private int auditId;
  @Column(name = "ActionType")
  private byte actionType;
  @Column(name = "ActionDate")
  private Date actionDate;

  @ManyToOne
  @JoinColumn(name = "User_ID")
  private UserEntity user;

  @OneToOne(cascade = CascadeType.ALL,mappedBy = "audit")
  private TokenEntity accessToken;

  public AuditEntity() {
  }

  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }


  public int getAuditId() {
    return auditId;
  }

  public void setAuditId(int auditId) {
    this.auditId = auditId;
  }

  public byte getActionType() {
    return actionType;
  }

  public void setActionType(byte actionType) {
    this.actionType = actionType;
  }

  public Date getActionDate() {
    return actionDate;
  }

  public void setActionDate(Date actionDate) {
    this.actionDate = actionDate;
  }

  public TokenEntity getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(TokenEntity accessToken) {
    this.accessToken = accessToken;
  }
}
