package dev.oerebor.marketplace.services;

import dev.oerebor.marketplace.entities.UserEntity;
import dev.oerebor.marketplace.repositories.IUserRepository;
import dev.oerebor.marketplace.services.exceptions.DatabaseException;
import dev.oerebor.marketplace.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        
       return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }
    
    public void deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
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
