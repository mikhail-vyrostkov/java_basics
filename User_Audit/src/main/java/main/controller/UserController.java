package main.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import main.entity.UserEntity;
import main.exception.UserAlreadyExistException;
import main.exception.UserNotFoundException;
import main.repository.UserRepository;
import main.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private static Logger logger = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private UserService userService;

/*  @GetMapping
  public ResponseEntity getUsers() {
    userService.getAllUsers();
    return ResponseEntity.ok("Пользователи успешно получены!");
  }*/

  @PostMapping
  public ResponseEntity addUser(@RequestBody UserEntity user) {
    try {
      userService.addUser(user);
      return ResponseEntity.ok("Пользователь успешно сохранен!");
    } catch (UserAlreadyExistException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Ошибка ввода данных!");
    }
  }

  @GetMapping
  public ResponseEntity getUser(@RequestParam int id) {
    try {
      logger.info("Каких пользовательей ищут: " + userService.getOneUser(id));
      return new ResponseEntity<>(userService.getOneUser(id), HttpStatus.OK);
    } catch (UserNotFoundException e) {
      logger.error("Обьект не найден: " + HttpStatus.NOT_FOUND);
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Произошла ошибка!");
    }
  }

  @PutMapping
  public ResponseEntity editUser(@RequestBody UserEntity user) {
    try {
      userService.editUser(user);
      return ResponseEntity.ok("Пользователь успешно изменен!");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Ошибка ввода данных!");
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteUser(@PathVariable int id) {
    try {
      userService.deleteUser(id);
      return ResponseEntity.ok(userService.deleteUser(id));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Произошла ошибка!");
    }
  }
}
