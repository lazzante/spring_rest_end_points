package demo.restendpoints.services;

import demo.restendpoints.entities.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService  {

    ResponseEntity<List<User>> getAllUsers();

    ResponseEntity<String> addUser(User user) ;

    ResponseEntity<User> findUserById(int id) ;

    ResponseEntity<String> updateUser(int id,User user) ;

    ResponseEntity<String> deleteUser(int id);



}
