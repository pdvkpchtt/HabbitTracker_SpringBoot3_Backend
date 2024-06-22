package com.example.firstapp.users;

import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
public class UsersContorller {

    private final UsersRepository usersRepository;

    public UsersContorller(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping
    public List<Users> getUsers() {
        return usersRepository.findAll();
    }

    record NewUsersRequest (String name, String avatart) {

    }

    @PostMapping
    public void addUser(@RequestBody NewUsersRequest request) {
        Optional<Users> userByEmail = usersRepository.findUsersByName(request.name());

        if (userByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }

        Users users = new Users();
        users.setName(request.name());
        users.setAvatart(request.avatart());
        usersRepository.save(users);
    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable("userId") Integer id) {
        boolean existCheck = usersRepository.existsById(id);

        if (!existCheck) {
            throw new IllegalStateException("No user found");
        }

        usersRepository.deleteById(id);
    }

    @PutMapping("{userId}")
    @Transactional
    public void editUser(@RequestBody NewUsersRequest request, @PathVariable("userId") Integer id) {

        Users users = usersRepository.findById(id).orElseThrow(() -> new IllegalStateException("No user found"));

        if (request.name() == null || request.name().length() < 3) {
            throw new IllegalStateException("Name must be utleast 3 symbols long");
        }

        if (users != null) {
            users.setName(request.name());
            users.setAvatart(request.avatart());
            usersRepository.save(users);
        }
    }
}
