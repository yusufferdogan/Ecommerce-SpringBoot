package ECommerce.Services;

import ECommerce.Domains.User;
import ECommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    UserService(UserRepository repository){
        this.repository = repository;
    }
   public Optional<User> addUser(String name, String lastName) {
        User user = new User();
        user.setFirstName(name);
        user.setLastName(lastName);
        user.setCreationDate(LocalDateTime.now());
        user.setModifyDate(LocalDateTime.now());
        return Optional.of(repository.save(user));
   }

   public Optional<User> getUser(Long id){
        return repository.findById(id);
   }

}
