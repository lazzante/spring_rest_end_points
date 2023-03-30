package demo.restendpoints.services;

import demo.restendpoints.entities.User;
import demo.restendpoints.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> addUser(User user) {


        User savedUser = userRepository.save(user);

        if (userRepository.existsById(savedUser.getId())) {
            return new ResponseEntity<>("User Saved In Database", HttpStatus.OK);

        } else {
            return new ResponseEntity<>("Error! User Can Not Saved In Database !", HttpStatus.NOT_FOUND);
        }

    }


    @Override
    public ResponseEntity<User> findUserById(int id) {
        Optional<User> foundUser = userRepository.findById(id);
        if (!foundUser.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            User _user = foundUser.get();
            return new ResponseEntity<>(_user, HttpStatus.OK);
        }

    }

    @Override
    public ResponseEntity<String> updateUser(int id, User user) {
        Optional<User> foundUser = userRepository.findById(id);
        if (foundUser.isPresent()) {
            User _user = foundUser.get();
            _user.setFirstname(user.getFirstname());
            _user.setLastname(user.getLastname());
            _user.setEmail(user.getEmail());
            _user.setUsername(user.getUsername());
            _user.setPassword(user.getPassword());
            userRepository.save(_user);
            return new ResponseEntity<>("User Updated Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User Can Not Found By Given Id", HttpStatus.NOT_FOUND);
        }


    }

    @Override
    public ResponseEntity<String> deleteUser(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return new ResponseEntity<>("User Deleted Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User Can Not Found By Given Id", HttpStatus.UNPROCESSABLE_ENTITY);
        }


    }
}
