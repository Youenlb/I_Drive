package idrive.webapp.service;

import idrive.webapp.exception.InvalidPasswordException;
import idrive.webapp.exception.EmailAlreadyUseException;
import idrive.webapp.exception.UserDontExistException;
import idrive.webapp.exception.UserSuspendedException;
import idrive.webapp.repository.UserRepository;
import idrive.webapp.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public User createUser(User user) throws EmailAlreadyUseException
    {
        // if user exists
        if(userRepository.existsByEmail(user.getEmail()))
        {
            throw new EmailAlreadyUseException("L'email " + user.getEmail() + " est déjà utilisé");
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserDontExistException("Cette utilisateur n'existe pas"));
    }

    //Test de création de branch
    @Override
    public User updateUser(Long id, User user) {
        return userRepository.findById(id)
                .map(user1 -> {
                    user1.setUsername(user.getUsername());
                    user1.setPassword(user.getPassword());
                    user1.setIsAdmin(user.getIsAdmin());
                    return userRepository.save(user1);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User deleted with id " + id;
    }

    @Override
    public User login(String username, String password) throws UserDontExistException, InvalidPasswordException, UserSuspendedException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UserDontExistException("Cette utilisateur n'existe pas");
        }
        if (!user.getPassword().equals(password)) {
            throw new InvalidPasswordException("Mot de passe incorrect");
        }
        return user;
    }
}
