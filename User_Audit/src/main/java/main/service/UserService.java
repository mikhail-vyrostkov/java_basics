package main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import main.entity.UserEntity;
import main.exception.UserAlreadyExistException;
import main.exception.UserNotFoundException;
import main.model.User;
import main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;


  public UserEntity addUser(UserEntity user) throws UserAlreadyExistException {
    if (userRepository.findByName(user.getName()) != null) {
      throw new UserAlreadyExistException("Пользователь с таким имененм уже существует!");
    }
    return userRepository.save(user);
  }

  public List<User> getAllUsers() {
    Iterable<UserEntity> userIterable = userRepository.findAll();
    ArrayList<User> users = new ArrayList<>();
    for (UserEntity user : userIterable) {
      users.add(User.toModel(user));
    }
    return users;
  }

  public User getOneUser(int id) throws UserNotFoundException {
    UserEntity user = userRepository.findById(id).get();
    if (user == null) {
      throw new UserNotFoundException("Пользователь не найден!");
    }
    return User.toModel(user);
  }

  public User editUser(UserEntity user) {
    userRepository.save(user);
    return User.toModel(user);
  }

  public int deleteUser(int id) {
    userRepository.deleteById(id);
    return id;
  }
}
