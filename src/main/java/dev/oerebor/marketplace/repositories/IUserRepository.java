package dev.oerebor.marketplace.repositories;

import dev.oerebor.marketplace.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {

}
