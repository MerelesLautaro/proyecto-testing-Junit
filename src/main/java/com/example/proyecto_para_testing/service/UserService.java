package com.example.proyecto_para_testing.service;

import com.example.proyecto_para_testing.model.User;
import com.example.proyecto_para_testing.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepo;

    @Override
    public void saveUser(User user) {
        if(user == null) return;
        userRepo.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User findUser(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void editUser(Long id, User user) {
        if(user == null) return;
        User userEdit = this.findUser(id);

        userEdit.setId(user.getId());
        userEdit.setName(user.getName());
        userEdit.setLastName(user.getLastName());
        userEdit.setEmail(user.getEmail());
        userEdit.setPassword(user.getPassword());
        userEdit.setDateOfBirth(user.getDateOfBirth());

        this.saveUser(userEdit);
    }

    @Override
    public String login(String email, String password) {
        Optional<User> optionalUser = getUsers().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            // Validar la contraseña
            if (user.getPassword().equals(password)) {
                return "Ingresado"; // Autenticación exitosa
            } else {
                return "Contraseña incorrecta";
            }
        } else {
            return "Usuario no encontrado";
        }
    }
}
