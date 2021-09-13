
package main.model;

import main.entity.UserEntity;

public class User {

  private int userId;
  private String name;
  private String mail;

  public static User toModel(UserEntity entity) {
    User model = new User();
    model.setUserId(entity.getUserId());
    model.setName(entity.getName());
    model.setMail(entity.getMail());
    return model;
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

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }
}

