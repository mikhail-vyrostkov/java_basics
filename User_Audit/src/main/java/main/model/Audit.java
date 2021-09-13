package main.model;

import java.util.Date;
import main.entity.AuditEntity;

public class Audit {

  private int auditId;
  private byte actionType;
  private Date actionDate;

  public static Audit toModel(AuditEntity entity) {
    Audit audit = new Audit();
    audit.setAuditId(entity.getAuditId());
    audit.setActionType(entity.getActionType());
    audit.setActionDate(entity.getActionDate());
    return audit;
  }

  public Audit() {
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
}
