package com.ilyagubarev.concepts.jwt.simple.server.domain.users;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    List<UserEntity> findByLogin(String login);
}
