package ECommerce.Controllers;

import ECommerce.Domains.User;
import ECommerce.Dto.UserDto;
import ECommerce.Exception.UserWithSameNameAlreadyExistException;
import ECommerce.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    public final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        Optional<User> result = service.getUser(id);

        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody UserDto userDto){
        Optional<User> optionalUser =  service.addUser(userDto.firstName(), userDto.lastName());

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("Cant Add");
        }

        if(UserDto.isSameUser(userDto,optionalUser.get())) {
            throw new UserWithSameNameAlreadyExistException("User Already added");
        }

        return ResponseEntity.ok(optionalUser.get());
    }
}
