package dev.oerebor.marketplace.services;

import dev.oerebor.marketplace.entities.UserEntity;
import dev.oerebor.marketplace.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private IUserRepository userRepository;
    
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }
    
    public UserEntity findById(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        
       return user.get();
    }
    
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }
    
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    public UserEntity updateUser(Long id, UserEntity user) {
        UserEntity newUser = userRepository.getReferenceById(id);
        
        updateUserData(newUser, user);
        
        return userRepository.save(newUser);
    }
    
    private void updateUserData(UserEntity newUser, UserEntity user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPhone(user.getPhone());
    }
}
