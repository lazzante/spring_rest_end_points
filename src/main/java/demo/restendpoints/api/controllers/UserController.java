package demo.restendpoints.api.controllers;

import demo.restendpoints.entities.User;
import demo.restendpoints.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return userService.getAllUsers();
    }


    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody User user) throws Exception {
        return userService.addUser(user);
    }


    @GetMapping("/user/{id}")
    ResponseEntity<User> findUserById(@PathVariable("id") int id) {

        return userService.findUserById(id);

    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") int id,@RequestBody User user) throws Exception {
        return userService.updateUser(id,user);
    }


    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id){
        return userService.deleteUser(id);
    }

}
